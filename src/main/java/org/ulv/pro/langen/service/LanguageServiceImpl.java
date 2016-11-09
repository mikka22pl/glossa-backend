package org.ulv.pro.langen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ulv.pro.langen.dao.LanguageDao;
import org.ulv.pro.langen.model.Course;
import org.ulv.pro.langen.model.Language;

@Service(value = "languageService")
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageDao LanguageDao;
	
	@Override
	public List<Language> getLanguages() {
		return LanguageDao.getLanguages();
	}

	@Override
	public List<Course> getCourses(int languageId) {
		return LanguageDao.getCourses(languageId);
	}
}
