package org.ulv.pro.langen.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ulv.pro.langen.dao.LanguageDao;
import org.ulv.pro.langen.model.Course;
import org.ulv.pro.langen.model.Language;
import org.ulv.pro.langen.model.Lesson;

@Service(value = "languageService")
public class LanguageServiceImpl implements LanguageService {

	private static final Logger log = LoggerFactory.getLogger(LanguageServiceImpl.class);
	
	@Autowired
	private LanguageDao languageDao;
	
	@Override
	public List<Language> getLanguages() {
		log.info("--> getLanguages()");
		return languageDao.getLanguages();
	}

	@Override
	public List<Course> getCourses(int languageId) {
		log.info("--> getCourses({})", languageId);
		return languageDao.getCourses(languageId);
	}

	@Override
	public List<Lesson> getLessons(int courseId) {
		log.info("--> getLessons({})", courseId);
		return languageDao.getLessons(courseId);
	}
}
