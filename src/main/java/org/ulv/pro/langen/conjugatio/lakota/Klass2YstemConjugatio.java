package org.ulv.pro.langen.conjugatio.lakota;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.ulv.pro.langen.model.Word;
import org.ulv.pro.langen.model.template.FormedWord;

public class Klass2YstemConjugatio implements Conjugatio {

	private Pattern person = Pattern.compile("-?x-y");
	private Pattern person2 = Pattern.compile("-?x-");
	private Pattern pluralis = Pattern.compile("-pl-?");
	private Pattern accent1 = Pattern.compile("([aeiou])([^aeiou]+)([áúí])");
	
	private static final String SG_2 = "l";
	private static final String DUALIS = "uŋ";
	
	@Override
	public String build2sg(Word baseWord, FormedWord template) {
		System.out.println("template " + template + " - " + template.getName());
		Matcher m = person.matcher(template.getName());
		
		if (m.find()) {
			String word = m.replaceFirst(SG_2);
			System.out.println("word" + word);
			Matcher mpl = pluralis.matcher(word);
			System.out.println("mpl" + mpl);
			word = mpl.replaceFirst("");
			
			return word;
		}
		return template.getName();
	}

	@Override
	public String build3sg(Word baseWord, FormedWord template) {
		return baseWord.getName();
	}

	@Override
	public String buildDualis(Word baseWord, FormedWord template) {

		Matcher m = person2.matcher(template.getName());
		
		if (m.find()) {
			String word = m.replaceFirst(DUALIS);

			Matcher mpl = pluralis.matcher(word);
			word = mpl.replaceFirst("");
			
			word = shiftAccent(word, 1);
			
			return word;
		}
		return template.getName();
	}
	
	private String shiftAccent(String word, int count) {

		Matcher m = accent1.matcher(word);
		if (m.find()) {
			if (m.groupCount() == 3) {
				String accented = reAccent(m.group(1));
				String same = reAccent(m.group(2));
				String unaccented = reAccent(m.group(3));
				String nw = m.replaceFirst(accented + same + unaccented);
				return nw;
			}
		}
		return word;
	}
	
	private String reAccent(String letter) {
		if (letter.equals("a")) {
			return "á";
		} else if (letter.equals("u")) {
			return "ú";
		} else if (letter.equals("i")) {
			return "í";
		} else if (letter.equals("á")) {
			return "a";
		} else if (letter.equals("ú")) {
			return "u";
		} else if (letter.equals("í")) {
			return "i";
		}
		return letter;
	}
}
