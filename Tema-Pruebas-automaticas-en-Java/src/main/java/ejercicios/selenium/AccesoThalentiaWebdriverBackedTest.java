package ejercicios.selenium;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.SeleneseTestCase;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class AccesoThalentiaWebdriverBackedTest extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://www.thalentia.com/";
		// Carga de selenium desde el WebDriver...
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testAccesoThalentiaWebdriverBacked() throws Exception {
		selenium.open("/");
		selenium.click("css=img[title=\"Acceso Campus\"]");
		selenium.waitForPageToLoad("5000");
		selenium.type("id=usuario", "rmartico");
		selenium.type("name=pass", "skreemer");
		selenium.click("id=enviar");
		selenium.waitForPageToLoad("5000");
		assertTrue(selenium.isTextPresent("Curso Especialista Java"));

	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
