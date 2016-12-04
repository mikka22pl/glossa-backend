package org.ulv.pro.langen.service;

import java.util.List;

import org.ulv.pro.langen.model.Word;
import org.ulv.pro.langen.model.WordAssign;

public interface WordService {

	List<Word> getWordsByFunction(int languageId, int functionId);
	
	List<Word> getWordsTop10(int languageId);
	
	List<Word> getWords(int languageId);
	
	List<Word> getWordsWithGroups(Word word);
	
	Word getWordById(int wordId);
	
	void removeLexer(WordAssign wordAssign);
	
	void saveWord(Word word);
	
	void assignWord(Word word);
}
