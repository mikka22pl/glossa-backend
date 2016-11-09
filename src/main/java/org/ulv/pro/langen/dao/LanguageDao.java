package org.ulv.pro.langen.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ulv.pro.langen.model.Course;
import org.ulv.pro.langen.model.Language;

@Component
public class LanguageDao {


	@Autowired
	private SqlSession sqlSession;
	
	public List<Language> getLanguages() {
		return this.sqlSession.selectList("getLanguage");
	}
	
	public List<Course> getCourses(int languageId) {
		return this.sqlSession.selectList("getCourses", languageId);
	}
}
