package org.ulv.pro.langen.service;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.ulv.pro.langen.dao.WordDao;
import org.ulv.pro.langen.model.LexerLang;
import org.ulv.pro.langen.model.SentenceWord;
import org.ulv.pro.langen.model.Word;

@RunWith(MockitoJUnitRunner.class)
public class SentenceServiceImplTest {

	@Mock
	private WordDao wordDao;
	
	@InjectMocks
	private SentenceServiceImpl service;
	
	@Test
	public void testGetWord() {
		List<Word> words = new ArrayList<Word>();
		words.add(new Word(1, "one", 5));
		words.add(new Word(2, "two", 5));
		words.add(new Word(3, "three", 5));
		
		LexerLang func = new LexerLang();
		func.setId(1);
		
		// given
		given(wordDao.getWordsByFunction(func)).willReturn(words);
		
		// when
		SentenceWord sentenceWord = service.getWord(func, 1);
		
		// then
		Assert.assertThat(sentenceWord, notNullValue());
		Assert.assertThat(sentenceWord.getWord(), notNullValue());
		Assert.assertThat(sentenceWord.getWord().getName(), notNullValue());
	}
}
