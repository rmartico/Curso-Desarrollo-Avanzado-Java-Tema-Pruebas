package ejercicios.junit.palindromo;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PalindromoTest {

	private Palindromo palindromo;

	/**
	 * Comprueba la correcta inicialización.
	 * 
	 * @throws PalindromoIncorrectoException
	 * @throws ContenidoNuloException
	 * @throws ContenidoVacioException
	 */
	@Test(expected = ContenidoVacioException.class)
	public void testConstructorVacio() throws ContenidoVacioException,
			ContenidoNuloException, PalindromoIncorrectoException {
		palindromo = new Palindromo("");
	}

	/**
	 * Comprueba la correcta inicialización.
	 * 
	 * @throws PalindromoIncorrectoException
	 * @throws ContenidoNuloException
	 * @throws ContenidoVacioException
	 */
	@Test(expected = ContenidoNuloException.class)
	public void testConstructorNulo() throws ContenidoVacioException,
			ContenidoNuloException, PalindromoIncorrectoException {
		palindromo = new Palindromo(null);
	}
	
	/**
	 * Comprueba la correcta inicialización.
	 * 
	 * @throws PalindromoIncorrectoException
	 * @throws ContenidoNuloException
	 * @throws ContenidoVacioException
	 */
	@Test(expected = PalindromoIncorrectoException.class)
	public void testConstructorNoEsPalindromo() throws ContenidoVacioException,
			ContenidoNuloException, PalindromoIncorrectoException {
		palindromo = new Palindromo("noesunpalindromo");
	}

	/**
	 * Comprueba la correcta inicialización con palindromo de longitud mínima.
	 * 
	 * @throws PalindromoIncorrectoException
	 * @throws ContenidoNuloException
	 * @throws ContenidoVacioException
	 */
	@Test
	public void testConstructorMinimo() throws ContenidoVacioException,
			ContenidoNuloException, PalindromoIncorrectoException {
		palindromo = new Palindromo("a");
		assertThat(palindromo.obtenerTexto(), is("a"));
	}

	/**
	 * Comprueba la correcta inicialización con palindromo de longitud mínima.
	 * 
	 * @throws PalindromoIncorrectoException
	 * @throws ContenidoNuloException
	 * @throws ContenidoVacioException
	 */
	@Test
	public void testConstructorMedio() throws ContenidoVacioException,
			ContenidoNuloException, PalindromoIncorrectoException {
		Palindromo palindromo = new Palindromo("analana");
		assertThat(palindromo.obtenerTexto(), is("analana"));
	}

	/**
	 * Comprueba la correcta inicialización con palindromo de longitud mínima.
	 * 
	 * @throws PalindromoIncorrectoException
	 * @throws ContenidoNuloException
	 * @throws ContenidoVacioException
	 */
	@Test
	public void testAccesoACadenaSomosONoSomos()
			throws ContenidoVacioException, ContenidoNuloException,
			PalindromoIncorrectoException {
		String patron = "Somos o no somos";
		palindromo = new Palindromo(patron);
		assertThat(palindromo.obtenerTexto(), is("Somos o no somos"));

	}

	/**
	 * Comprueba la correcta inicialización con palindromo de longitud mínima.
	 * 
	 * @throws PalindromoIncorrectoException
	 * @throws ContenidoNuloException
	 * @throws ContenidoVacioException
	 */
	@Test
	public void testAccesoACadenaSeEsONoSeEs() throws ContenidoVacioException,
			ContenidoNuloException, PalindromoIncorrectoException {
		String patron = "Se es o no se es";
		palindromo = new Palindromo(patron);
		assertThat(palindromo.obtenerTexto(), is("Se es o no se es"));
	}

	/**
	 * Comprueba la correcta inicialización con palindromo de longitud mínima.
	 * 
	 * @throws PalindromoIncorrectoException
	 * @throws ContenidoNuloException
	 * @throws ContenidoVacioException
	 */
	@Test
	public void testAccesoACadenaLargo() throws ContenidoVacioException,
			ContenidoNuloException, PalindromoIncorrectoException {
		String patron = "A mama Roma le aviva el amor a papa y a papa Roma le aviva el amor a mama";
		palindromo = new Palindromo(patron);
		assertThat(
				palindromo.obtenerTexto(),
				is("A mama Roma le aviva el amor a papa y a papa Roma le aviva el amor a mama"));
	}

}