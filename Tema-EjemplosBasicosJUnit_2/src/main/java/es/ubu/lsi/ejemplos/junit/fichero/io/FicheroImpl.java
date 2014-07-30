/*
 * Copyright © 2014 Arcadia Consulting C.B. . All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification 
 * are not permitted 
 *
 * THIS SOFTWARE IS PROVIDED BY ARCADIA CONSULTING C.B. "AS IS" AND ANY EXPRESS
 * OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE 
 * DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT, 
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT 
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, 
 * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF 
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING 
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, 
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
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
	 * @param size tamaño
	 * @param nombre nombre 
	 * @param extensión extensión
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
	 * @param extensión {@inheritDoc}
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