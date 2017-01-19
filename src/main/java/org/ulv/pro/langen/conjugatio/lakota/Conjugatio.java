package org.ulv.pro.langen.conjugatio.lakota;

import org.ulv.pro.langen.model.Word;
import org.ulv.pro.langen.model.template.FormedWord;

public interface Conjugatio {

	String build2sg(Word baseWord, FormedWord template);
	
	String build3sg(Word baseWord, FormedWord template);
	
	String buildDualis(Word baseWord, FormedWord template);
}
