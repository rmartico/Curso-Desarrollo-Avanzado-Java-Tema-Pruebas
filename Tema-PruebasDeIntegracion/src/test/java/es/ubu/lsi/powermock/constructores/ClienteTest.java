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
package es.ubu.lsi.powermock.constructores;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.verifyNew;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import org.junit.Rule;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;


/**
 * Test de demostracion del uso de PowerMock con los constructores
 * y las instanciaciones.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raul Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos Lopez</A>
 * @version 1.0
 * 
 */
// @RunWith(PowerMockRunner.class) // Remove using @Rule 
@PrepareForTest({Cliente.class, Delegado.class})
public class ClienteTest {
	
	@Rule
	public PowerMockRule rule = new PowerMockRule();
	
	/**
	 * Test que permite hacer stubbing de invocaciones al constructor del
	 * Delegado sin argumentos, lanzando una excepcion.
	 * 
	 * @throws Exception
	 *             cuando se invoca al constructor de Delegado sin argumentos
	 */
	@Test(expected = Exception.class)
	public void test1() throws Exception {
		whenNew(Delegado.class).withNoArguments().thenThrow(
				new Exception("error message"));
		@SuppressWarnings("unused")
		// al instanciar un cliente, se intenta instanciar un 
		// Delegado sin argumentos
		Cliente cliente = new Cliente(1, 0);
	}
	
	/**
	 * Test con stubbing e intercepcion de instanciacion para poner al
	 * mock delegado como resultado de la instanciacion.
	 * 
	 * @throws Exception si hay algun error
	 */
	@Test
	public void test2() throws Exception {
		Delegado mockDelegado = mock(Delegado.class);
		// Stubbing con comportamiento erroneo
		when(mockDelegado.sumar(1,1)).thenReturn(2011);
		// cuando se instancia un delegado con argumentos (1,1)
		// retornar el mockDelegado que hemos preparado
		whenNew(Delegado.class).withArguments(1,1).thenReturn(mockDelegado);	
		// cliente trabajando con el mock delegado
		Cliente cliente = new Cliente(1, 1, true);
		// engaño completado porque devuelve una suma que no es la real
		// contesta el mockDelegado con el stubbing previo...
		assertThat(cliente.sumar(),is(2011));	
		
		// comportamiento por defecto del mock
		// porque de esta operacion no hemos hecho stubbing
		assertThat(mockDelegado.restar(10, 8),is(0)); 		
	}
	
	/**
	 * Test que comprueba que se realizan un numero de instanciaciones
	 * sobre un cierto tipo.
	 * 
	 * @throws Exception si hay algun error
	 */
	@Test
	public void test3() throws Exception {
		Delegado delegado = new Delegado(); // Delegado "real"
		// Cuando se instancia sin argumentos retornamos el delegado "real"
		whenNew(Delegado.class).withNoArguments().thenReturn(delegado);
		
		for (int i = 0; i <10; i++) {
			@SuppressWarnings("unused")
			// en cada iteracion se instancia un Delegado...
			Cliente cliente = new Cliente(1, 1, true);
		}
		// Comprobamos que se ha invocado al constructor 10 veces.
		verifyNew(Delegado.class, times(10)).withArguments(anyInt(), anyInt());
	}
}
