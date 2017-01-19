package org.ulv.pro.langen.ctrl;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ulv.pro.langen.exceptions.GlossaException;
import org.ulv.pro.langen.model.Lexer;
import org.ulv.pro.langen.model.template.TemplateSentence;
import org.ulv.pro.langen.model.template.TemplateSlot;
import org.ulv.pro.langen.model.word.FixedWord;
import org.ulv.pro.langen.service.SentenceService;
import org.ulv.pro.langen.service.TemplateService;
import org.ulv.pro.langen.service.WordService;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/glossa")
public class TemplateController {
	
	private static final Logger log = LoggerFactory.getLogger(TemplateController.class);
	
	@Autowired
	private TemplateService templateService;

	@Autowired
	private SentenceService sentenceService;
	
	@Autowired
	private WordService wordService;
	
	@RequestMapping(value = "/template/{lessonId:[\\d]+}", headers="Accept=application/json")
	public ResponseEntity<TemplateSentence> getTemplate(
			@PathVariable int lessonId) {
		
		try {
			TemplateSentence template = templateService.getTemplateAndSlotsByLessonId(lessonId);
			Collections.sort(template.getItems());
			
			return new ResponseEntity<TemplateSentence>(template, HeadersUtil.HEADERS, HttpStatus.OK);
		} catch (GlossaException e) {
			return new ResponseEntity<TemplateSentence>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/slot/params/{templateId}/{ordering}", headers="Accept=application/json")
	public ResponseEntity<List<Lexer>> slotSpecifies(
			@PathVariable int templateId,
			@PathVariable int ordering) {
		
		List<Lexer> slots = sentenceService.getSlotSpecified(templateId, ordering);
	    
		return new ResponseEntity<List<Lexer>>(slots, HeadersUtil.HEADERS, HttpStatus.OK);
	}
	
	private List<Integer> getIds(final List<FixedWord> fixedWords) {
		List<Integer> ids = Lists.newArrayList();
		for (FixedWord fw : fixedWords) {
			ids.add(fw.getSlotId());
		}
		return ids;
	}
	@RequestMapping(value = "slots/save", headers="Accept=application/json")
	public ResponseEntity<Object> saveSlotSpecifies(@RequestBody TemplateSentence templateSentence) {
		
		log.info("--> saveSlotSpecifies({})", templateSentence);
		
		sentenceService.saveTemplate(templateSentence);
		

		List<FixedWord> dbFixedWords = wordService.getFixedWordsForTemplate(templateSentence.getId());
		Set<Integer> fixedWordsToDelete = new HashSet<Integer>(getIds(dbFixedWords));
		
		for (TemplateSlot slot : templateSentence.getItems()) {
			sentenceService.saveTemplateSlot(slot);
			
			
			log.info("for {}, {}", slot);
			for (FixedWord fword : slot.getFixedWords()) {
				wordService.saveFixedWord(fword);
				fixedWordsToDelete.remove(slot.getId());
			}
		}
		
		wordService.removeFixedWords(fixedWordsToDelete);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
