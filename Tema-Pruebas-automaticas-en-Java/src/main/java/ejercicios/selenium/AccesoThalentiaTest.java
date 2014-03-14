package ejercicios.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.StringContains.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.Selenium;

public class AccesoThalentiaTest {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://www.thalentia.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testAccesoCorrectoThalentia() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.cssSelector("img[title=\"Acceso Campus\"]")).click();
		driver.findElement(By.id("usuario")).clear();
		driver.findElement(By.id("usuario")).sendKeys("rmartico");
		driver.findElement(By.name("pass")).clear();
		driver.findElement(By.name("pass")).sendKeys("skreemer");
		driver.findElement(By.id("enviar")).click();
		Selenium selenium = new WebDriverBackedSelenium(driver, baseUrl);
		assertTrue(selenium.isTextPresent("Curso Especialista Java"));
		// Lo mismo con asertos JUnit y hamcrest
		// TODO assertThat(driver.getPageSource(),containsString("Curso Especialista en Java"));
		// ERROR: Caught exception [ERROR: Unsupported command [isTextPresent]]
	}
	
	@Test
	public void testAccesoIncorrectoThalentia() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.cssSelector("img[title=\"Acceso Campus\"]")).click();
		driver.findElement(By.id("usuario")).clear();
		driver.findElement(By.id("usuario")).sendKeys("inventado");
		driver.findElement(By.name("pass")).clear();
		driver.findElement(By.name("pass")).sendKeys("inventado");
		driver.findElement(By.id("enviar")).click();
		Selenium selenium = new WebDriverBackedSelenium(driver, baseUrl);
		assertFalse("No se debe entrar en el curso", selenium.isTextPresent("Curso Especialista Java"));		
		// ERROR: Caught exception [ERROR: Unsupported command [isTextPresent]]
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
