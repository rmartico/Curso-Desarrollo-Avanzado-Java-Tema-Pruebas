package ejemplos.powermock.privados;

import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test de demostración del uso de PowerMock con método privado.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raúl Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.0
 * 
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Delegado.class)
public class ClienteTest {

	/**
	 * Test que accede al método privado validar de un delegado "real"
	 * utilizando espías.
	 */
	@Test
	public void test1() throws Exception {
		// Espiamos al delegado
		Delegado delegado = spy(new Delegado());
		// stubbing de método privado
		// no es necesario puesto que la implementación real nos vale
		doReturn(true).when(delegado, "validar", 1);

		// Operaciones sobre el cliente
		Cliente cliente = new Cliente(1, 0, delegado);
		cliente.sumar();
		// Verificamos que el método privado validar se ha invocado
		verifyPrivate(delegado).invoke("validar", 1);
	}
}
