/*
 * Copyright © 2014 Arcadia Consulting C.B. . All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification 
 * are not permitted 
 *
 * THIS SOFTWARE IS PROVIDED BY ARCADIA CONSULTING C.B. "AS IS" AND ANY EXPRESS
 * OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE 
 * DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT, 
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT 
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, 
 * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF 
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING 
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, 
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
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
 * Gestión de DTD de una base de datos con dbUnit.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raúl Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.0
 */
public class AgendaDTD {

	/**
	 * Creación de la DTD correspondiente a la base de datos Agenda.
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
		System.out.println("Creada la DTD en el directorio ./data/AGENDA.DTD");
	}

	/**
	 * Crea la DTD de la base de datos
	 * 
	 * @param rutaDTD
	 *            ruta
	 * @param jdbcConnection
	 *            conexión a la base de datos
	 * @throws SQLException
	 *             error en acceso a base de datos
	 * @throws IOException
	 *             error en acceso a fichero
	 * @throws DataSetException
	 *             error en creación del dataset
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
