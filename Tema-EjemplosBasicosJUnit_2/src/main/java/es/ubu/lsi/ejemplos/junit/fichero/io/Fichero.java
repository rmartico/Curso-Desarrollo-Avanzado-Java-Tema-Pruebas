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
 * Interfaz básica de la clase auxiliar fichero.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raúl Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.0
 * 
 */
public interface Fichero {

	/** 
	 * Establece el tamaño.
	 * 
	 * @param size tamaño
	 */
	public abstract void setSize(int size);

	/**
	 * Establece el nombre.
	 * 
	 * @param nombre nombre
	 */
	public abstract void setNombre(String nombre);

	/**
	 * Establece la extensión.
	 * 
	 * @param extensi�n extensión.
	 */
	public abstract void setExtension(String extension);

	/**
	 * Obtiene el tamaño.
	 * 
	 * @return tamaño
	 */
	public abstract int getSize();

	/**
	 * Obtiene el nombre. 
	 * 
	 * @return nombre
	 */
	public abstract String getNombre();

	/**
	 * Obtiene la extensión.
	 * 
	 * @return extensión
	 */
	public abstract String getExtension();

	/**
	 * Comparación de igualdad.
	 * 
	 * @param fichero fichero 
	 * @return true si son iguales false en caso contrario
	 */
	public abstract boolean equals(Object fichero);

}