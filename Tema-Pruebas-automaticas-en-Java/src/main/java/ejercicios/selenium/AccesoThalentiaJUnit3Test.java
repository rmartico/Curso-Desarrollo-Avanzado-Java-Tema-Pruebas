package ejercicios.selenium;



import com.thoughtworks.selenium.*;
import java.util.regex.Pattern;

/**
 * Solución versión Selenium RC.
 *
 * @author <A HREF="mailto:rmartico@ubu.es">Raúl Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.0
 */
public class AccesoThalentiaJUnit3Test extends SeleneseTestCase {
	public void setUp() throws Exception {
		setUp("http://www.thalentia.com/", "*chrome");
	}
	public void testAccesoThalentiaJUnit3() throws Exception {
		selenium.open("/");
		selenium.click("css=img[title=\"Acceso Campus\"]");
		selenium.waitForPageToLoad("5000");
		selenium.type("id=usuario", "rmartico");
		selenium.type("name=pass", "skreemer");
		selenium.click("id=enviar");
		selenium.waitForPageToLoad("5000");
		assertTrue(selenium.isTextPresent("Curso Especialista Java"));
	}
}
