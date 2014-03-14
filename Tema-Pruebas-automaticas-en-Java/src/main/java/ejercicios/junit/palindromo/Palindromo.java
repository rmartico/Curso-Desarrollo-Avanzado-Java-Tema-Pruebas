package ejercicios.junit.palindromo;

import java.util.List;
import java.util.ArrayList;

public class Palindromo {

	private String valor;

	/**
	 * Instancia un palíndromo a partir del texto de entrada.
	 * 
	 * @param texto
	 *            valor inicial
	 * @throws ContenidoVacioException
	 *             si la cadena está vacía
	 * @throws ContenidoNuloException
	 *             si la cadena vale null
	 * @throws PalindromoIncorrectoException
	 *             si la cadena no se lee igual en ambos sentidos
	 */
	public Palindromo(String texto) throws ContenidoVacioException,
			ContenidoNuloException, PalindromoIncorrectoException {
		if (texto == null) {
			throw new ContenidoNuloException("Valor nulo");
		} else if (texto.length() == 0) {
			throw new ContenidoVacioException("Cadena vacia");
		} else if (!validar(texto)) {
			throw new PalindromoIncorrectoException("No es palíndromo");
		}
		this.valor = texto;
	}

	/**
	 * Consulta el texto del palíndromo.
	 * 
	 * @return texto del palíndromo
	 */
	public String obtenerTexto() {
		return this.valor;
	}

	private boolean validar(String texto) {

		// Limpiar blancos y tabuladores
		char[] text = texto.trim().toLowerCase().toCharArray();

		List<Character> list = new ArrayList<Character>();
		for (char c : text) {
			if (c != ' ' && c != '\t') {
				list.add(c);
			}
		}

		int i = 0;
		char[] textoLimpio = new char[list.size()];
		for (char c : list) {
			textoLimpio[i] = c;
			i++;
		}
		// System.out.println("Cadena limpia: " + new String(textoLimpio));

		int position = textoLimpio.length;

		char[] text2 = new char[textoLimpio.length];

		for (char c : textoLimpio) {
			text2[position - 1] = c;
			position--;
		}

		// System.out.println("Comparo con: " + new String(text2));
		return new String(textoLimpio).compareTo(new String(text2)) == 0;
	}

}
