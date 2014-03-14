package ejemplos.mockito;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.assertThat;

/**
 * Ejemplo b�sico de uso de mocks y stubbing.
 * 
 * Se comprueba la correcta interaccion del cliente con la interfaz java.util.List,
 * comprobando que el numero de invocaciones es el esperado.
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
	 * Comprobando que llama dos veces al m�todo a�adir.
	 */
	@Test
	public void testUsandoLista() {
		// Creaci�n del mock programando expl�citamente
		// en lugar de utilizar el mock inicializado con la anotaci�n
		List<String> listaMock = mock(List.class);
		ClaseATestar cliente = new ClaseATestar();
		cliente.inyectar(listaMock); // inyectamos un mock
		cliente.añadir("uno");
		cliente.añadir("dos");
		// Comprobar que se ha invocado al m�todo a�adir dos veces
		verify(listaMock, times(2)).add(anyString());
	}

	/**
	 * Comprobando que se llama una vez al m�todo a�adir.
	 */
	@Test
	public void testUsandoListaAnotacion() {
		ClaseATestar cliente = new ClaseATestar();
		cliente.inyectar(listaMockAnotacion);
		cliente.añadir("uno");
		// Comprobar que se ha invocado al m�todo a�adir dos veces
		verify(listaMockAnotacion).add(anyString());
	}

	/**
	 * Comprobando que se llama una vez al m�todo a�adir y stubbing comprobando
	 * resultado.
	 */
	@Test
	public void testUsandoListaAnotacionConStubbing() {
		// Stubbing
		when(listaMockAnotacion.get(0)).thenReturn("uno");
		when(listaMockAnotacion.get(1)).thenReturn("dos");
		// Fin stubbing
		ClaseATestar cliente = new ClaseATestar();
		cliente.inyectar(listaMockAnotacion);
		cliente.añadir("uno");
		// Comprobar que se ha invocado al m�todo a�adir dos veces
		verify(listaMockAnotacion).add(anyString());
		assertThat("Texto esperado no coincide.", cliente.consultar(0),
				is("uno"));
		assertThat("Texto esperado no coincide.", cliente.consultar(1),
				is("dos"));
		// si eliminamos el stubbing el test falla...
	}
}
