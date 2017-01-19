package org.ulv.pro.langen.service;

import java.util.List;
import java.util.Set;

import org.ulv.pro.langen.model.Lexer;
import org.ulv.pro.langen.model.Word;
import org.ulv.pro.langen.model.WordAssign;
import org.ulv.pro.langen.model.word.FixedWord;

public interface WordService {

	List<Word> getWordsByFunction(int languageId, int functionId);
	
	List<Word> getWordsTop10(int languageId);
	
	List<Word> getWords(int languageId);
	
	List<Word> getWordsWithGroups(Word word);
	
	Word getWordById(int wordId);
	
	void removeLexer(WordAssign wordAssign);
	
	void saveWord(Word word);
	
	void assignWord(Word word);
	
	Lexer assignCategory(WordAssign wordAssign);
	
	void removeCategory(WordAssign wordAssign);
	
	void saveFixedWord(FixedWord fixedWord);
	
	List<FixedWord> getFixedWordsForTemplate(Integer templateId);
	
	void removeFixedWords(Set<Integer> ids);
}
