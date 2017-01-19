package org.ulv.pro.langen.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hamcrest.CoreMatchers;
import org.hamcrest.core.IsNot;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.ulv.pro.langen.conjugatio.ConjTypeEnum;
import org.ulv.pro.langen.dao.SentenceDao;
import org.ulv.pro.langen.dao.TranslationDao;
import org.ulv.pro.langen.dao.WordDao;
import org.ulv.pro.langen.model.BuildedSentence;
import org.ulv.pro.langen.model.Lexer;
import org.ulv.pro.langen.model.LexerItem;
import org.ulv.pro.langen.model.LexerLang;
import org.ulv.pro.langen.model.SentenceWord;
import org.ulv.pro.langen.model.Word;
import org.ulv.pro.langen.model.template.FormedWord;
import org.ulv.pro.langen.model.template.SlotTypeEnum;
import org.ulv.pro.langen.model.template.TemplateSentence;
import org.ulv.pro.langen.model.template.TemplateSlot;
import org.ulv.pro.langen.model.template.WordFormSearch;
import org.ulv.pro.langen.model.word.WordSet;
import org.ulv.pro.langen.utils.ConjugatedWordUtils;

@RunWith(MockitoJUnitRunner.class)
public class SentenceServiceImplTest {

	@Mock
	private WordDao wordDao;
	
	@Mock
	private TranslationDao translationDao;
	
	@Mock
	private SentenceDao sentenceDao;
	
	@Mock
	private LexerService lexerService;
	
	@InjectMocks
	private SentenceServiceImpl service;
	
	//@Test
	/*public void testGetWord() {
		List<Word> words = new ArrayList<Word>();
		words.add(new Word(1, "one", 5));
		words.add(new Word(2, "two", 5));
		words.add(new Word(3, "three", 5));
		
		List<Lexer> categoriesInclude = Lists.newArrayList();
		
		LexerLang func = new LexerLang();
		func.setId(1);
		WordSearch wordSearch = new WordSearch();
		wordSearch.setFunctionWord(func);
		
		List<DictionaryEntry> entries = new ArrayList<>();
		
		// given
		given(wordDao.getWordsByFunction(wordSearch)).willReturn(words);
		given(wordDao.getWordCategoriesInclude(anyInt())).willReturn(categoriesInclude);
		given(translationDao.getWordTranslations(Mockito.anyInt())).willReturn(entries);
		
		// when
		SentenceWord sentenceWord = service.getWord(func, 1, categoriesInclude);
		
		// then
		Assert.assertThat(sentenceWord, notNullValue());
		Assert.assertThat(sentenceWord.getWord(), notNullValue());
		Assert.assertThat(sentenceWord.getWord().getName(), notNullValue());
	}*/
	
	@Test
	public void should_get_verb_forms() throws Exception {
		// given
		
		Word word1 = new Word();
		word1.setId(1);
		word1.setName("bluhá");
		List<Word> dbWords = new ArrayList<Word>();
		dbWords.add(word1);

		WordFormSearch wordForm = new WordFormSearch();
		wordForm.setId(1);
		wordForm.getFormTypes().add(22);
		wordForm.getFormTypes().add(23);
		wordForm.getFormTypes().add(31);
		
		given(sentenceDao.getVerbForms(wordForm)).willReturn(dbWords);
		
		Set<Integer> ids = new HashSet<Integer>();
		ids.add(22);
		ids.add(23);
		ids.add(31);
		
		// when
		List<Word> words = service.getWords(1, ids);
		
		// then
		Assert.assertThat(words, notNullValue());
		Assert.assertThat(words.get(0), notNullValue());
		Assert.assertThat(words.get(0).getId(), CoreMatchers.is(1));
		Assert.assertThat(words.get(0).getName(), CoreMatchers.is("bluhá"));
	}
	
