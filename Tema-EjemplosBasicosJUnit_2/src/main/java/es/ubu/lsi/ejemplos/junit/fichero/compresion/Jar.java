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
package es.ubu.lsi.ejemplos.junit.fichero.compresion;
import java.util.ArrayList;
import java.util.List;

import es.ubu.lsi.ejemplos.junit.fichero.io.Fichero;
import es.ubu.lsi.ejemplos.junit.fichero.io.FicheroComprimidoException;
import es.ubu.lsi.ejemplos.junit.fichero.io.FicheroNoEncontradoException;

/**
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raúl Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
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
	 * A�ade un fichero para añadirlo comprimido al fichero zip actual.
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
	 * Obtiene el tamaño del fichero comprimido, como la suma de los
	 * tamaños de los ficheros introducidos multiplicado por el factor
	 * de compresión.
	 *
	 * @return suma de los tamaños de los ficheros una vez comprimidos
	 */
	public double obtenerTamañoComprimido(){
		double sum = 0.0;
		for (Fichero fichero: listaFichero){
			sum += fichero.getSize();
		}
		return sum * 0.75;
	}
}