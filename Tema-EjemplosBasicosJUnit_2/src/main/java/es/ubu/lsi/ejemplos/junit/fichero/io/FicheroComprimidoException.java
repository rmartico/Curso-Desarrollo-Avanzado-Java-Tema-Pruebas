package es.ubu.lsi.ejemplos.junit.fichero.io;

/**
 * Error en compresi�n.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Ra�l Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
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
	 * @param t excepci�n origen
	 */
	public FicheroComprimidoException(Throwable t) {
		super(t);
	}

	/**
	 * Constructor.
	 * 
	 * @param s texto
	 * @param t excepci�n origen
	 */
	public FicheroComprimidoException(String s, Throwable t) {
		super(s, t);
	}
}