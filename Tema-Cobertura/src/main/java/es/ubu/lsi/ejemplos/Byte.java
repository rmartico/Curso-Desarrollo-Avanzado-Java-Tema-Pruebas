package es.ubu.lsi.ejemplos;

/**
 * Clase quer representa un byte (8 bits con valores 0 y 1).
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Raul Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos Lopez</A>
 * @version 1.0
 * 
 */
public class Byte {

	/** Cadena de bits */
	private String bits;

	/** Base 2 */
	private static final int BASE = 2;

	/**
	 * Constructor.
	 * 
	 * @param bits cadena de bits
	 * @throws FormatoException si el formato no es de unos y ceros
	 */
	public Byte(String bits) throws FormatoException {
		if (bits.length() != 8) {
			throw new FormatoException("Formato incorrecto");
		}
		for (int i = 0; i < bits.length(); i++) {
			if (bits.charAt(i) != '0' && bits.charAt(i) != '1') {
				throw new FormatoException("Car�cter incorrecto "
						+ bits.charAt(i));
			}
		}
		this.bits = bits;
	}

	/**
	 * Convierte a formato hexadecimal.
	 * 
	 * @return cadena de bits en formato hexadecimal
	 */
	public String aHex() {
		String first = translate(this.bits.substring(0, 4));
		String second = translate(this.bits.substring(4, 8));
		return first + second;
	}

	/**
	 * Traducci�n interna de los cuatro bits.
	 * 
	 * @param fourBits cuatro bits
	 * @return traducci�n hexadecimal
	 */
	private String translate(String fourBits) {
		int pow = 3;
		int sum = 0;
		for (int i = 0; i < fourBits.length(); i++) {
			Integer value = Integer.parseInt(Character.valueOf(
					fourBits.charAt(i)).toString());
			int potencia = (int) Math.pow(BASE, pow);
			sum += value * potencia;
			pow--;
		}
		if (sum < 10) {
			return Integer.toString(sum);
		} else {
			char c = (char) ('A' + (int) (sum - 10));
			return Character.toString(c);
		}
	}

	/**
	 * Convierte a formato cadena.
	 * 
	 * @return cadena de bits
	 */
	@Override
	public String toString() {
		return bits;
	}
	

}
