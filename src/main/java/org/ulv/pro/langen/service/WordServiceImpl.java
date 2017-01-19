package org.ulv.pro.langen.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ulv.pro.langen.dao.WordDao;
import org.ulv.pro.langen.model.Lexer;
import org.ulv.pro.langen.model.LexerLang;
import org.ulv.pro.langen.model.Word;
import org.ulv.pro.langen.model.WordAssign;
import org.ulv.pro.langen.model.WordCategory;
import org.ulv.pro.langen.model.WordSearch;
import org.ulv.pro.langen.model.word.FixedWord;

@Service(value = "wordService")
public class WordServiceImpl implements WordService {

	private static final Logger log = LoggerFactory.getLogger(WordServiceImpl.class);
	
	@Autowired
	private WordDao wordDao;
	
	@Autowired
	private LexerService lexerService;
	
	@Override
	public List<Word> getWordsByFunction(int languageId, int functionId) {
		LexerLang func = new LexerLang();
		func.setId(functionId);
		func.setLanguageId(languageId);
		
		WordSearch wordSearch = new WordSearch();
		wordSearch.setFunctionWord(func);
		
		return wordDao.getWordsByFunction(wordSearch);
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
	public void removeLexer(WordAssign wordAssign) {
		wordDao.removeLexer(wordAssign);
	}

	@Override
	public List<Word> getWordsWithGroups(Word word) {
		return wordDao.getWordsWithGroups(word);
	}

	@Override
	public Word getWordById(int wordId) {
		return wordDao.getWordById(wordId);
	}

	@Override
	public void assignWord(Word word) {
		/*WordAssign wordFunction = new WordAssign(word.getId());
		wordFunction.setLexerId(word.getFunctions().get(0).getId());
		
		wordDao.assignFunction(wordFunction);*/
		
		if (CollectionUtils.isNotEmpty(word.getCategories())) {
			for (WordCategory cat : word.getCategories()) {
				WordAssign wordCategory = new WordAssign(word.getId());
				wordCategory.setLexerId(cat.getId());
//				wordCategory.setCategoryType(WordCategoryType.byCode(cat.getCategoryType()));
				
				wordDao.assignCategory(wordCategory);
			}
		}
	}

	@Override
	public Lexer assignCategory(WordAssign wordAssign) {
		wordDao.addWordCategoryInclude(wordAssign);
		
		return lexerService.getLexerById(wordAssign.getLexerId());
	}

	@Override
	public void removeCategory(WordAssign wordAssign) {
		wordDao.removeWordCategoryInclude(wordAssign);
	}

	@Override
	public void saveFixedWord(FixedWord fixedWord) {
		if (fixedWord != null && fixedWord.getId() != null && fixedWord.getSlotId() != null) {
			log.info("--> saveFixedWord(wordId: {}, slotId: {})", fixedWord.getId(), fixedWord.getSlotId());
			List<Word> words = wordDao.getFixedWord(fixedWord.getSlotId());
			if (CollectionUtils.isEmpty(words)) {
				wordDao.addSlotFixedWord(fixedWord);
			} else {
				// update only if word_id is changed
				if (!words.get(0).getId().equals(fixedWord.getId())) {
					wordDao.updateSlotFixedWord(fixedWord);
				}
			}
		}
	}

	@Override
	public List<FixedWord> getFixedWordsForTemplate(Integer templateId) {
		return wordDao.getFixedWords(templateId);
	}

	@Override
	public void removeFixedWords(Set<Integer> ids) {
		if (CollectionUtils.isNotEmpty(ids)) {
			log.info("--> removeFixedWords({})", ids);
			wordDao.removeFixedWords(new ArrayList<Integer>(ids));
		}
	}

}
