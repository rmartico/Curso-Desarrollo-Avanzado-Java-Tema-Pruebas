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

