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
import org.ulv.pro.langen.model.LexerItem;
import org.ulv.pro.langen.service.LexerService;

@RestController
@RequestMapping("/glossa")
public class LexerController {

	@Autowired
	private LexerService lexerService;
	
	@RequestMapping(value = "/lexers", method=RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<List<Lexer>> categories() {
		
		List<Lexer> categories = lexerService.getCategories();
		
		return new ResponseEntity<List<Lexer>>(categories, HeadersUtil.HEADERS, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/lexer/save", method=RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<Integer> saveLexer(@RequestBody LexerItem lexer) {
		Integer id = lexerService.saveLexer(lexer);
		
		return new ResponseEntity<Integer>(id, HeadersUtil.HEADERS, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/lexer/category/save", method=RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<Integer> saveCategory(@RequestBody Lexer lexer) {
		
		Integer id = lexerService.saveCategory(lexer);
		
		return new ResponseEntity<Integer>(id, HeadersUtil.HEADERS, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/lexers/bycategory/{categoryId}", method=RequestMethod.GET)
	public ResponseEntity<List<LexerItem>> listLexers(
			@PathVariable int categoryId) {
		
		List<LexerItem> lexers = lexerService.getLexersByCategory(categoryId);
		
		return new ResponseEntity<List<LexerItem>>(lexers, HeadersUtil.HEADERS, HttpStatus.OK);
	}
}
