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
package es.ubu.lsi.mockito.argumentcaptor;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Ejemplo de uso de captura de argumentos.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raul Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos Lopez</A>
 * @version 1.0
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class EjemploArgumentCaptorTest {

	
	@Captor
	private ArgumentCaptor<List<String>> argumentos;
	
	/**
	 * Objeto a espiar. Otra opción es 
	 * <code>lista = spy(new ArrayList<String>());</code>.
	 */
	@Spy
	List<String> lista = new ArrayList<String>();
	
	/**
	 * Test usando espía.
	 */
	@Test
	public void testArgumentCaptor() {		
		// inyección de dependencias...
		Contenedor contenedor = new Contenedor(lista);
		contenedor.añadir("texto");
		verify(lista).add("texto");
		
		List<String> nuevaLista = Arrays.asList("primero","segundo");
		contenedor.añadir(nuevaLista);
		verify(lista).addAll(argumentos.capture()); // interceptar argumentos
		
		List<String> listaCapturada = argumentos.getValue(); // consultar
		assertThat(listaCapturada,is(Arrays.asList("primero", "segundo")));
	}
}
