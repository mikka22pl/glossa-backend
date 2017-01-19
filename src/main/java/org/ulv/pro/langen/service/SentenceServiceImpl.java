package org.ulv.pro.langen.service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ulv.pro.langen.conjugatio.ConjTypeEnum;
import org.ulv.pro.langen.conjugatio.lakota.Conjugatio;
import org.ulv.pro.langen.conjugatio.lakota.Klass2YstemConjugatio;
import org.ulv.pro.langen.conjugatio.lakota.Reduplication;
import org.ulv.pro.langen.dao.SentenceDao;
import org.ulv.pro.langen.dao.TranslationDao;
import org.ulv.pro.langen.dao.WordDao;
import org.ulv.pro.langen.exceptions.BaseWordNotExistsException;
import org.ulv.pro.langen.exceptions.GlossaException;
import org.ulv.pro.langen.model.BuildedSentence;
import org.ulv.pro.langen.model.Lexer;
import org.ulv.pro.langen.model.LexerItem;
import org.ulv.pro.langen.model.SentenceWord;
import org.ulv.pro.langen.model.Word;
import org.ulv.pro.langen.model.template.FormedWord;
import org.ulv.pro.langen.model.template.SlotTypeEnum;
import org.ulv.pro.langen.model.template.TemplateSentence;
import org.ulv.pro.langen.model.template.TemplateSlot;
import org.ulv.pro.langen.model.template.WordFormSearch;
import org.ulv.pro.langen.model.word.WordSet;

@Service(value = "sentenceService")
public class SentenceServiceImpl implements SentenceService {

	private static final Logger log = LoggerFactory.getLogger(SentenceServiceImpl.class);
	
	@Autowired
	private SentenceDao sentenceDao;
	
	@Autowired
	private WordDao wordDao;
	
	@Autowired
	private LexerService lexerService;
	
	@Autowired
	private TranslationDao translationDao;

	@Override
	public List<TemplateSentence> getTemplateSentences(int lessonId) {
		log.debug("--> getTemplateSentences(lessonId: {})", lessonId);
		return sentenceDao.getTemplatesByLessonId(lessonId);
	}
	
	/*@Override
	public BuildedSentence getSentenceByTemplate(TemplateSentence template) {
		log.debug("--> getSentenceByTemplate(template: {})", template);
		BuildedSentence bsent = new BuildedSentence();
		
		List<TemplateSlot> items = sentenceDao.getTemplateItems(template.getId());
		template.setItems(items);
		if (CollectionUtils.isNotEmpty(items)) {
			
			TemplateSlot mainPart; // connected == 1
			
			for (TemplateSlot item : template.getItems()) {
				if (ConnectedTypeEnum.MAIN.getCode() == item.getConnected()) {
					mainPart = item;
				}
				// sprawdz wczesniejsze kategorie include
				List<Lexer> categoriesInclude = Lists.newArrayList();
				for (SentenceWord sw : bsent.getWords()) {
					if (CollectionUtils.isNotEmpty(sw.getWord().getCategoriesInclude())) {
						categoriesInclude.addAll(sw.getWord().getCategoriesInclude());
					}
				}
				
				SentenceWord sentenceWord = getWord(item.getFunctionWord(), item.getOrdering(), categoriesInclude);
				
				bsent.addWord(sentenceWord);
				
				gramatical(bsent);
			}
		}
		
		
		return bsent;
	}*/
	
	@Override
	public BuildedSentence getSentenceByTemplate(TemplateSentence template) throws GlossaException {
		log.info("--> getSentenceByTemplate(template: {})", template);
		BuildedSentence sentence = new BuildedSentence();
		
		List<TemplateSlot> items = sentenceDao.getTemplateSlots(template.getId());
		template.setItems(items);
		log.info("get {} items", items.size());
		if (CollectionUtils.isNotEmpty(items)) {
			for (TemplateSlot item : template.getItems()) {
				log.info(" item {}: {}", item.getTemplateId(), item.getOrdering());
				SentenceWord sentenceWord = getSentenceWord(item);

				sentence.addWord(sentenceWord);

				chooseForm(sentenceWord);
				// TODO:
				// gramatical(sentence);
			}
		}
		Collections.sort(sentence.getWords());
		log.info("builded sentence {}", sentence);
		return sentence;
	}
	
