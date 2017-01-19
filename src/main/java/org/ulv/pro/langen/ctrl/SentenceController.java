package org.ulv.pro.langen.ctrl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ulv.pro.langen.exceptions.GlossaException;
import org.ulv.pro.langen.model.BuildedSentence;
import org.ulv.pro.langen.model.Lexer;
import org.ulv.pro.langen.model.SentenceTranslation;
import org.ulv.pro.langen.model.template.TemplateSentence;
import org.ulv.pro.langen.service.SentenceService;
import org.ulv.pro.langen.service.TranslationService;

@RestController
@RequestMapping("/glossa")
public class SentenceController {

	private static final Logger log = LoggerFactory.getLogger(SentenceController.class);
	
	@Autowired
	private SentenceService sentenceService;
	
	@Autowired
	private TranslationService translationService;
	
	@RequestMapping(value = "/struct/{lessonId}", headers="Accept=application/json")
	public ResponseEntity<List<TemplateSentence>> sentenceStructures(
			@PathVariable int lessonId) {
		
		List<TemplateSentence> templates = sentenceService.getTemplateSentences(lessonId);
	    
		return new ResponseEntity<List<TemplateSentence>>(templates, HeadersUtil.HEADERS, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/learn", method=RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<BuildedSentence> sentence(
			@RequestBody TemplateSentence template) {
		
		try {
			BuildedSentence bsent = sentenceService.getSentenceByTemplate(template);
			return new ResponseEntity<BuildedSentence>(bsent, HeadersUtil.HEADERS, HttpStatus.OK);
		} catch (GlossaException e) {
			return new ResponseEntity<BuildedSentence>(null, HeadersUtil.HEADERS, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/translation/add", method=RequestMethod.POST, headers="Accept=application/json")
	public void saveTranslation(
			@RequestBody SentenceTranslation sentenceTranslation) {
		
		translationService.addSentenceTranslation(sentenceTranslation);
	}
	
	@RequestMapping(value = "/sentence/translation/", method=RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<SentenceTranslation> getSentenceTranslation(
			@RequestBody SentenceTranslation sentenceTranslation) {
		
		SentenceTranslation translation = translationService.getSentenceTranslation(sentenceTranslation);

		return new ResponseEntity<SentenceTranslation>(translation, HeadersUtil.HEADERS, HttpStatus.OK);
	}
	
}
