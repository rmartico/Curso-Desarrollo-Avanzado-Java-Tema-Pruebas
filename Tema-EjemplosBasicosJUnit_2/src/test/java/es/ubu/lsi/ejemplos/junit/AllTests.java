package es.ubu.lsi.ejemplos.junit;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import es.ubu.lsi.ejemplos.junit.basicos.ByteTest;
import es.ubu.lsi.ejemplos.junit.basicos.MathTest;
import es.ubu.lsi.ejemplos.junit.fichero.compresion.JarTest;

@RunWith(Suite.class)	
@SuiteClasses({
	ByteTest.class,
	MathTest.class, 
	JarTest.class})
@Ignore
public class AllTests {
}