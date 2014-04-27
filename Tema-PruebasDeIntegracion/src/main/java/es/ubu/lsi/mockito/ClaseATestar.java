package es.ubu.lsi.mockito;

import java.util.List;

/**
 * Clase a testar que delega en java.util.List.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raul Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos Lopez</A>
 * @version 1.0
 * 
 */
public class ClaseATestar {
	
	/** Encapsula una lista */
	private List<String> lista;
	
	/** 
	 * Inyección de la lista.
	 * 
	 * @param lista lista
	 */
	public void inyectar(List<String> lista) {
		this.lista = lista;
	}
	
	/** 
	 * Añadir un texto 
	 * 
	 * @param s texto
	 */
	public void añadir(String s) {
		lista.add(s);
	}
	
	/**
	 * Recupera el texto guardado en una posición.
	 * 
	 * @param index posición
	 * @return cadena de texto en la posición
	 */
	public String consultar(int index) {
		return lista.get(index);
	}
}
