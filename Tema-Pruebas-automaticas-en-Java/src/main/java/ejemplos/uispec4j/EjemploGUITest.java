package ejemplos.uispec4j;

import org.uispec4j.Button;
import org.uispec4j.TextBox;
import org.uispec4j.Trigger;
import org.uispec4j.UISpecTestCase;
import org.uispec4j.Window;
import org.uispec4j.interception.MainClassAdapter;
import org.uispec4j.interception.WindowHandler;
import org.uispec4j.interception.WindowInterceptor;

/**
 * Ejemplo de testing con uispec4j.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Ra�l Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
 * @version 1.0
 */
public class EjemploGUITest extends UISpecTestCase {

	/** Bot�n de mostrar texto */
	private static final String MOSTRAR_TEXTO = "Mostrar texto";

	/**
	 * Establecemos el adaptador de la interfaz gr�fica a testar.
	 */
	protected void setUp() throws Exception {
		super.setUp();
		setAdapter(new MainClassAdapter(UIToTest.class, new String[0]));
		// el array de cadenas son los argumentos pasados en la invocaci�n.
	}

	/**
	 * Comprobaci�n de la correcta inicializaci�n al arrancar la aplicaci�n.
	 * 
	 * @throws Exception
	 *             si hay alg�n error
	 */
	public void testInicializacionCorrecta() throws Exception {
		// Obtener ventana principal
		Window window = getMainWindow();
		// Obtener bot�n
		Button button = window.getButton(MOSTRAR_TEXTO);
		// Obtener cuadro de texto
		TextBox textBox = window.getInputTextBox("cuadro");
		// Aserto
		assertEquals("El texto no est� vac�o inicialmente.",
				(String) textBox.getText(), "");

		// Pulsamos el bot�n
		button.click();
		// Aserto
		assertEquals("Deber�a seguir vac�o el texto",
				(String) textBox.getText(), "");
	}

	/**
	 * Comprobaci�n de correcto funcionamiento del di�logo.
	 */
	public void testDialogo() {
		Window window = getMainWindow();
		TextBox cuadro = window.getInputTextBox("cuadro");
		// Cambiamos el texto
		cuadro.setText("Hola mundo");
		WindowInterceptor.init(window.getButton(MOSTRAR_TEXTO).triggerClick())
				.process(new WindowHandler() {
					public Trigger process(Window dialog) {
						assertTrue(dialog.titleEquals("Mensaje"));
						// el di�logo debe contener el texto introducido previamente
						TextBox textBox = dialog
								.getTextBox("Texto cargado: Hola mundo");
						assertNotNull(textBox);
						// retorna el control al hilo principal
						return dialog.getButton("Aceptar").triggerClick();
					}
				}).run();
	}
}
