package org.ulv.pro.langen.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ulv.pro.langen.dao.TranslationDao;
import org.ulv.pro.langen.model.DictionaryEntry;
import org.ulv.pro.langen.model.Translation;
import org.ulv.pro.langen.model.Word;
import org.ulv.pro.langen.model.WordTranslationAssign;

@Service(value = "translationService")
public class TranslationServiceImpl implements TranslationService {

	private static final Logger log = LoggerFactory.getLogger(TranslationServiceImpl.class);
	
	@Autowired
	private TranslationDao translationDao;
	
	@Override
	public List<DictionaryEntry> getWordTranslations(int wordId) {
		log.debug("--> getWordTranslations() {}", wordId);
		
		return translationDao.getWordTranslations(wordId);
	}

	@Override
	public void saveTranslation(Translation translation) {
		log.debug("--> saveTranslation() {}", translation);
		if (translation.isNew()) {
			for (DictionaryEntry entry : translation.getEntries()) {
				DictionaryEntry dbEntry = translationDao.getTranslation(entry.getName());
				if (dbEntry != null) {
					assignToWord(translation.getWord(), dbEntry);
				} else {
					translationDao.addTranslation(entry);
					log.debug("new DictinaryEntry.id {}", entry.getId());
					
					assignToWord(translation.getWord(), entry);
				}
			}
		}
	}
	
	private void assignToWord(Word word, DictionaryEntry entry) {
		WordTranslationAssign translation = new WordTranslationAssign();
		translation.setWordId(word.getId());
		translation.setEntryId(entry.getId());
		
		translationDao.assignDictionaryEntryToWord(translation);
	}
	
	private void addTranslation(DictionaryEntry entry) {
		translationDao.addTranslation(entry);
	}

}
