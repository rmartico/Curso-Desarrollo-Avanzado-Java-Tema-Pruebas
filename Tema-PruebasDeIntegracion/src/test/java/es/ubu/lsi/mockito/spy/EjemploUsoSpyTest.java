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
package es.ubu.lsi.mockito.spy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;

import java.util.List;
import java.util.Stack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Ejemplo de uso de espias con anotacion, haciendo stubbing
 * de uno de los métodos reales.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raul Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos Lopez</A>
 * @version 1.0
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class EjemploUsoSpyTest {

	/**
	 * Objeto a espiar. Otra opción es 
	 * pila = spy(new Stack<String>());.
	 */
	@Spy
	private List<String> pilaReal = new Stack<String>();
	
	/**
	 * Test usando espía.
	 */
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testEspiaConStubbing() {
		// stubbing del método get(0)
		doReturn("hola").when(pilaReal).get(0);
		// no genera excepción, se llama al método "falsificado"
		assertThat(pilaReal.get(0),is("hola"));
		// genera excepción, llama al método real
		pilaReal.get(1);
	}
}
