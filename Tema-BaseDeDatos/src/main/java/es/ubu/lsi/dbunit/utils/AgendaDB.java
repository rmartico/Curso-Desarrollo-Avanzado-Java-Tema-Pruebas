package es.ubu.lsi.dbunit.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Gestor de la base de datos Agenda.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raúl Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.0
 */
public class AgendaDB {

	/** Script con el volcado de datos */
	private static final String DATA_BULK = "./data/bulk datos.txt";

	/** Script de creaci�n de la base de datos */
	private static final String SCRIPT = "./data/script db agenda.txt";

	/** Conexi�n */
	private static Connection connection;

	/**
	 * Crea una agenda en memoria con las tablas y sus datos.
	 * 
	 * @throws SQLException
	 *             error en acceso a base de datos
	 * @throws IOException
	 *             error con fichero
	 */
	public static void crearAgenda() throws SQLException, IOException {
		connection = DriverManager.getConnection("jdbc:hsqldb:mem:agenda",
				"sa", "");
		Statement stmt = connection.createStatement();

		// Fase 1: Carga del script de creaci�n de base de datos...
		String sqlCreacion = obtenerScript(SCRIPT);
		stmt.executeUpdate(sqlCreacion);

		// Fase 2: Carga de datos...
		String sqlCargaDatos = obtenerScript(DATA_BULK);
		stmt.executeUpdate(sqlCargaDatos);

		// Cierre
		stmt.close();
		// Base de datos creada en memoria.
	}

	/**
	 * Crea una agenda en memoria solo con las tablas.
	 * 
	 * @throws SQLException
	 *             error en acceso a base de datos
	 * @throws IOException
	 *             error con fichero
	 */
	public static void crearAgendaSinDatos() throws SQLException, IOException {
		connection = DriverManager.getConnection("jdbc:hsqldb:mem:agenda",
				"sa", "");
		Statement stmt = connection.createStatement();

		// Fase 1: Carga del script de creaci�n de base de datos...
		String sqlCreacion = obtenerScript(SCRIPT);
		stmt.executeUpdate(sqlCreacion);

		// Cierre
		stmt.close();
		// Base de datos creada en memoria.
	}

	/**
	 * Cierre de agenda.
	 * 
	 * @throws SQLException
	 *             error en cierre de base de datos de Agenda
	 */
	public static void cerrarAgenda() throws SQLException {
		connection.close();
	}

	/**
	 * Obtiene la conexión.
	 * 
	 * @return conexión
	 */
	public static Connection getConnection() {
		return connection;
	}


	/**
	 * Obtiene el texto del script a leer
	 * 
	 * @param ruta
	 *            ruta del fichero script
	 * @return texto como cadena sql
	 * @throws FileNotFoundException
	 *             fichero no encontrado
	 * @throws IOException
	 *             error en acceso a fichero
	 */
	private static String obtenerScript(String ruta)
			throws FileNotFoundException, IOException {
		FileReader fr = new FileReader(ruta);
		// En Java 7 se puede usar try-with-resources
		StringBuffer sb = new StringBuffer();
		int c = 0;
		while ((c = fr.read()) != -1) { // mientras no es final de fichero...
			sb.append((char) c);
		}
		fr.close();
		return new String(sb);
	}
}
