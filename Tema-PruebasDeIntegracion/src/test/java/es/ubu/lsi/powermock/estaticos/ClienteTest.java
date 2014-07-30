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
package es.ubu.lsi.powermock.estaticos;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.doThrow;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test de demostracion del uso de PowerMock con metodos estaticos.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raul Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos Lopez</A>
 * @version 1.0
 * 
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Estatico.class)
public class ClienteTest { 

	/**
	 * Test que comprueba invocacion a metodos estaticos.
	 */
	@Test
	public void test1() {
		 // Clase sobre la que se intercepta...
		mockStatic(Estatico.class);
		// Stubbing del metodo estatico sumar:
		// cuando se invoca al metodo sumar con valores (2,2) retorna 4
		when(Estatico.sumar(2, 2)).thenReturn(4);
		// lo mismo con la resta
		when(Estatico.restar(2, 2)).thenReturn(0);

		Cliente cliente = new Cliente(2, 2);	
		// Metodo que invoca a metodo estaticos con stubbing
		int resultadoSuma = cliente.sumar();
		assertThat(resultadoSuma, is(4));
		int resultadoResta = cliente.restar();
		assertThat(resultadoResta, is(0));

		// Verificacion de que se ha invocado al metodo estatico
		PowerMockito.verifyStatic(); // obligatorio antes de comprobar
		Estatico.sumar(2, 2); // comprobar

		// Verificacion de que se ha invocado al metodo estatico
		PowerMockito.verifyStatic(); // obligatorio antes de comprobar
		Estatico.restar(2, 2); // comprobar
	}

	/**
	 * Test que comprueba lanzamiento de excepcion sobre metodo estatico.
	 * 
	 */
	@Test(expected=ArithmeticException.class)
	public void test2() {
		 // Clase sobre la que se intercepta...
		mockStatic(Estatico.class);
		// Lanzar excepcion...
		doThrow(new ArithmeticException()).when(Estatico.class);
		// ... al invocar a restar con estos parametros.
		Estatico.restar(666, 666);

		// Operaciones sobre el cliente.
		Cliente cliente = new Cliente(0, 0);
		cliente.setA(666);
		cliente.setB(666);
		cliente.restar(); // intentamos restar, DEBE lanzar excepcion.
	}
}
