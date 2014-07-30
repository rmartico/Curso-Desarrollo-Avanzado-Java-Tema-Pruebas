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
package es.ubu.lsi.mockito;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Ejemplo básico de uso de mocks y stubbing.
 * 
 * Se comprueba la correcta interaccion del cliente con la interfaz
 * java.util.List, comprobando que el numero de invocaciones es el esperado.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raul Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos Lopez</A>
 * @version 1.0
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class EjemploBasicoMockitoTest {

	/**
	 * Creacion de un mock utilizando anotaciones.
	 */
	@Mock
	List<String> listaMockAnotacion;

	/**
	 * Comprobando que llama dos veces al método añadir.
	 */
	@Test
	public void testUsandoLista() {
		// Creación del mock programando explícitamente
		// en lugar de utilizar el mock inicializado con la anotación
		@SuppressWarnings("unchecked")
		List<String> listaMock = mock(List.class);
		
		ClaseATestar cliente = new ClaseATestar();
		cliente.inyectar(listaMock); // inyectamos un mock
		cliente.añadir("uno");
		cliente.añadir("dos");
		
		// Comprobar que se ha invocado al método añadir dos veces
		verify(listaMock, times(2)).add(anyString());
	}

	/**
	 * Comprobando que se llama una vez al método añadir.
	 */
	@Test
	public void testUsandoListaAnotacion() {
		ClaseATestar cliente = new ClaseATestar();
		cliente.inyectar(listaMockAnotacion);
		cliente.añadir("uno");
		
		// Comprobar que se ha invocado al método añadir una vez
		verify(listaMockAnotacion).add(anyString());
	}

	/**
	 * Comprobando que se llama una vez al método añadir 
	 * y stubbing comprobando resultado.
	 */
	@Test
	public void testUsandoListaAnotacionConStubbing() {
		// Stubbing
//		when(listaMockAnotacion.get(0)).thenReturn("uno");
//		when(listaMockAnotacion.get(1)).thenReturn("dos");
		// Fin stubbing
		ClaseATestar cliente = new ClaseATestar();
		cliente.inyectar(listaMockAnotacion);
		cliente.añadir("uno");
		// Comprobar que se ha invocado al método añadir dos veces
		verify(listaMockAnotacion).add(anyString());
		assertThat("Texto esperado no coincide.", cliente.consultar(0),
				is("uno"));
		assertThat("Texto esperado no coincide.", cliente.consultar(1),
				is("dos"));
		// si eliminamos el stubbing el test falla...
	}
}
