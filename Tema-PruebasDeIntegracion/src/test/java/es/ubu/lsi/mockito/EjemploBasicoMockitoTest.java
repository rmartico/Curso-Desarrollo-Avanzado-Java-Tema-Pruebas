package es.ubu.lsi.mockito;

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
 * Ejemplo básico de uso de mocks y stubbing.
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
	 * Comprobando que llama dos veces al método añadir.
	 */
	@Test
	public void testUsandoLista() {
		// Creación del mock programando explícitamente
		// en lugar de utilizar el mock inicializado con la anotación
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
		// Comprobar que se ha invocado al método añadir dos veces
		verify(listaMockAnotacion).add(anyString());
	}

	/**
	 * Comprobando que se llama una vez al método a�adir y stubbing comprobando
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
		// Comprobar que se ha invocado al método añadir dos veces
		verify(listaMockAnotacion).add(anyString());
		assertThat("Texto esperado no coincide.", cliente.consultar(0),
				is("uno"));
		assertThat("Texto esperado no coincide.", cliente.consultar(1),
				is("dos"));
		// si eliminamos el stubbing el test falla...
	}
}
