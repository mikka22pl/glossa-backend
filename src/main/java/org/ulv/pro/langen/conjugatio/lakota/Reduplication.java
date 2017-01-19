package org.ulv.pro.langen.conjugatio.lakota;

import org.ulv.pro.langen.utils.WordUtils;

public class Reduplication {

	public static String reduplicate(String word) {
		
		String w = WordUtils.stripAccents(word);
		String reduplicated = w + word;
		return reduplicated;
	}
}
