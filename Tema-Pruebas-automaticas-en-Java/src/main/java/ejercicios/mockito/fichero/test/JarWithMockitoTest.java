package ejercicios.mockito.fichero.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ejemplos.junit.fichero.compresion.Comprimido;
import ejemplos.junit.fichero.compresion.Jar;
import ejemplos.junit.fichero.io.Fichero;
import ejemplos.junit.fichero.io.FicheroComprimidoException;
import ejemplos.junit.fichero.io.FicheroNoEncontradoException;

/**
 * Solución al ejercicio del testing del fichero Jar utilizando Mockito.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raúl Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.0
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class JarWithMockitoTest {

	protected Comprimido ficheroZip;
	@Mock
	protected Fichero fich1;
	@Mock
	protected Fichero fich2;
	@Mock
	protected Fichero fich3;
	@Mock
	protected Fichero vacío1;
	@Mock
	protected Fichero vacío2;

	@Before
	public void inicializar() {
		ficheroZip = new Jar();
		when(fich1.getNombre()).thenReturn("fich1");
		when(fich1.getExtension()).thenReturn("txt");
		when(fich1.getSize()).thenReturn(100);
		when(fich2.getNombre()).thenReturn("fich2");
		when(fich2.getExtension()).thenReturn("txt");
		when(fich2.getSize()).thenReturn(100);
		when(vacío1.getSize()).thenReturn(0);
	}

	@Test
	public void iniciadoVacio() {
		assertThat("Un fichero zip vacío debería tener tamaño cero",
				ficheroZip.obtenerTamañoComprimido(), is(0.0));
	}

	@Test
	public void iniciadoConUnFicheroVacío() throws FicheroComprimidoException {

		ficheroZip.añadir(vacío1);
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
		ficheroZip.añadir(vacío1);
		ficheroZip.añadir(vacío2);
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
		Fichero fichero3 = mock(Fichero.class);
		ficheroZip.eliminar(fichero3);
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
