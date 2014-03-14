package ejemplos.powermock.privados;

/**
 * Delegado utilizado por el cliente para realizar todas las operaciones.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raúl Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.0
 * 
 */
public class Delegado {
	
	/**
	 * Constructor no-args.
	 */
	public Delegado() {
	}

	/**
	 * Constructor.
	 * 
	 * @param a
	 *            a
	 * @param b
	 *            b
	 */
	public Delegado(int a, int b) {

	}

	/**
	 * Sumar dos valores.
	 * 
	 * @param a
	 *            a
	 * @param b
	 *            b
	 * @return suma a más b
	 */
	public int sumar(int a, int b) {
		validar(a);
		return a + b;
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
	public int restar(int a, int b) {
		validar(a);
		return a - b;
	}

	/**
	 * Valida si el valor es positivo.
	 * 
	 * @param a
	 * @throws RuntimeException
	 *             si el valor es negativo
	 */
	private boolean validar(int a) {
		if (a < 0)
			throw new RuntimeException();
		return true;
	}


}
