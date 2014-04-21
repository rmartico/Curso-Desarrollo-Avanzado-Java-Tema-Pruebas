package es.ubu.lsi.ejemplos.junit.fichero.compresion;
import es.ubu.lsi.ejemplos.junit.fichero.io.Fichero;
import es.ubu.lsi.ejemplos.junit.fichero.io.FicheroComprimidoException;
import es.ubu.lsi.ejemplos.junit.fichero.io.FicheroNoEncontradoException;


/**
 * Fichero comprimido.
 *
 * @author <A HREF="mailto:rmartico@ubu.es">Ra�l Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
 * @version 1.0
 */
public interface Comprimido{
	
	/**
	 * A�ade un fichero para a�adirlo comprimido al fichero zip actual.
	 *
	 * @param	fichero fichero a comprimir
	 * @throws	FicheroComprimidoException si el fichero ya ha sido comprimido
	 */
	public void añadir(Fichero fichero) throws FicheroComprimidoException;
	
	/**
	 * Elimina un fichero del fichero zip actual.
	 *
	 * @param	fichero fichero a eliminar del fichero zip
	 * @throws	FicheroNoEncontradoException si el fichero no se ha a�adido previamente
	 */
	public void eliminar(Fichero fichero) throws FicheroNoEncontradoException;
	
	/**
	 * Obtiene el tama�o del fichero comprimido, como la suma de los
	 * tama�os de los ficheros introducidos multiplicado por el factor
	 * de compresi�n.
	 *
	 * @return suma de los tama�os de los ficheros una vez comprimidos
	 */
	public double obtenerTamañoComprimido();
	
} // Comprimido