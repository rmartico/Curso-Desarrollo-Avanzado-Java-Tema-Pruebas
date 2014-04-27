package es.ubu.lsi.powermock.estaticos;

/**
 * Delegado con metodos estaticos.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raul Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos Lopez</A>
 * @version 1.0
 * 
 */
public class Estatico {
	
	/**
	 * Sumar dos valores.
	 * 
	 * @param a
	 *            a
	 * @param b
	 *            b
	 * @return suma a mas b
	 */
	public static int sumar(int a, int b) {
		if (a<0) throw new RuntimeException();
		return a+b;
	}
	
	/**
	 * Resta de dos valores.
	 * 
	 * @param a
	 *            a
	 * @param b
	 *            b
	 * @return resta de a menos b
	 */
	public static int restar(int a, int b) {
		if (a<0) throw new RuntimeException();
		return a-b;
	}

}
