package ejemplos.junit.fichero.compresion;
import java.util.ArrayList;
import java.util.List;

import ejemplos.junit.fichero.io.Fichero;
import ejemplos.junit.fichero.io.FicheroComprimidoException;
import ejemplos.junit.fichero.io.FicheroNoEncontradoException;

/**
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Ra�l Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
 * @version 1.0
 * 
 */
public class Jar implements Comprimido{
	
	/** Lista de ficheros comprimidos */
	private List<Fichero> listaFichero;
	
	/** Constructor */
	public Jar(){
		listaFichero = new ArrayList<Fichero>();
	}
	
	/**
	 * A�ade un fichero para a�adirlo comprimido al fichero zip actual.
	 *
	 * @param	fichero fichero a comprimir
	 * @throws	FicheroComprimidoException si el fichero ya ha sido comprimido
	 */
	public void añadir(Fichero fichero) throws FicheroComprimidoException{
		if (listaFichero.contains(fichero)){
			throw new FicheroComprimidoException("Fichero " + fichero.getNombre() 
				+ " ya fue comprimido");
		}
		listaFichero.add(fichero);
	}
	
	/**
	 * Elimina un fichero del fichero zip actual.
	 *
	 * @param	fichero fichero a eliminar del fichero zip
	 * @throws	FicheroNoEncontradoException si el fichero no se ha a�adido previamente
	 */
	public void eliminar(Fichero fichero) throws FicheroNoEncontradoException{
		if (!listaFichero.contains(fichero)){
			throw new FicheroNoEncontradoException("Fichero " + fichero.getNombre() 
				+ " no encontrado");
		}
		listaFichero.remove(fichero);
	}
	
	/**
	 * Obtiene el tama�o del fichero comprimido, como la suma de los
	 * tama�os de los ficheros introducidos multiplicado por el factor
	 * de compresi�n.
	 *
	 * @return suma de los tama�os de los ficheros una vez comprimidos
	 */
	public double obtenerTamañoComprimido(){
		double sum = 0.0;
		for (Fichero fichero: listaFichero){
			sum += fichero.getSize();
		}
		return sum * 0.75;
	}
}