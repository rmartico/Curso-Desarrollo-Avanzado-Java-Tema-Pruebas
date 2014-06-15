package es.ubu.lsi.dbunit.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import org.dbunit.database.AmbiguousTableNameException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.database.search.TablesDependencyHelper;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.util.search.SearchException;

/**
 * Utilidad para exportar los datos a XML para su uso con dbUnit.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Ra�l Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
 * @version 1.0
 */
public class UtilidadExportacionBaseDatos {

	/**
	 * Exporta los datos de la base de datos Agenda.
	 * 
	 * @param args
	 *            argumentos
	 * @throws Exception
	 * @see AgendaDB
	 */
	public static void main(String[] args) throws Exception {
		AgendaDB.crearAgenda();
		Connection jdbcConnection = AgendaDB.getConnection();
		IDatabaseConnection connection = new DatabaseConnection(jdbcConnection,
				"AGENDA");
		exportacionConDependencias("TIPOSCONTACTO",
				"./data/agenda_completa.xml", connection);
		AgendaDB.cerrarAgenda();
		// Otros ejemplos, se dejan y comentan para los alumnos...
		// exportaci�nCompleta("./data/agenda_completa.xml", connection);
		// exportaci�nParcial("Contactos",
		// "SELECT * FROM CONTACTOS WHERE idContacto > 10",
		// "./contactos_con_id.xml", connection);

	}

	/**
	 * Exportaci�n de una tabla y las que dependen de ella.
	 * 
	 * @param tablaX
	 *            tabla inicia a exportar
	 * @param rutaFicheroSalidaXML
	 *            fichero de salida
	 * @param connection
	 *            conexi�n
	 * @throws SearchException
	 *             error en b�squeda
	 * @throws SQLException
	 *             error en acceso a base de datos
	 * @throws DataSetException
	 *             error en creaci�n
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static void exportacionConDependencias(String tablaX,
			String rutaFicheroSalidaXML, IDatabaseConnection connection)
			throws SearchException, SQLException, DataSetException,
			IOException, FileNotFoundException {
		// exportaci�n de tablas dependientes:
		// exporta la tablaX y todas las tblas que tienen con PK como FK
		// de tablaX en el orden adecuado para insertar datos
		String[] depTableNames = TablesDependencyHelper.getAllDependentTables(
				connection, tablaX);
		IDataSet depDataset = connection.createDataSet(depTableNames);
		FlatXmlDataSet.write(depDataset, new FileOutputStream(
				rutaFicheroSalidaXML));
	}

	/**
	 * Exportaci�n parcial de datos, incluyendo filtrado.
	 * 
	 * @param tabla
	 *            nombre de la tabla
	 * @param sql
	 *            cadena sql con consulta de datos
	 * @param rutaFicheroSalidaXML
	 *            fichero de salida
	 * @param connection
	 * @throws AmbiguousTableNameException
	 * @throws IOException
	 *             error en acceso a fichero
	 * @throws DataSetException
	 *             error en creaci�n del dataset
	 * @throws FileNotFoundException
	 *             si el fichero no se encuentra
	 */
	private static void exportacionParcial(String tabla, String sql,
			String rutaFicheroSalidaXML, IDatabaseConnection connection)
			throws AmbiguousTableNameException, IOException, DataSetException,
			FileNotFoundException {
		// exportaci�n parcial
		QueryDataSet partialDataSet = new QueryDataSet(connection);
		partialDataSet.addTable(tabla, sql);
		FlatXmlDataSet.write(partialDataSet, new FileOutputStream(
				rutaFicheroSalidaXML));
	}

	/**
	 * Exportaci�n completa de la base de datos. OJO puede ser necesario
	 * reordenar los datos para una correcta inserci�n puesto que no revisa las
	 * dependencias.
	 * 
	 * @param rutaFicheroSalidaXML
	 *            ruta del fichero de salida XML
	 * @param connection
	 *            conexi�n
	 * @throws SQLException
	 *             error en acceso a base de datos
	 * @throws IOException
	 *             error en acceso a fichero
	 * @throws DataSetException
	 *             error en creaci�n del dataset
	 * @throws FileNotFoundException
	 *             si el fichero no se encuentra
	 */
	private static void exportacionCompleta(String rutaFicheroSalidaXML,
			IDatabaseConnection connection) throws SQLException, IOException,
			DataSetException, FileNotFoundException {
		IDataSet fullDataSet = connection.createDataSet();
		DatabaseMetaData meta = connection.getConnection().getMetaData();
		System.out.println(meta.toString());
		FlatXmlDataSet.write(fullDataSet, new FileOutputStream(
				rutaFicheroSalidaXML));
	}

}