	@Test
	public void should_get_slot_specified_list() {
		// given
		TemplateSlot slot = new TemplateSlot();
		slot.setTemplateId(1);
		slot.setOrdering(3);
		
		Lexer l1 = new Lexer();
		l1.setId(1);
		l1.setName("singularis");
		l1.setDescr("singularis");
		
		Lexer l2 = new Lexer();
		l2.setId(5);
		l2.setName("dualis");
		l2.setDescr("dualis");
		
		List<Lexer> list = new ArrayList<Lexer>();
		list.add(l1);
		list.add(l2);
		
		given(sentenceDao.getSlotSpecified(slot)).willReturn(list);
		
		// when
		List<Lexer> specs = service.getSlotSpecified(1, 3);
		
		// then
		Assert.assertThat(specs, notNullValue());
		Assert.assertThat(specs.size(), CoreMatchers.is(2));
		Assert.assertThat(specs.get(0), notNullValue());
		Assert.assertThat(specs.get(0).getId(), CoreMatchers.is(1));
		Assert.assertThat(specs.get(0).getName(), CoreMatchers.is("singularis"));
		Assert.assertThat(specs.get(0).getDescr(), CoreMatchers.is("singularis"));
		Assert.assertThat(specs.get(1).getId(), CoreMatchers.is(5));
		Assert.assertThat(specs.get(1).getName(), CoreMatchers.is("dualis"));
		Assert.assertThat(specs.get(1).getDescr(), CoreMatchers.is("dualis"));
	}
	
	@Test
	public void should_get_proper_words_for_slot() throws Exception {
		
		String expectedSg1 = "bluhá";
		String expectedSg2 = "luhá";
		String expectedSg3 = "yuhá";
		String expectedDu = "uŋyúha";

		Word word3 = new Word(3, expectedSg3);
		word3.setLanguageId(5);
		word3.setConjugatioType(new LexerItemBuilder(34, "CLASS_II", "klasa II y-stem", 32).build());
		
		List<Word> expectedBaseWords = new ArrayList<Word>();
		expectedBaseWords.add(word3);
		
		LexerLang functionWord = new LexerLang();
		functionWord.setId(7);
		
		TemplateSlot slot = new TemplateSlot();
		slot.setTemplateId(33);
		slot.setOrdering(4);
		
		List<Lexer> expectedSpecifies = new ArrayList<Lexer>();
		expectedSpecifies.add(new Lexer(44, "singularis", "singularis"));
		expectedSpecifies.add(new Lexer(47, "dualis", "dualis"));
		expectedSpecifies.add(new Lexer(31, "template", "template"));
		
		List<Integer> idList = new ArrayList<Integer>();
		idList.add(44);
		idList.add(47);
		idList.add(31);
		
		List<LexerItem> expectedSpecTree = new ArrayList<LexerItem>();
		
		LexerItem sg1 = new LexerItemBuilder(22, "1sg", "1 os. singularis", 44).build();
		LexerItem sg2 = new LexerItemBuilder(23, "2sg", "2 os. singularis", 44).build();
		LexerItem sg3 = new LexerItemBuilder(24, "3sg", "3 os. singularis", 44).build();
		
		LexerItem singularis = new LexerItemBuilder(44, "singularis", "singularis", 14)
				.withChild(sg1)
				.withChild(sg2)
				.withChild(sg3)
				.build();
		LexerItem dualis = new LexerItemBuilder(25, "dualis", "dualis", 14).build();
		LexerItem template = new LexerItemBuilder(31, "template", "template", 14).build();
		
		expectedSpecTree.add(singularis);
		expectedSpecTree.add(dualis);
		expectedSpecTree.add(template);
		
		WordFormSearch wordFormSearch = new WordFormSearch();
		wordFormSearch.setId(word3.getId());
		wordFormSearch.setTemplateId(33);
		wordFormSearch.setOrdering(4);
		
		List<FormedWord> expectedFormedWords = new ArrayList<FormedWord>();
		FormedWord fw1 = new FormedWord();
		fw1.setId(3);
		fw1.setName("bluhá");
		fw1.setVerbForm(sg1);
		
		FormedWord fw2 = new FormedWord();
		fw2.setId(4);
		fw2.setName("x-yuhá-pl");
		fw2.setVerbForm(template);
		
		expectedFormedWords.add(fw1);
		expectedFormedWords.add(fw2);
		
		TemplateSlot tslot = new TemplateSlot();
		tslot.setTemplateId(1);
		tslot.setOrdering(4);
		tslot.setType(new LexerItemBuilder(SlotTypeEnum.RANDOM.getCode(), "random", "random", null).build());

		// given
		given(wordDao.getWordsBySlot(slot)).willReturn(expectedBaseWords);
		given(sentenceDao.getSlotSpecified(slot)).willReturn(expectedSpecifies);
		given(lexerService.getLexerAndChildren(idList)).willReturn(expectedSpecTree);
		given(sentenceDao.getFormedWords(wordFormSearch)).willReturn(expectedFormedWords);
		
		// when
		SentenceWord word = service.getSentenceWord(tslot);
		
		// then
		Assert.assertThat(word, notNullValue());
		Assert.assertThat(word.getWord(), notNullValue());
		Assert.assertThat(word.getConjugationList(), notNullValue());
		Assert.assertThat(word.getConjugationList().size(), is(4));
		Assert.assertThat(ConjugatedWordUtils.findSingularis1(word.getConjugationList()), is(expectedSg1));
		Assert.assertThat(ConjugatedWordUtils.findSingularis2(word.getConjugationList()), is(expectedSg2));
		Assert.assertThat(ConjugatedWordUtils.findSingularis3(word.getConjugationList()), is(expectedSg3));
		Assert.assertThat(ConjugatedWordUtils.findDualis(word.getConjugationList()), is(expectedDu));
	}
	
