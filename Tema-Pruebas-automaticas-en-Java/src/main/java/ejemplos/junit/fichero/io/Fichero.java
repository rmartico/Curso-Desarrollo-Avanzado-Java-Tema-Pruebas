package ejemplos.junit.fichero.io;

/**
 * Interfaz b�sica de la clase auxiliar fichero.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Ra�l Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
 * @version 1.0
 * 
 */
public interface Fichero {

	/** 
	 * Establece el tama�o.
	 * 
	 * @param size tama�o
	 */
	public abstract void setSize(int size);

	/**
	 * Establece el nombre.
	 * 
	 * @param nombre nombre
	 */
	public abstract void setNombre(String nombre);

	/**
	 * Establece la extensi�n.
	 * 
	 * @param extensi�n extensi�n.
	 */
	public abstract void setExtension(String extension);

	/**
	 * Obtiene el tama�o.
	 * 
	 * @return tama�o
	 */
	public abstract int getSize();

	/**
	 * Obtiene el nombre. 
	 * 
	 * @return nombre
	 */
	public abstract String getNombre();

	/**
	 * Obtiene la extensi�n.
	 * 
	 * @return extensi�n
	 */
	public abstract String getExtension();

	/**
	 * Comparaci�n de igualdad.
	 * 
	 * @param fichero fichero 
	 * @return true si son iguales false en caso contrario
	 */
	public abstract boolean equals(Object fichero);

}