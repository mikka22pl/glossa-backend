package org.ulv.pro.langen.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ulv.pro.langen.model.BuildedSentence;
import org.ulv.pro.langen.model.SentenceStructure;
import org.ulv.pro.langen.service.SentenceService;

@RestController
public class SentenceController {
	
	@Autowired
	private SentenceService sentenceService;
	
	@RequestMapping(value = "/struct/{languageId}/{lessonId}", headers="Accept=application/json")
	public ResponseEntity<List<SentenceStructure>> sentenceStructures(
			@PathVariable int languageId,
			@PathVariable int lessonId) {
		
		SentenceStructure struct = new SentenceStructure();
		struct.setLanguageId(languageId);
		struct.setLessonId(lessonId);
		
		List<SentenceStructure> structs = sentenceService.getSentenceStructures(struct);
	    
		return new ResponseEntity<List<SentenceStructure>>(structs, HeadersUtil.HEADERS, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/learn/{languageId}", headers="Accept=application/json")
	public ResponseEntity<BuildedSentence> sentence(
			@PathVariable int languageId) {
		
		BuildedSentence bsent = sentenceService.getSentence(languageId);
	    
		return new ResponseEntity<BuildedSentence>(bsent, HeadersUtil.HEADERS, HttpStatus.OK);
	}
}
