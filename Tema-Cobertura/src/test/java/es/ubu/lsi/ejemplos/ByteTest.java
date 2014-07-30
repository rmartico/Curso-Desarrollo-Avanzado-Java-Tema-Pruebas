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
package es.ubu.lsi.ejemplos;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.JUnitCore;

import es.ubu.lsi.ejemplos.Byte;
import es.ubu.lsi.ejemplos.FormatoException;

/**
 * Pruebas sobre la clase implementada Byte.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raul Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos Lopez</A>
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
		// no salta la excepción
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
	
	public static void main(String[] args) {
		JUnitCore.main("es.ubu.lsi.ejemplos.ByteTest");
	}
}
