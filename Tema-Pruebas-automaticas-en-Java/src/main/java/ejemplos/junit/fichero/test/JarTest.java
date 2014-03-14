package ejemplos.junit.fichero.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import ejemplos.junit.fichero.compresion.Comprimido;
import ejemplos.junit.fichero.compresion.Jar;
import ejemplos.junit.fichero.io.Fichero;
import ejemplos.junit.fichero.io.FicheroComprimidoException;
import ejemplos.junit.fichero.io.FicheroImpl;
import ejemplos.junit.fichero.io.FicheroNoEncontradoException;

/**
 * Tests de la interfaz fichero.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raúl Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.0
 * 
 */
public class JarTest {

	/** Fixture o instancias a reutilizar en los tests */
	protected Comprimido ficheroZip;
	/** Fixture o instancias a reutilizar en los tests */
	protected Fichero fich1;
	/** Fixture o instancias a reutilizar en los tests */
	protected Fichero fich2;
	/** Fixture o instancias a reutilizar en los tests */
	protected Fichero fich3;

	@Before
	public void inicializar() {
		ficheroZip = new Jar();
		fich1 = new FicheroImpl(100, "fich1", "txt");
		fich2 = new FicheroImpl(100, "fich2", "txt");
	}

	@Test
	public void iniciadoVacio() {
		assertThat("Un fichero zip vacío debería tener tamaño cero",
				ficheroZip.obtenerTamañoComprimido(), is(0.0));
	}

	@Test
	public void iniciadoConUnFicheroVacío() throws FicheroComprimidoException {
		ficheroZip.añadir(new FicheroImpl(0, "fich1", "txt"));
		assertThat("No comprime bien un único fichero vacío",
				ficheroZip.obtenerTamañoComprimido(), is(0.0));
	}

	@Test
	public void iniciadoConUnFichero() throws FicheroComprimidoException {
		ficheroZip.añadir(fich1);
		assertThat("No comprime bien con un fichero añadido",
				ficheroZip.obtenerTamañoComprimido(), is(75.0));
	}

	@Test
	public void iniciadoConDosFicheros() throws FicheroComprimidoException {
		ficheroZip.añadir(fich1);
		ficheroZip.añadir(fich2);
		assertThat("No comprime bien dos ficheros diferentes",
				ficheroZip.obtenerTamañoComprimido(), is(150.0));
	}

	@Test
	public void iniciadoConDosFicherosVacios()
			throws FicheroComprimidoException {
		ficheroZip.añadir(new FicheroImpl(0, "fich1", "txt"));
		ficheroZip.añadir(new FicheroImpl(0, "fich2", "txt"));
		assertThat("Tamaño no nulo al añadir dos ficheros vacíos",
				ficheroZip.obtenerTamañoComprimido(), is(0.0));
	}

	@Test(expected = FicheroComprimidoException.class)
	public void iniciadoConDosFicherosIguales()
			throws FicheroComprimidoException {
		ficheroZip.añadir(fich1);
		ficheroZip.añadir(fich1);
	}

	@Test
	public void iniciadoConDosFicherosBorraUno()
			throws FicheroComprimidoException, FicheroNoEncontradoException {
		ficheroZip.añadir(fich1);
		ficheroZip.añadir(fich2);
		ficheroZip.eliminar(fich1);
		assertThat("No permite borrar un fichero cuando se han añadido dos",
				ficheroZip.obtenerTamañoComprimido(), is(75.0));
	}

	@Test
	public void iniciadoConDosFicherosBorraDos()
			throws FicheroComprimidoException, FicheroNoEncontradoException {
		ficheroZip.añadir(fich1);
		ficheroZip.añadir(fich2);
		ficheroZip.eliminar(fich1);
		ficheroZip.eliminar(fich2);
		assertThat("No borra dos ficheros añadidos dejando vacío el fichero",
				ficheroZip.obtenerTamañoComprimido(), is(0.0));
	}

	@Test(expected = FicheroNoEncontradoException.class)
	public void iniciadoConDosFicherosBorraUnoQueNoExiste()
			throws FicheroComprimidoException, FicheroNoEncontradoException {
		ficheroZip.añadir(fich1);
		ficheroZip.añadir(fich2);
		ficheroZip.eliminar(new FicheroImpl(100, "fich3", "txt"));
	}

	@Test(expected = FicheroNoEncontradoException.class)
	public void iniciadoConDosFicherosIntentaBorrarDosVeces()
			throws FicheroComprimidoException, FicheroNoEncontradoException {
		ficheroZip.añadir(fich1);
		ficheroZip.añadir(fich2);
		ficheroZip.eliminar(fich1);
		ficheroZip.eliminar(fich1); // segundo intento
	}
}
