package org.ulv.pro.langen.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ulv.pro.langen.model.Course;
import org.ulv.pro.langen.model.Language;
import org.ulv.pro.langen.service.LanguageService;


//@CrossOrigin(origins = "http://localhost:5000", maxAge = 3600)
@RestController
public class LanguageController {

	@Autowired
	private LanguageService languageService;
	
	@RequestMapping(value = "/languages", headers="Accept=application/json")
	public ResponseEntity<List<Language>> languages() {
		List<Language> langs = languageService.getLanguages();
		
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Type", "application/json; charset=utf-8");
	    
		return new ResponseEntity<List<Language>>(langs, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/courses/{languageId}", headers="Accept=application/json")
	public ResponseEntity<List<Course>> courses(
			@PathVariable int languageId) {
		
		List<Course> courses = languageService.getCourses(languageId);

		HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Type", "application/json; charset=utf-8");
	    
		return new ResponseEntity<List<Course>>(courses, headers, HttpStatus.OK);
	}
}