	private void chooseForm(SentenceWord sentenceWord) {
		if (CollectionUtils.isNotEmpty(sentenceWord.getConjugationList())) {
			int limit = sentenceWord.getConjugationList().size();
			int randomIndex = getRandom(limit);
			
			WordSet choosen = sentenceWord.getConjugationList().get(randomIndex);
			sentenceWord.setChoosen(choosen);
		}
	}

	private void gramatical(BuildedSentence bsent) {
		if (CollectionUtils.isNotEmpty(bsent.getWords())) {
			int wordsNum = bsent.getWords().size();
			for (int i=0; i< wordsNum; i++) {
				// check if word is a-ablaut
				SentenceWord word = bsent.getWords().get(i);
				
				if (word.getWord().getName().endsWith("A")) {
					// if it is last word
					if (i + 1 == wordsNum) {
						// change to e
						String newWord = word.getWord().getName().substring(0, word.getWord().getName().length() - 1).concat("e");
						word.getWord().setName(newWord);
					} 
//					else {
//						SentenceWord nextWord = bsent.getWords().get(i + 1);
						
						// if next word is one of these:
						//ȟča, ȟčiŋ iŋčhéye,  kačháš kiló kštó któk lakȟá .la láȟ láȟčaka ló
						//nextWord
//					}
				}
				else if (word.getWord().getName().endsWith("Á")) {
					// if it is last word
					if (i + 1 == wordsNum) {
						// change to e
						String newWord = word.getWord().getName().substring(0, word.getWord().getName().length() - 1).concat("é");
						word.getWord().setName(newWord);
					}
				}
			}
		}
	}

	/*@Override
	public BuildedSentence getSentence(SentenceStructure structure, int speechPartId, int order) {

		BuildedSentence bsent = new BuildedSentence();
			
		SentenceWord sentWord = getWord(speechPartId, order);
		
		bsent.getWords().add(sentWord);
		return bsent;
	}*/
	
	private Word getBaseWordRandomly(TemplateSlot slot) {
		
		List<Word> baseWords = wordDao.getWordsBySlot(slot);
		if (CollectionUtils.isEmpty(baseWords)) {
			return null;
		}
		if (baseWords.size() == 1) {
			return baseWords.get(0);
		}
		return baseWords.get(getRandom(baseWords.size()));
	}

