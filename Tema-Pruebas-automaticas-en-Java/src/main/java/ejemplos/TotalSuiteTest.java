package ejemplos;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

// se puede indicar paquete... 
@RunWith(Suite.class)
@SuiteClasses({ ejemplos.junit.basicos.ByteTest.class,
		ejemplos.junit.fichero.test.JarTest.class,
		ejemplos.junit.basicos.MathTest.class,
		ejemplos.mockito.EjemploBasicoMockitoTest.class,
		ejemplos.mockito.argumentcaptor.EjemploArgumentCaptorTest.class,
		ejemplos.mockito.spy.EjemploUsoSpyTest.class,
		ejemplos.powermock.constructores.ClienteTest.class,
		ejemplos.powermock.estaticos.ClienteTest.class,
		ejemplos.powermock.privados.ClienteTest.class,
		ejemplos.dbunit.EjemploDBUnitTest.class, 
		ejemplos.uispec4j.EjemploGUITest.class,
		ejercicios.selenium.AccesoThalentiaWebdriverBackedTest.class})
public class TotalSuiteTest {
}
