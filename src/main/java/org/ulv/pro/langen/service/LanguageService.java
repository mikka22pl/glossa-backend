package org.ulv.pro.langen.service;

import java.util.List;

import org.ulv.pro.langen.model.Course;
import org.ulv.pro.langen.model.Language;
import org.ulv.pro.langen.model.Lesson;

public interface LanguageService {

	List<Language> getLanguages();
	
	List<Course> getCourses(int languageId);
	
	List<Lesson> getLessons(int courseId);
}
