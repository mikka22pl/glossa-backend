package org.ulv.pro.langen.service;

import java.util.List;

import org.ulv.pro.langen.model.DictionaryEntry;
import org.ulv.pro.langen.model.SentenceTranslation;
import org.ulv.pro.langen.model.Translation;

public interface TranslationService {

	List<DictionaryEntry> getWordTranslations(int wordId);
	
	void saveTranslation(Translation translation);
	
	void addSentenceTranslation(SentenceTranslation sentenceTranslation);
	
	SentenceTranslation getSentenceTranslation(SentenceTranslation sentenceTranslation);
}
