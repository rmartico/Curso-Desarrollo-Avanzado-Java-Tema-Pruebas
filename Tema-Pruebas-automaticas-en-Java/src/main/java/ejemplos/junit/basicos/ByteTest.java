package ejemplos.junit.basicos;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Pruebas sobre la clase implementada Byte.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raul Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
 * @version 1.0
 * 
 */
public class ByteTest {	
	
	@Test(expected = FormatoException.class)
	public void constructorSinContenido() throws FormatoException {
		// no es necesario recoger el resultado en una variable
		new Byte("");
	}

	@Test(expected = FormatoException.class)
	public void constructorLongitudGrandePorUno() throws FormatoException {
		// no es necesario recoger el resultado en una variable
		new Byte("010101010");
	}
	
	@Test(expected = FormatoException.class)
	public void constructorLongitudPequeñaPorUno() throws FormatoException {
		// no es necesario recoger el resultado en una variable
		new Byte("0101010");
	}
	
	@Test(expected = FormatoException.class)
	public void constructorLongitudPequeñaUnElemento() throws FormatoException {
		// no es necesario recoger el resultado en una variable
		new Byte("0");
	}
	
	@Test(expected = FormatoException.class)
	public void constructorNoTieneTodosUnosYCeros() throws FormatoException {
		// no es necesario recoger el resultado en una variable
		new Byte("01020101");
	}

	@Test(expected = FormatoException.class)
	public void constructorNoTieneTodosUnosYCerosConLetra() throws FormatoException {
		// no es necesario recoger el resultado en una variable
		new Byte("A1010101");
	}
	
	@Test
	public void constructorTodoCeros() throws FormatoException {
		// no es necesario recoger el resultado en una variable
		Byte b = new Byte("00000000");
		assertThat(b.toString(),is("00000000"));
	}
	
	@Test
	public void constructorTodoUnos() throws FormatoException {
		// no es necesario recoger el resultado en una variable
		Byte b = new Byte("11111111");
		assertThat(b.toString(),is("11111111"));
	}
	
	@Test
	public void conversionHexTodoCeros() throws FormatoException {
		// no es necesario recoger el resultado en una variable
		Byte b = new Byte("00000000");
		assertThat(b.aHex(),is("00"));
	}
	
	@Test
	public void conversionHexTodoUnos() throws FormatoException {
		// no es necesario recoger el resultado en una variable
		Byte b = new Byte("11111111");
		assertThat(b.aHex(),is("FF"));
	}
	
	@Test
	public void conversionHexA0() throws FormatoException {
		// no es necesario recoger el resultado en una variable
		Byte b = new Byte("10100000");
		assertThat(b.aHex(),is("A0"));
	}
	
	@Test
	public void conversionHex4D() throws FormatoException {
		// no es necesario recoger el resultado en una variable
		Byte b = new Byte("01001101");
		assertThat(b.aHex(),is("4D"));
	}

	@Test
	public void conversionHex9E() throws FormatoException {
		// no es necesario recoger el resultado en una variable
		Byte b = new Byte("10011110");
		assertThat(b.aHex(),is("9E"));
	}
	
	@Test
	public void queNoPruebaNadaConstructor() throws FormatoException {
		// no salta la excepci�n
		@SuppressWarnings("unused")
		Byte b = new Byte("10011110");		
	}
	
	@Test
	public void queNoPruebaNada() throws FormatoException {		
		Byte b = new Byte("10011110");
		assertFalse("No coincidencia de valores.", b.aHex().equals("FF"));
	}
	
	@Test
	public void queNoPruebaNada2() throws FormatoException {
		// no es necesario recoger el resultado en una variable
		Byte b = new Byte("10011110");
		Byte b2 = new Byte("10011110");
		assertEquals("No coincidencia de valores.", b.aHex(),b2.aHex());
	}
}
