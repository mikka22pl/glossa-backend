package org.ulv.pro.langen.service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ulv.pro.langen.dao.WordDao;
import org.ulv.pro.langen.model.Lexer;
import org.ulv.pro.langen.model.LexerLang;
import org.ulv.pro.langen.model.Word;
import org.ulv.pro.langen.model.WordAssign;
import org.ulv.pro.langen.model.WordGroup;

@Service(value = "wordService")
public class WordServiceImpl implements WordService {

	@Autowired
	private WordDao wordDao;
	
	@Override
	public List<Word> getWordsByFunction(int languageId, int functionId) {
		LexerLang func = new LexerLang();
		func.setId(functionId);
		func.setLanguageId(languageId);
		
		return wordDao.getWordsByFunction(func);
	}

	@Override
	public List<Word> getWordsTop10(int languageId) {
		Word word = new Word();
		word.setLanguageId(languageId);
		
		return wordDao.getWordsTop10(word);
	}

	@Override
	public List<Word> getWords(int languageId) {
		Word word = new Word();
		word.setLanguageId(languageId);
		
		return wordDao.getWords(word);
	}

	@Override
	public void saveWord(Word word) {
		if (word.isNew()) {
			wordDao.addWord(word);
		} else {
			
		}
	}

	@Override
	public List<Word> getWordsWithGroups(Word word) {
		return wordDao.getWordsWithGroups(word);
	}

	@Override
	public void assignWord(Word word) {
		WordAssign wordFunction = new WordAssign(word.getId());
		wordFunction.setLexerId(word.getFunctions().get(0).getId());
		
		wordDao.assignFunction(wordFunction);
		
		if (CollectionUtils.isNotEmpty(word.getCategories())) {
			for (Lexer cat : word.getCategories()) {
				WordAssign wordCategory = new WordAssign(word.getId());
				wordCategory.setLexerId(cat.getId());
				
				wordDao.assignCategory(wordCategory);
			}
		}
	}

}
