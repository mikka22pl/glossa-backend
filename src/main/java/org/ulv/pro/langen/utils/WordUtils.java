package org.ulv.pro.langen.utils;

public class WordUtils {

	public static String stripAccents(String word) {
		
		char[] ac = { 'á', 'é', 'í', 'ó', 'ú' };
		char[] unac = { 'a', 'e', 'i', 'o', 'u' };
		
		return word
				.replace(ac[0], unac[0])
				.replace(ac[1], unac[1])
				.replace(ac[2], unac[2])
				.replace(ac[3], unac[3])
				.replace(ac[4], unac[4]);
	}
	
	/*public static void main(String[] args) {
		String w = "á é ú í ó šašá ǧiǧí";
		String nw = WordUtils.stripAccents(w);
		
		System.out.println("" + w + " => " + nw);
	}*/
}