	@Override
	public SentenceWord getSentenceWord(TemplateSlot templateSlot) throws GlossaException {
		log.info("--> getSentenceWord({})", templateSlot);
		
		if (SlotTypeEnum.FIXED_WORD.getCode() == templateSlot.getType().getId()) {
			
			List<Word> words = wordDao.getFixedWord(templateSlot.getId());
			
			SentenceWord sentenceWord = new SentenceWord(words.get(0));
			sentenceWord.setOrdering(templateSlot.getOrdering());
			
			return sentenceWord;
		} else if (SlotTypeEnum.RANDOM.getCode() == templateSlot.getType().getId()) {
			
			//List<Word> baseWords = wordDao.getWordsBySlot(slot);
			
			Word baseWord = getBaseWordRandomly(templateSlot);
			
			if (baseWord == null) {
				// throw Excepction
				throw new BaseWordNotExistsException("Base word cannot be find templateId: " + 
						templateSlot.getTemplateId() + "; ordering: " + 
						templateSlot.getOrdering());
			}
			
			baseWord.setTranslations(translationDao.getWordTranslations(baseWord.getId()));
			
			log.info("choosen: {}", baseWord.getName());
			List<Lexer> specifies = sentenceDao.getSlotSpecified(templateSlot);
			SentenceWord sentenceWord = new SentenceWord(baseWord);
			sentenceWord.setOrdering(templateSlot.getOrdering());
			
			if (CollectionUtils.isNotEmpty(specifies)) {

				List<Integer> idList = new ArrayList<Integer>();
				for (Lexer spec : specifies) {
					log.info("spec: {}: {}", spec.getId(), spec.getName());
					idList.add(spec.getId());
				}
				List<LexerItem> forms = lexerService.getLexerAndChildren(idList);
				Set<Integer> specIds = new HashSet<Integer>();
				specIds.add(ConjTypeEnum.TEMPLATE.getCode());
				
				for (LexerItem item : forms) {
					log.info("form: {}: {}", item.getId(), item.getName());
					specIds.add(item.getId());
					if (CollectionUtils.isNotEmpty(item.getChildren())) {
						for (LexerItem child : item.getChildren()) {
							log.info(" - form {}: {}", child.getId(), child.getName());
							specIds.add(child.getId());
						}
					}
				}
				
				
				// singularis
				// - 1sg, 2sg, 3sg
				// dualis
				
				// create forms
				WordFormSearch wordSearch = new WordFormSearch();
				wordSearch.setTemplateId(templateSlot.getTemplateId());
				wordSearch.setOrdering(templateSlot.getOrdering());
				wordSearch.setId(baseWord.getId());
				wordSearch.setFormTypes(specIds);
				
				// sprawdzamy czy slot jest jakos wyspecifikowany
				
				List<FormedWord> formedWords = sentenceDao.getFormedWords(wordSearch);
				
				addConjugatedWords(sentenceWord, forms, formedWords);
				addReduplication(sentenceWord, forms);
			}
			return sentenceWord;
		}
		
		return null;
	}
	
	private FormedWord getTemplate(List<FormedWord> formedWords) {
		log.info("formedWords size {}", formedWords.size());
		for (FormedWord item : formedWords) {
			log.info("filter template {} : {}", item.getVerbForm().getId(), item.getVerbForm().getName());
			if (ConjTypeEnum.TEMPLATE.getCode().equals(item.getVerbForm().getId())) {
				return item;
			}
		}
		log.error("nie znaleziono template w liscie formedWord");
		return null;
	}
	
	private void addConjugatedWords(SentenceWord sentenceWord, List<LexerItem> forms, List<FormedWord> formedWords) {

		Conjugatio conj = new Klass2YstemConjugatio();
		final FormedWord template = getTemplate(formedWords);
		log.info("FromedWord template {}", template);
		
		for (LexerItem form : forms) {
			log.info("form {}: {}", form.getId(), form.getName());
			boolean found = false;
			for (FormedWord fw : formedWords) {
				if (form.getId().equals(fw.getVerbForm().getId())) {
					log.info("      fw: {}: {} -> {}", fw.getVerbForm().getId(), fw.getVerbForm().getName(), fw.getName());
					found = true;
					break;
				}
			}
			if (!found) {
				if (CollectionUtils.isEmpty(form.getChildren())) {
					if (ConjTypeEnum.DUALIS.getCode().equals(form.getId())) {
						sentenceWord.addConjugation(
								new WordSet(
										ConjTypeEnum.DUALIS, 
										conj.buildDualis(sentenceWord.getWord(), template)));
					}
				}
				for (LexerItem child : form.getChildren()) {
					log.info("   child {}: {}", child.getId(), child.getName());
					boolean childFound = false;
					for (FormedWord fw : formedWords) {
						if (child.getId().equals(fw.getVerbForm().getId())) {
							log.info("      fw: {}: {} -> {}", fw.getVerbForm().getId(), fw.getVerbForm().getName(), fw.getName());
							if (ConjTypeEnum.SINGULARIS_1.getCode().equals(child.getId())) {
								sentenceWord.addConjugation(
										new WordSet(
												ConjTypeEnum.SINGULARIS_1, 
												fw.getName()));
							}
							childFound = true;
							found = true;
							break;
						}
					}
					if (!childFound) {
						if (ConjTypeEnum.SINGULARIS_2.getCode().equals(child.getId())) {
							sentenceWord.addConjugation(
									new WordSet(
											ConjTypeEnum.SINGULARIS_2, 
											conj.build2sg(sentenceWord.getWord(), template)));
						}
					}
				}
			}
		}
		sentenceWord.addConjugation(
				new WordSet(
						ConjTypeEnum.SINGULARIS_3, 
						sentenceWord.getWord().getName()));
	}
	