	/*@Test
	public void should_get_reduplicated_form_for_adjective() throws Exception {
		
		String expected = "gigi";

		Word word1 = new Word(1, expected);
		word1.setLanguageId(5);
		word1.setConjugatioType(new LexerItemBuilder(37, "CLASS_II", "klasa II y-stem", 32).build());
		
		List<Word> expectedBaseWords = new ArrayList<Word>();
		expectedBaseWords.add(word1);
		
		LexerLang functionWord = new LexerLang();
		functionWord.setId(8); // adjective
		
		TemplateSlot slot = new TemplateSlot();
		slot.setTemplateId(33);
		slot.setOrdering(4);
		
		List<Lexer> expectedSpecifies = new ArrayList<Lexer>();
		expectedSpecifies.add(new Lexer(37, "reduplication", "reduplication"));
		
		List<Integer> idList = new ArrayList<Integer>();
		idList.add(37);
		
		List<LexerItem> expectedSpecTree = new ArrayList<LexerItem>();
		
		LexerItem sg1 = new LexerItemBuilder(37, "reduplication", "reduplication", 44).build();
		
		expectedSpecTree.add(sg1);
		
		WordFormSearch wordFormSearch = new WordFormSearch();
		wordFormSearch.setId(word1.getId());
		wordFormSearch.setTemplateId(33);
		wordFormSearch.setOrdering(4);
		
		List<FormedWord> expectedFormedWords = new ArrayList<FormedWord>();
		FormedWord fw1 = new FormedWord();
		fw1.setId(3);
		fw1.setName("bluhá");
		fw1.setVerbForm(sg1);
		
		expectedFormedWords.add(fw1);
		
		TemplateSlot tslot = new TemplateSlot();
		tslot.setTemplateId(1);
		tslot.setOrdering(4);
		tslot.setType(new LexerItemBuilder(SlotTypeEnum.RANDOM.getCode(), "random", "random", null).build());

		// given
		given(wordDao.getWordsBySlot(slot)).willReturn(expectedBaseWords);
		given(sentenceDao.getSlotSpecified(slot)).willReturn(expectedSpecifies);
		given(lexerService.getLexerAndChildren(idList)).willReturn(expectedSpecTree);
		given(sentenceDao.getFormedWords(wordFormSearch)).willReturn(expectedFormedWords);
		
		// when
		SentenceWord word = service.getSentenceWord(tslot);
		
		// then
		Assert.assertThat(word, notNullValue());
		Assert.assertThat(word.getWord(), notNullValue());
		Assert.assertThat(word.getConjugationList(), notNullValue());
		Assert.assertThat(word.getConjugationList().size(), is(4));
		Assert.assertThat(ConjugatedWordUtils.findSingularis1(word.getConjugationList()), is(expectedSg1));
	}*/
	
	@Test
	public void should_get_sentence_word_list_of_a_template() throws Exception {
		
		TemplateSentence template = new TemplateSentence();
		template.setId(1);
		
		List<TemplateSlot> expectedSlots = new ArrayList<TemplateSlot>();
		TemplateSlot slot = new TemplateSlot();
		slot.setTemplateId(1);
		slot.setOrdering(1);
		slot.setType(new LexerItemBuilder(SlotTypeEnum.RANDOM.getCode(), "a", "b", null).build());
		expectedSlots.add(slot);

		Word word = new Word(1, "blabla");
		
		SentenceWord sentenceWord = new SentenceWord(word);
		sentenceWord.setOrdering(1);
		sentenceWord.addConjugation(new WordSet(ConjTypeEnum.SINGULARIS_1, "blable"));
		
		List<Word> baseWords = new ArrayList<Word>();
		baseWords.add(word);
		
		// given
		given(sentenceDao.getTemplateSlots(template.getId())).willReturn(expectedSlots);
		given(wordDao.getWordsBySlot(slot)).willReturn(baseWords);
		
		// when
		BuildedSentence sentence = service.getSentenceByTemplate(template);
		
		// then
		Assert.assertThat(sentence, notNullValue());
		Assert.assertThat(sentence.getWords(), notNullValue());
		Assert.assertThat(sentence.getWords().size(), is(1));
		Assert.assertThat(sentence.getWords().get(0), notNullValue());
		Assert.assertThat(sentence.getWords().get(0).getWord(), notNullValue());
		Assert.assertThat(sentence.getWords().get(0).getWord().getId(), is(1));
		Assert.assertThat(sentence.getWords().get(0).getWord().getName(), is("blabla"));
	}
	
