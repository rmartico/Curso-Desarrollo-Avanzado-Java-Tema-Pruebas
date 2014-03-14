package ejemplos.junit.fichero.io;

/**
 * Error en compresión.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raúl Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.0
 * 
 */
@SuppressWarnings("serial")
public class FicheroComprimidoException extends Exception {

	/**
	 * Constructor.
	 */
	public FicheroComprimidoException() {
	}

	/**
	 * Constructor. 
	 * 
	 * @param s texto
	 */
	public FicheroComprimidoException(String s) {
		super(s);
	}

	/**
	 * Constructor.
	 * 
	 * @param t excepción origen
	 */
	public FicheroComprimidoException(Throwable t) {
		super(t);
	}

	/**
	 * Constructor.
	 * 
	 * @param s texto
	 * @param t excepción origen
	 */
	public FicheroComprimidoException(String s, Throwable t) {
		super(s, t);
	}
}