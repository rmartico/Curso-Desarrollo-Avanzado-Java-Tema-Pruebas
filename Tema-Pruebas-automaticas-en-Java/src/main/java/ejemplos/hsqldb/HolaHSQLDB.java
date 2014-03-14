package ejemplos.hsqldb;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Ejemplo básico con la base de datos en memoria de HSQLDB (HyperSQL)
 * Ver: <a href=>http://hsqldb.org/">HSQLDB</a>
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raúl Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.0
 */
public class HolaHSQLDB {

	/**
	 * Ejemplo básico de conexión y cierre a la base de datos,
	 * equivalente a un HolaMundo inicial.
	 * 
	 * @param args argumentos
	 */
	public static void main(String[] args) {
		 try {
		    Connection connection = DriverManager.getConnection("jdbc:hsqldb:mem:memoriadb");
		    System.out.println("Catálogo actual (debería ser PUBLIC): " + connection.getCatalog());
		    DatabaseMetaData dmd = connection.getMetaData();
		    System.out.println("URL de conexión: " + dmd.getURL().toString());
		    connection.close(); // cerramos
		 } catch (SQLException e) {
			 System.err.println("Error en conexión a la base de datos, revise su CLASSPATH");
			 System.err.println("y añada el fichero hsqldb.jar al mismo.");			
		    e.printStackTrace();
		 }
	}
}