package ejemplos.powermock.estaticos;

import static org.junit.Assert.fail;
import static org.powermock.api.mockito.PowerMockito.doThrow;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.assertThat;

/**
 * Test de demostración del uso de PowerMock con métodos estáticos.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raúl Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.0
 * 
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Estatico.class)
public class ClienteTest {

	/**
	 * Test que comprueba invocación a métodos estáticos.
	 */
	@Test
	public void test1() {
		 // Clase sobre la que se intercepta...
		mockStatic(Estatico.class);
		// Stubbing del método estático sumar:
		// cuando se invoca al método sumar con valores (2,2) retorna 4
		when(Estatico.sumar(2, 2)).thenReturn(4);
		// lo mismo con la resta
		when(Estatico.restar(2, 2)).thenReturn(0);

		Cliente cliente = new Cliente(2, 2);	
		// Método que invoca a método estáticos con stubbing
		int resultadoSuma = cliente.sumar();
		assertThat(resultadoSuma, is(4));
		int resultadoResta = cliente.restar();
		assertThat(resultadoResta, is(0));

		// Verificación de que se ha invocado al método estático
		PowerMockito.verifyStatic(); // obligatorio antes de comprobar
		Estatico.sumar(2, 2); // comprobar

		// Verificación de que se ha invocado al método estático
		PowerMockito.verifyStatic(); // obligatorio antes de comprobar
		Estatico.restar(2, 2); // comprobar
	}

	/**
	 * Test que comprueba lanzamiento de excepción sobre método estático.
	 * 
	 */
	@Test(expected=ArithmeticException.class)
	public void test2() {
		 // Clase sobre la que se intercepta...
		mockStatic(Estatico.class);
		// Lanzar excepción...
		doThrow(new ArithmeticException()).when(Estatico.class);
		// ... al invocar a restar con estos parámetros.
		Estatico.restar(666, 666);

		// Operaciones sobre el cliente.
		Cliente cliente = new Cliente(0, 0);
		cliente.setA(666);
		cliente.setB(666);
		cliente.restar(); // intentamos restar, DEBE lanzar excepción.
	}
}
