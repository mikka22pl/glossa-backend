package org.ulv.pro.langen.service;

import java.util.List;
import java.util.Set;

import org.ulv.pro.langen.exceptions.GlossaException;
import org.ulv.pro.langen.model.BuildedSentence;
import org.ulv.pro.langen.model.Lexer;
import org.ulv.pro.langen.model.LexerItem;
import org.ulv.pro.langen.model.SentenceWord;
import org.ulv.pro.langen.model.Word;
import org.ulv.pro.langen.model.template.TemplateSentence;
import org.ulv.pro.langen.model.template.TemplateSlot;

public interface SentenceService {

	List<TemplateSentence> getTemplateSentences(int lessonId);
	
	List<Word> getWords(int wordId, Set<Integer> idList);
	
	BuildedSentence getSentenceByTemplate(TemplateSentence template) throws GlossaException;
	
	List<Lexer> getSlotSpecified(int templateId, int ordering);
	
	SentenceWord getSentenceWord(TemplateSlot templateSlot) throws GlossaException;
	
	Integer saveTemplate(TemplateSentence templateSentence);
	
	void saveTemplateSlot(TemplateSlot templateSlot);
	//BuildedSentence getSentenceByTemplate(TemplateSentence template);
}
