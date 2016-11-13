package org.ulv.pro.langen.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ulv.pro.langen.model.Word;
import org.ulv.pro.langen.service.WordService;

@RestController
public class WordController {

	@Autowired
	private WordService wordService;
	
	@RequestMapping(value = "/words/{languageId:[\\d]+}", headers="Accept=application/json")
	public ResponseEntity<List<Word>> words(
			@PathVariable int languageId) {
		
		List<Word> words = wordService.getWords(languageId);
		
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Type", "application/json; charset=utf-8");
	    
		return new ResponseEntity<List<Word>>(words, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/words/{languageId:[\\d]+}/{groupId:[\\d]+}", headers="Accept=application/json")
	public ResponseEntity<List<Word>> wordsByGroup(
			@PathVariable int languageId,
			@PathVariable Integer groupId) {
		
		List<Word> words = wordService.getWordsByGroup(languageId, groupId);
		
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Type", "application/json; charset=utf-8");
	    
		return new ResponseEntity<List<Word>>(words, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/words/top10/{languageId:[\\d]+}", headers="Accept=application/json")
	public ResponseEntity<List<Word>> wordsByLanguage(
			@PathVariable int languageId) {
		
		List<Word> words = wordService.getWordsTop10(languageId);
		
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Type", "application/json; charset=utf-8");
	    
		return new ResponseEntity<List<Word>>(words, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addWord", headers="Accept=application/json")
	public void saveWord(@RequestBody Word word) {
		wordService.saveWord(word);
	}
}
