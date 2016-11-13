package org.ulv.pro.langen.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ulv.pro.langen.model.Word;
import org.ulv.pro.langen.model.WordGroup;

@Component
public class WordDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<Word> getWordsByGroup(WordGroup group) {
		return sqlSession.selectList("getWordsByGroup", group);
	}
	
	public List<Word> getWords(Word word) {
		return sqlSession.selectList("getWords", word);
	}
	
	public List<Word> getWordsTop10(Word word) {
		return sqlSession.selectList("getWordsTop10", word);
	}
	
	public void addWord(Word word) {
		sqlSession.insert("addWord", word);
	}
}
