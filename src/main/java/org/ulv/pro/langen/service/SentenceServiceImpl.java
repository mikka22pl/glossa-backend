package org.ulv.pro.langen.service;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.ulv.pro.langen.dao.SentenceDao;
import org.ulv.pro.langen.dao.WordDao;
import org.ulv.pro.langen.model.BuildedSentence;
import org.ulv.pro.langen.model.LexerLang;
import org.ulv.pro.langen.model.SentenceStructure;
import org.ulv.pro.langen.model.SentenceWord;
import org.ulv.pro.langen.model.Word;

@Service(value = "sentenceService")
public class SentenceServiceImpl implements SentenceService {

	private static final Logger log = LoggerFactory.getLogger(SentenceServiceImpl.class);
	
	@Autowired
	private SentenceDao sentenceDao;
	
	@Autowired
	private WordDao wordDao;
	
	@Override
	public List<SentenceStructure> getSentenceStructures(SentenceStructure struct) {
		return sentenceDao.getSentenceStructures(struct);
	}

	@Override
	public BuildedSentence getSentence(int lessonId) {
		SentenceStructure struct = new SentenceStructure();
		struct.setLessonId(lessonId);
		
		List<SentenceStructure> structs = getSentenceStructures(struct);
		if (!CollectionUtils.isEmpty(structs)) {

			BuildedSentence bsent = new BuildedSentence();
			for (SentenceStructure structure : structs) {
				log.info("{}", structure.getOrdering());
				
				SentenceWord sentWord = getWord(structure.getFunc(), structure.getOrdering());
				
				bsent.getWords().add(sentWord);
			}
			return bsent;
		}
		return null;
	}
	
	public SentenceWord getWord(LexerLang func, int ordering) {

		List<Word> words = wordDao.getWordsByFunction(func);
		log.info("words.size()" + words.size());
		int inx = getRandom(words.size());
		Word word = words.get(inx);
		
		SentenceWord sword = new SentenceWord();
		sword.setWord(word);
		sword.setOrdering(ordering);
		
		return sword;
	}
	
	private int getRandom(int limit) {

		Random rand = new Random();
		return rand.nextInt(limit);
	}
}
