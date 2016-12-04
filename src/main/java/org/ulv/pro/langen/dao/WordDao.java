package org.ulv.pro.langen.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ulv.pro.langen.model.LexerLang;
import org.ulv.pro.langen.model.Word;
import org.ulv.pro.langen.model.WordAssign;

@Component
public class WordDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<Word> getWordsByFunction(LexerLang func) {
		return sqlSession.selectList("getWordsByFunction", func);
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
	
	public List<Word> getWordsWithGroups(Word word) {
		return sqlSession.selectList("getWordsWithGroups", word);
	}
	
	public void removeLexer(WordAssign wordAssign) {
		sqlSession.delete("removeLexer", wordAssign);
	}
	
	public void assignCategory(WordAssign wordAssign) {
		sqlSession.insert("assignCategory", wordAssign);
	}
}
