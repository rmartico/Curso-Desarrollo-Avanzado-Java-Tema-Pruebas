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
 * Cliente basico que delega todas las operaciones en una instancia
 * de un delegado.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raul Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos Lopez</A>
 * @version 1.0
 * 
 */
public class Cliente {
	
	/** Valor a. */
	private int a;
	
	/** Valor b. */
	private int b;
	
	/** Delegado. */
	private Delegado delegado;
		
	/**
	 * Constructor.
	 * 
	 * @param a a
	 * @param b b
	 */
	public Cliente(int a, int b){
		this.setA(a);
		this.setB(b);		
		this.delegado = new Delegado();
	}
	
	/**
	 * Constructor.
	 * 
	 * @param a a
	 * @param b b 
	 * @param c discriminante para el constructor
	 */
	public Cliente(int a, int b, boolean c){
		this.setA(a);
		this.setB(b);		
		this.delegado = new Delegado(a,b);
	}
	
	/**
	 * Establece el valor a.
	 * 
	 * @param a a
	 */
	public void setA(int a) {
		this.a = a;
	}
	
	/**
	 * Establece el valor b.
	 * 
	 * @param b b
	 */
	public void setB(int b) {
		this.b = b;
	}
	
	/**
	 * Suma los dos valores encapsulados.
	 * 
	 * @return suma de a y b
	 */
	public int sumar() {
		return delegado.sumar(a,b);
	}
	
	/**
	 * Resta los dos valores encapsulados.
	 * 
	 * @return resta de a menos b.
	 */
	public int restar() {
		return delegado.restar(a,b);
	}
	
	/**
	 * Fabrica de delegados.
	 * 
	 * @return delegado
	 */
	public static Delegado fabrica() {
		return new Delegado();
	}

}
