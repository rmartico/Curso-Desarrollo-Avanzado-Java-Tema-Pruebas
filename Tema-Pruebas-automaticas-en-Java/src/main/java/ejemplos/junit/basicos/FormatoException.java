package ejemplos.junit.basicos;

/**
 * Eror en formato.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raúl Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.0
 * 
 */
@SuppressWarnings("serial")
public class FormatoException extends Exception {

	/**
	 * Constructor.
	 */
	public FormatoException(){
		super();
	}
	
	/**
	 * Constructor.
	 * 
	 * @param text texto
	 */
	public FormatoException(String text){
		super(text);
	}
}
