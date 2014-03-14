package ejemplos.powermock.estaticos;

/**
 * Cliente básico que delega todas las operaciones en una instancia
 * de una clase delegado, invocando a sus métodos estáticos.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raúl Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.0
 * 
 */
public class Cliente {
	
	/** Valor a. */
	private int a;
	
	/** Valor b. */
	private int b;
	
	/**
	 * Constructor.
	 * 
	 * @param a a
	 * @param b b
	 */
	public Cliente(int a, int b){
		this.setA(a);
		this.setB(b);		
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
		return Estatico.sumar(a,b);
	}
	
	/**
	 * Resta los dos valores encapsulados.
	 * 
	 * @return resta de a menos b.
	 */
	public int restar() {
		return Estatico.restar(a,b);
	}

}
