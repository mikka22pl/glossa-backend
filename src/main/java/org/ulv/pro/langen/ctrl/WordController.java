package org.ulv.pro.langen.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ulv.pro.langen.model.Lexer;
import org.ulv.pro.langen.model.Translation;
import org.ulv.pro.langen.model.Word;
import org.ulv.pro.langen.model.WordAssign;
import org.ulv.pro.langen.service.TranslationService;
import org.ulv.pro.langen.service.WordService;

/**
 * 
/words/{languageId:[\\d]+}
/words/{languageId:[\\d]+}/{funcId:[\\d]+}
/words/top10/{languageId:[\\d]+}
/words/group/{languageId:[\\d]+}
/word/{wordId:[\\d]+}
/addWord
/assignWord
/removeLexer
/add/translation
/word/include/category
 * 
 * @author Michał
 *
 */
@RestController
@RequestMapping("/glossa")
public class WordController {

	@Autowired
	private WordService wordService;
	
	@Autowired
	private TranslationService translationService;
	
	@RequestMapping(value = "/words/{languageId:[\\d]+}", headers="Accept=application/json")
	public ResponseEntity<List<Word>> words(
			@PathVariable int languageId) {
		
		List<Word> words = wordService.getWords(languageId);
	    
		return new ResponseEntity<List<Word>>(words, HeadersUtil.HEADERS, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/words/{languageId:[\\d]+}/{funcId:[\\d]+}", headers="Accept=application/json")
	public ResponseEntity<List<Word>> wordsByGroup(
			@PathVariable int languageId,
			@PathVariable Integer funcId) {
		
		List<Word> words = wordService.getWordsByFunction(languageId, funcId);
	    
		return new ResponseEntity<List<Word>>(words, HeadersUtil.HEADERS, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/words/top10/{languageId:[\\d]+}", headers="Accept=application/json")
	public ResponseEntity<List<Word>> wordsByLanguage(
			@PathVariable int languageId) {
		
		List<Word> words = wordService.getWordsTop10(languageId);
	    
		return new ResponseEntity<List<Word>>(words, HeadersUtil.HEADERS, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/words/group/{languageId:[\\d]+}", headers="Accept=application/json")
	public ResponseEntity<List<Word>> wordsWithGroups(
			@PathVariable int languageId) {
		
		Word word = new Word();
		word.setLanguageId(languageId);
		
		List<Word> words = wordService.getWordsWithGroups(word);
	    
		return new ResponseEntity<List<Word>>(words, HeadersUtil.HEADERS, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/word/{wordId:[\\d]+}", headers="Accept=application/json")
	public ResponseEntity<Word> wordWithGroups(
			@PathVariable int wordId) {
		
		Word word = wordService.getWordById(wordId);
		
		word.setTranslations(translationService.getWordTranslations(wordId));
		
		return new ResponseEntity<Word>(word, HeadersUtil.HEADERS, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addWord", headers="Accept=application/json")
	public void saveWord(@RequestBody Word word) {
		wordService.saveWord(word);
	}
	
	@RequestMapping(value = "/assignWord", headers="Accept=application/json")
	public void assignWord(@RequestBody Word word) {
		wordService.assignWord(word);
	}
	
	@RequestMapping(value = "/removeLexer", headers="Accept=application/json")
	public void removeLexer(@RequestBody WordAssign wordAssign) {
		wordService.removeLexer(wordAssign);
	}
	

	@RequestMapping(value = "/add/translation", method=RequestMethod.POST, headers="Accept=application/json")
	public void addTranslation(@RequestBody Translation translation) {
		translationService.saveTranslation(translation);
	}
	
	@RequestMapping(value = "/word/include/category", method=RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<Lexer> includeCategory(@RequestBody WordAssign wordAssign) {
		
		Lexer lexer = wordService.assignCategory(wordAssign);
		return new ResponseEntity<Lexer>(lexer, HeadersUtil.HEADERS, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/word/exclude/category", method=RequestMethod.POST, headers="Accept=application/json")
	public void excludeCategory(@RequestBody WordAssign wordAssign) {
		
		wordService.removeCategory(wordAssign);
	}
}
