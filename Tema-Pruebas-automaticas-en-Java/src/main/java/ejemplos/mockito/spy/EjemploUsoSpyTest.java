package ejemplos.mockito.spy;

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
 * de uno de los m�todos reales.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raul Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos Lopez</A>
 * @version 1.0
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class EjemploUsoSpyTest {

	/**
	 * Objeto a espiar. Otra opci�n es 
	 * pila = spy(new Stack<String>());.
	 */
	@Spy
	private List<String> pilaReal = new Stack<String>();
	
	/**
	 * Test usando esp�a.
	 */
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testEspiaConStubbing() {
		// stubbing del m�todo get(0)
		doReturn("hola").when(pilaReal).get(0);
		// no genera excepci�n, se llama al m�todo "falsificado"
		assertThat(pilaReal.get(0),is("hola"));
		// genera excepci�n, llama al m�todo real
		pilaReal.get(1);
	}
}
