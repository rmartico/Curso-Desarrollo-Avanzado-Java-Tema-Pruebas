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