	private void addReduplication(SentenceWord sentenceWord, List<LexerItem> forms) {

		for (LexerItem form : forms) {
			log.info("form {}: {}", form.getId(), form.getName());
			if (ConjTypeEnum.REDUPLICATION.getCode().equals(form.getId())) {
				log.info("is reduplicated");
				String word = sentenceWord.getWord().getName();
				
				String reduplicated = Reduplication.reduplicate(word);
				
				log.info("ns {}", reduplicated);
			}
		}
	}
	
	/*public SentenceWord getWord(LexerLang functionWord, int ordering, List<Lexer> categoriesInclude) {
		log.info("--> getWord({}, {})", functionWord, ordering);
		SentenceWord sword = new SentenceWord();
		
		WordSearch wordSearch = new WordSearch();
		wordSearch.setFunctionWord(functionWord);
		wordSearch.setCategoriesInclude(categoriesInclude);
		log.info("1");
		List<Word> words = wordDao.getWordsByFunction(wordSearch);
		log.info("2");
		if (CollectionUtils.isNotEmpty(words)) {
			log.info("3");
			log.info("words.size() " + words.size());
			int inx = getRandom(words.size());
			Word word = words.get(inx);

			log.info("4");
			word.setTranslations(translationDao.getWordTranslations(word.getId()));

			log.info("5");
			word.setCategoriesInclude(wordDao.getWordCategoriesInclude(word.getId()));

			log.info("6");
			sword.setWord(word);
			sword.setOrdering(ordering);
			
		}
		return sword;
	}*/

	/*public SentenceWord getWord(int speechPartId, int order) {

		List<Word> words = wordDao.getWordsByFunction(func);
		log.info("words.size()" + words.size());
		int inx = getRandom(words.size());
		Word word = words.get(inx);
		
		word.setTranslations(translationDao.getWordTranslations(word.getId()));
		
		SentenceWord sword = new SentenceWord();
		sword.setWord(word);
		sword.setOrdering(ordering);
		
		return sword;
	}*/
	
	
	
	@Override
	public List<Word> getWords(int wordId, Set<Integer> idList) {
		log.info("--> getWords({}, {})", wordId, idList);
		
		WordFormSearch wordForm = new WordFormSearch();
		wordForm.setId(wordId);
		wordForm.setFormTypes(idList);
		
		List<Word> words = sentenceDao.getVerbForms(wordForm);
		return words;
	}

	@Override
	public List<Lexer> getSlotSpecified(int templateId, int ordering) {
		TemplateSlot slot = new TemplateSlot();
		slot.setTemplateId(templateId);
		slot.setOrdering(ordering);
		
		return sentenceDao.getSlotSpecified(slot);
	}

	@Override
	public Integer saveTemplate(TemplateSentence templateSentence) {
		if (templateSentence.isNew()) {
			sentenceDao.addTemplate(templateSentence);
		} else {
			sentenceDao.updateTemplate(templateSentence);
		}
		return templateSentence.getId();
	}

	@Override
	public void saveTemplateSlot(TemplateSlot templateSlot) {
		log.info("--> saveTemplateSlot({} {})", templateSlot.getFunctionWord().getId(), templateSlot.getType().getId());
		if (templateSlot.isNew()) {
			sentenceDao.addTemplateSlot(templateSlot);
		} else {
			sentenceDao.updateTemplateSlot(templateSlot);
		}
	}

	private int getRandom(int limit) {

		Random rand = new Random();
		return rand.nextInt(limit);
	}
}
