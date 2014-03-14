package ejemplos.junit.fichero.io;

/**
 * Fichero no encontrado.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raúl Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.0
 * 
 */
@SuppressWarnings("serial")
public class FicheroNoEncontradoException extends Exception {

	/**
	 * Constructor.
	 */	
	public FicheroNoEncontradoException() {
	}	
	
	/**
	 * Constructor. 
	 * 
	 * @param s texto
	 */
	public FicheroNoEncontradoException(String s) {
		super(s);
	}	

	/**
	 * Constructor.
	 * 
	 * @param t excepción origen
	 */
 	public FicheroNoEncontradoException(Throwable t) {
		super(t);
	}	
	
	/**
	 * Constructor.
	 * 
	 * @param s texto
	 * @param t excepción origen
	 */
	public FicheroNoEncontradoException(String s, Throwable t) {
		super(s,t);
	}	
}

