package es.ubu.lsi.ejemplos.junit.fichero.io;

/**
 * Fichero no encontrado.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Ra�l Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
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
	 * @param t excepci�n origen
	 */
 	public FicheroNoEncontradoException(Throwable t) {
		super(t);
	}	
	
	/**
	 * Constructor.
	 * 
	 * @param s texto
	 * @param t excepci�n origen
	 */
	public FicheroNoEncontradoException(String s, Throwable t) {
		super(s,t);
	}	
}

