package es.ubu.lsi.dbunit.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.xml.FlatDtdDataSet;

/**
 * Gesti�n de DTD de una base de datos con dbUnit.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Ra�l Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
 * @version 1.0
 */
public class AgendaDTD {

	/**
	 * Creaci�n de la DTD correspondiente a la base de datos Agenda.
	 * 
	 * @param args
	 *            argumentos
	 * @throws Exception
	 * @see AgendaDB
	 */
	public static void main(String[] args) throws Exception {
		AgendaDB.crearAgenda();
		Connection jdbcConnection = AgendaDB.getConnection();
		crearDTD("./data/AGENDA.DTD", jdbcConnection);
		AgendaDB.cerrarAgenda();
	}

	/**
	 * Crea la DTD de la base de datos
	 * 
	 * @param rutaDTD
	 *            ruta
	 * @param jdbcConnection
	 *            conexi�n a la base de datos
	 * @throws SQLException
	 *             error en acceso a base de datos
	 * @throws IOException
	 *             error en acceso a fichero
	 * @throws DataSetException
	 *             error en creaci�n del dataset
	 * @throws FileNotFoundException
	 *             si el fichero no se encuentra
	 */
	private static void crearDTD(String rutaDTD, Connection jdbcConnection)
			throws SQLException, DatabaseUnitException, FileNotFoundException,
			IOException {
		IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);
		// escribir DTD
		FileOutputStream out = new FileOutputStream(rutaDTD);
		FlatDtdDataSet.write(connection.createDataSet(), out);
		out.flush();
		out.close();
	}
}
