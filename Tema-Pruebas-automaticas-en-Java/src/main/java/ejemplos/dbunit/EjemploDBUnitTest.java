package ejemplos.dbunit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.SortedTable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import ejemplos.dbunit.utils.AgendaDB;

/**
 * Ejemplo de test dbUnit sobre operaciones con una base de datos.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Ra�l Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
 * @version 1.0
 */
public class EjemploDBUnitTest extends DBTestCase {

	/** Fichero con base de datos inicial. */
	private static final String AGENDA = "./data/agenda_completa.xml";

	static {
		try {
			AgendaDB.crearAgendaSinDatos();
			AgendaDB.cerrarAgenda();
			// Propiedades para la base de datos de DBUnit
			System.setProperty(
					PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS,
					"org.hsqldb.jdbcDriver");
			System.setProperty(
					PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL,
					"jdbc:hsqldb:mem:agenda");
			System.setProperty(
					PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "sa");
			System.setProperty(
					PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "");
			System.setProperty(
					PropertiesBasedJdbcDatabaseTester.DBUNIT_SCHEMA, "AGENDA");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Constructor.
	 * 
	 * @param nombre
	 *            del test
	 */
	public EjemploDBUnitTest(String nombre) {
		super(nombre);
	}

	/**
	 * Test comprobando que el borrado se realiza correctamente.
	 * 
	 * @throws Exception
	 */
	public void testComprobarBorradoTablaLlamadas() throws Exception {
		// Ejecutar el c�digo que modifica la base datos aqu�...
		IDatabaseConnection con = getConnection();
		Connection jdbcCon = con.getConnection();
		Statement stmt = jdbcCon.createStatement();
		stmt.executeUpdate("DELETE FROM AGENDA.Llamadas");
		stmt.close();

		// Obtener datos actuales
		IDataSet databaseDataSet = getConnection().createDataSet();
		ITable actualTable = databaseDataSet.getTable("Llamadas");

		// Obtener datos esperados de un fichero externo XML
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File(
				"./data/expectedDataSet_llamadasVacio.xml"));
		ITable expectedTable = expectedDataSet.getTable("Llamadas");

		// Comprobar que se cumple lo esperado
		Assertion.assertEquals(expectedTable, actualTable);
	}

	/**
	 * Test comprobando que la actualizaci�n se realiza correctamente.
	 * 
	 * @throws Exception
	 */
	public void testComprobarActualizacionTablaLlamadas() throws Exception {
		// Ejecutar el c�digo que modifica la base datos aqu�...
		IDatabaseConnection con = getConnection();
		Connection jdbcCon = con.getConnection();
		Statement stmt = jdbcCon.createStatement();
		stmt.executeUpdate("UPDATE AGENDA.Llamadas SET horaLlamada='00:00:01'");
		stmt.close();

		// Obtener datos actuales
		IDataSet databaseDataSet = getConnection().createDataSet();
		ITable actualTable = databaseDataSet.getTable("Llamadas");

		// Obtener datos esperados de un fichero externo XML
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File(
				"./data/expectedDataSet_llamadasHoraActualizada.xml"));
		ITable expectedTable = expectedDataSet.getTable("Llamadas");
		// Filtramos s�lo las columnas que est�n en el dataset esperado...
		ITable filteredTable = DefaultColumnFilter.includedColumnsTable(
				actualTable, expectedTable.getTableMetaData().getColumns());
		// Comprobar que se cumple lo esperado
		Assertion.assertEquals(expectedTable, filteredTable);
	}

	/**
	 * Test comprobando que la consulta se realiza correctamente. 
	 * Se utiliza la ordenacion de columnas, dado que el resultado no incluye
	 * clave primaria y podr�a no coincidir el orden de las columnas.
	 * 
	 * @throws Exception
	 */
	public void testComprobarConsulta() throws Exception {
		// Ejecutar el c�digo que modifica la base datos aqu�...
		IDatabaseConnection con = getConnection();
		Connection jdbcCon = con.getConnection();
		Statement stmt = jdbcCon.createStatement();
		stmt.executeQuery("SELECT Nombre,Apellidos FROM AGENDA.Contactos WHERE idTipoContacto=1");
		stmt.close();

		// Obtener datos actuales
		IDataSet databaseDataSet = getConnection().createDataSet();
		ITable actualTable = databaseDataSet.getTable("Contactos");

		// Obtener datos esperados de un fichero externo XML
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File(
				"./data/expectedDataSet_consultaContactos.xml"));
		
		ITable expectedTable = expectedDataSet.getTable("Contactos");
		// Ordenamos los datos
		ITable sortedExpectedTable = new SortedTable(expectedTable);
		// Filtramos s�lo las columnas que est�n en el dataset esperado
		// en el mismo orden
		ITable filteredAndSortedTable = DefaultColumnFilter.includedColumnsTable(
				new SortedTable(actualTable), sortedExpectedTable.getTableMetaData().getColumns());
		
		// Comprobar que se cumple lo esperado
		Assertion.assertEquals(sortedExpectedTable, filteredAndSortedTable);
	}
	
	/**
	 * Obtiene los metadatos y conjunto de datos para cargar en la base de
	 * datos. Fundamental para la correcta inicializaci�n de datos antes de 
	 * cada test.
	 * 
	 * @return base de datos
	 */
	@Override
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(new FileInputStream(AGENDA));
	}

	/**
	 * Redefine configuraci�n de la base de datos utilizada si fuera necesario.
	 * 
	 * @param config
	 *            configuraci�n a manipular
	 */
	@Override
	protected void setUpDatabaseConfig(DatabaseConfig config) {
		// Ejemplo:
		// config.setFeature(DatabaseConfig.FEATURE_BATCHED_STATEMENTS, true);
	}

	/**
	 * Setup - establecer datos - antes de cada test.
	 */
	@Override
	protected DatabaseOperation getSetUpOperation() throws Exception {
		return DatabaseOperation.CLEAN_INSERT;
	}

	/**
	 * Teardown - limpiar datos - antes de cada test.
	 */
	@Override
	protected DatabaseOperation getTearDownOperation() throws Exception {
		return DatabaseOperation.REFRESH;
	}
}
