package es.ubu.lsi.mockito.argumentcaptor;

import java.util.List;

/**
 * Contenedor basico.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raul Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos Lopez</A>
 * @version 1.0
 * 
 */
public class Contenedor {
	
	/** Lista de cadenas. */
	private List<String> lista;
	
	/**
	 * Contenedor con inyecci�n de lista.
	 * 
	 * @param lista lista
	 */
	public Contenedor(List<String> lista) {
		this.lista = lista;
	}
	
	/**
	 * Añade un elemento.
	 * 
	 * @param elemento elemento
	 */
	public void añadir(String elemento) {
		lista.add(elemento);
	}
	
	/**
	 * Añade una lista de elementos.
	 * 
	 * @param elementos lista de elementos.
	 */
	public void añadir(List<String> elementos){
		lista.addAll(elementos);
	}
}
