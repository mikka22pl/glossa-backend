package org.ulv.pro.langen.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ulv.pro.langen.model.DictionaryEntry;
import org.ulv.pro.langen.model.WordTranslationAssign;

@Component
public class TranslationDao {

	@Autowired
	private SqlSession sqlSession;
	
	
	public List<DictionaryEntry> getWordTranslations(int wordId) {
		return sqlSession.selectList("getWordTranslations", wordId);
	}
	
	public DictionaryEntry getTranslation(String entry) {
		return sqlSession.selectOne("getTranslation", entry);
	}

	public Integer addTranslation(DictionaryEntry entry) {
		return sqlSession.insert("addTranslation", entry);
	}
	
	public void assignDictionaryEntryToWord(WordTranslationAssign translation) {
		sqlSession.insert("assignDictionaryEntryToWord", translation);
	}
}
