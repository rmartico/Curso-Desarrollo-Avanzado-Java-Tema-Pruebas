package es.ubu.lsi.ejemplos.junit.fichero.io;

/**
 * Implementacion concreta de un fichero.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raul Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos Lopez</A>
 * @version 1.0
 * 
 */
public class FicheroImpl implements Fichero {

	/** Tamaño */
	private int size;
	/** Nombre */
	private String nombre;
	/** Extension */
	private String extension;

	/**
	 * Constructor.
	 * 
	 * @param size tama�o
	 * @param nombre nombre 
	 * @param extensi�n extensi�n
	 */
	public FicheroImpl(int size, String nombre, String extension) {
		this.setSize(size);
		this.setNombre(nombre);
		this.setExtension(extension);
	}

	/**
	 * {@inheritDoc}.
	 *
	 * @param size {@inheritDoc}
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * {@inheritDoc}.
	 *
	 * @param nombre {@inheritDoc}
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * {@inheritDoc}.
	 *
	 * @param extensi�n {@inheritDoc}
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}

	/**
	 * {@inheritDoc}.
	 *
	 * @return {@inheritDoc}
	 */
	public int getSize() {
		return (this.size);
	}

	/**
	 * {@inheritDoc}.
	 *
	 * @return {@inheritDoc}
	 */
	public String getNombre() {
		return (this.nombre);
	}

	/**
	 * {@inheritDoc}.
	 *
	 * @return {@inheritDoc}
	 */
	public String getExtension() {
		return (this.extension);
	}

	/**
	 * {@inheritDoc}.
	 *
	 * @param fichero {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@Override
	public boolean equals(Object fichero) {
		if (fichero == null) {
			return false;
		}
		if (fichero.getClass().equals(this.getClass())) {
			if (((Fichero) fichero).getExtension().equals(this.getExtension())
					&& ((Fichero) fichero).getNombre().equals(this.getNombre())
					&& ((Fichero) fichero).getSize() == this.size) {
				return true;
			}
		}
		return false;
	}
}