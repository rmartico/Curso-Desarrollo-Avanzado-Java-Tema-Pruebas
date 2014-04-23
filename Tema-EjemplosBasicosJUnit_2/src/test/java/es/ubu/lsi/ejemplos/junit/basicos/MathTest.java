package es.ubu.lsi.ejemplos.junit.basicos;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Pruebas unitarias sobre la clase Math y el método sqrt.
 * 
 * @author <a href="mailto:rmartico@ubu.es">Raúl Marticorena Sánchez</a>
 * @version 1.0 20111214
 * 
 */
public class MathTest {
	
	@Test
	public void raizNegativoLimite() {
		assertThat(Math.sqrt(-1),is(Double.NaN));
	}
	
	@Test
	public void raizNegativoPequeño() {
		assertThat(Math.sqrt(-2),is(Double.NaN));
	}
	
	@Test
	public void raizNegativoMayor() {
		assertThat(Math.sqrt(-999),is(Double.NaN));
	}
	
	@Test
	public void raizCeroPositivo() {
		assertThat(Math.sqrt(+0),is(0.0));
	}
	
	@Test
	public void raizCeroNegativo() {
		assertThat(Math.sqrt(-0),is(0.0));
	}
	
	@Test
	public void raizUno() {
		assertThat(Math.sqrt(1.0),is(1.0));
	}
	
	@Test
	public void raizCuatro() {
		assertThat(Math.sqrt(4.0),is(2.0));
	}
	
	@Test
	public void raizCientoCuearentaYCuatro() {
		assertThat(Math.sqrt(144.0),is(12.0));
	}
	
	@Test
	public void raizInfinitoPositivo() {
		assertThat(Math.sqrt(Double.POSITIVE_INFINITY),is(Double.POSITIVE_INFINITY));;
	}
	
	@Test
	public void raizCalculada() {
		double[] entrada = {11, 23, 35, 67, 134, 294, 537, 1000};		
		for (double e : entrada){
			double cuadrado = e * e;
			assertThat(Math.sqrt(cuadrado),is(e));
		}	
	}
	
	
}
