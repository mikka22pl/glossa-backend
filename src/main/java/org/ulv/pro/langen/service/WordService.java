package org.ulv.pro.langen.service;

import java.util.List;

import org.ulv.pro.langen.model.Word;

public interface WordService {

	List<Word> getWordsByGroup(int languageId, int groupId);
	
	List<Word> getWordsTop10(int languageId);
	
	List<Word> getWords(int languageId);
	
	void saveWord(Word word);
}
