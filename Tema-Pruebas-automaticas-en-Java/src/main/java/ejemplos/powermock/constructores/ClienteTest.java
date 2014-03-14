package ejemplos.powermock.constructores;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.powermock.api.mockito.PowerMockito.verifyNew;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


/**
 * Test de demostracion del uso de PowerMock con los constructores
 * y las instanciaciones.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raul Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos Lopez</A>
 * @version 1.0
 * 
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Cliente.class, Delegado.class})
public class ClienteTest {

	/**
	 * Test que permite hacer stubbing de invocaciones al constructor
	 * del Delegado sin argumentos, lanzando una excepci�n.
	 * 
	 * @throws Exception cuando se invoca al constructor de Delegado sin argumentos
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
	 * Test con stubbing e intercepci�n de instanciaci�n para poner al
	 * mock delegado como resultado de la instanciaci�n.
	 * 
	 * @throws Exception si hay alg�n error
	 */
	@Test
	public void test2() throws Exception {
		Delegado mockDelegado = mock(Delegado.class);
		// Stubbing con comportamiento err�neo
		when(mockDelegado.sumar(1,1)).thenReturn(2011);
		// cuando se instancia un delegado con argumentos (1,1)
		// retornar el mockDelegado que hemos preparado
		whenNew(Delegado.class).withArguments(1,1).thenReturn(mockDelegado);	
		// cliente trabajando con el mock delegado
		Cliente cliente = new Cliente(1, 1, true);
		// enga�o completado porque devuelve una suma que no es la real
		// contesta el mockDelegado con el stubbing previo...
		assertThat(cliente.sumar(),is(2011));	
		
		// comportamiento por defecto del mock
		// porque de esta operaci�n no hemos hecho stubbing
		assertThat(mockDelegado.restar(10, 8),is(0)); 		
	}
	
	/**
	 * Test que comprueba que se realizan un n�mero de instanciaciones
	 * sobre un cierto tipo.
	 * 
	 * @throws Exception si hay alg�n error
	 */
	@Test
	public void test3() throws Exception {
		Delegado delegado = new Delegado(); // Delegado "real"
		// Cuando se instancia sin argumentos retornamos el delegado "real"
		whenNew(Delegado.class).withNoArguments().thenReturn(delegado);
		for (int i = 0; i <10; i++) {
			@SuppressWarnings("unused")
			// en cada iteraci�n se instancia un Delegado...
			Cliente cliente = new Cliente(1, 1, true);
		}
		// Comprobamos que se ha invocado al constructor 10 veces.
		verifyNew(Delegado.class, times(10)).withArguments(anyInt(), anyInt());
	}
}
