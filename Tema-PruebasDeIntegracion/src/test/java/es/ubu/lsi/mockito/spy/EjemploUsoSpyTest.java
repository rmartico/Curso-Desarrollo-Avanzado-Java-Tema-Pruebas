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
