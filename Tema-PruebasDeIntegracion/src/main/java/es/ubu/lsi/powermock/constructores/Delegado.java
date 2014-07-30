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
package es.ubu.lsi.powermock.constructores;

/**
 * Delegado utilizado por el cliente para realizar todas las operaciones.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raul Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos Lopez</A>
 * @version 1.0
 * 
 */
public class Delegado {

	/**
	 * Constructor no-args.
	 */
	public Delegado() {
	}

	/**
	 * Constructor.
	 * 
	 * @param a
	 *            a
	 * @param b
	 *            b
	 */
	public Delegado(int a, int b) {

	}

	/**
	 * Sumar dos valores.
	 * 
	 * @param a
	 *            a
	 * @param b
	 *            b
	 * @return suma a m�s b
	 */
	public int sumar(int a, int b) {
		validar(a);
		return a + b;
	}

	/**
	 * Resta de dos valores.
	 * 
	 * @param a
	 *            a
	 * @param b
	 *            b
	 * @return resta de a menos b
	 */
	public int restar(int a, int b) {
		validar(a);
		return a - b;
	}

	/**
	 * Valida si el valor es positivo.
	 * 
	 * @param a
	 * @throws RuntimeException
	 *             si el valor es negativo
	 */
	private void validar(int a) {
		if (a < 0)
			throw new RuntimeException();
	}

}