	@Test
	public void should_get_sentence_word_list_of_3_words_of_a_template() throws Exception {
		
		TemplateSentence template = new TemplateSentence();
		template.setId(1);
		
		List<TemplateSlot> expectedSlots = new ArrayList<TemplateSlot>();
		TemplateSlot slot1 = new TemplateSlot(1, 1);
		slot1.setType(new LexerItemBuilder(SlotTypeEnum.RANDOM.getCode(), "a", "b", null).build());
		TemplateSlot slot2 = new TemplateSlot(1, 2);
		slot2.setType(new LexerItemBuilder(SlotTypeEnum.RANDOM.getCode(), "a", "b", null).build());
		TemplateSlot slot3 = new TemplateSlot(1, 3);
		slot3.setType(new LexerItemBuilder(SlotTypeEnum.RANDOM.getCode(), "a", "b", null).build());
		
		expectedSlots.add(slot1);
		expectedSlots.add(slot2);
		expectedSlots.add(slot3);

		Word word1 = new Word(1, "blabla");
		Word word2 = new Word(2, "lulać");
		Word word3 = new Word(3, "hrumkać");
		
		SentenceWord sentenceWord1 = new SentenceWord(word1);
		sentenceWord1.setOrdering(1);
		sentenceWord1.addConjugation(new WordSet(ConjTypeEnum.SINGULARIS_1, "blable"));
		
		SentenceWord sentenceWord2 = new SentenceWord(word2);
		sentenceWord2.setOrdering(2);
		sentenceWord2.addConjugation(new WordSet(ConjTypeEnum.SINGULARIS_1, "lulam"));
		
		SentenceWord sentenceWord3 = new SentenceWord(word2);
		sentenceWord3.setOrdering(3);
		sentenceWord3.addConjugation(new WordSet(ConjTypeEnum.SINGULARIS_1, "hrumkam"));
		
		List<Word> baseWords1 = new ArrayList<Word>();
		baseWords1.add(word1);
		List<Word> baseWords2 = new ArrayList<Word>();
		baseWords2.add(word2);
		List<Word> baseWords3 = new ArrayList<Word>();
		baseWords3.add(word3);
		
		// given
		given(sentenceDao.getTemplateSlots(template.getId())).willReturn(expectedSlots);
		given(wordDao.getWordsBySlot(slot1))
				.willReturn(baseWords1)
				.willReturn(baseWords2)
				.willReturn(baseWords3);
		
		// when
		BuildedSentence sentence = service.getSentenceByTemplate(template);
		
		// then
		Assert.assertThat(sentence, notNullValue());
		Assert.assertThat(sentence.getWords(), notNullValue());
		Assert.assertThat(sentence.getWords().size(), is(3));
		
		Assert.assertThat(sentence.getWords().get(0), notNullValue());
		Assert.assertThat(sentence.getWords().get(0).getWord(), notNullValue());
		Assert.assertThat(sentence.getWords().get(0).getWord().getId(), is(1));
		Assert.assertThat(sentence.getWords().get(0).getWord().getName(), is("blabla"));
		
		Assert.assertThat(sentence.getWords().get(1), notNullValue());
		Assert.assertThat(sentence.getWords().get(1).getWord(), notNullValue());
		Assert.assertThat(sentence.getWords().get(1).getWord().getId(), is(2));
		Assert.assertThat(sentence.getWords().get(1).getWord().getName(), is("lulać"));
		
		Assert.assertThat(sentence.getWords().get(2), notNullValue());
		Assert.assertThat(sentence.getWords().get(2).getWord(), notNullValue());
		Assert.assertThat(sentence.getWords().get(2).getWord().getId(), is(3));
		Assert.assertThat(sentence.getWords().get(2).getWord().getName(), is("hrumkać"));
	}
}
