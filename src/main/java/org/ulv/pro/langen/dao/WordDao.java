package org.ulv.pro.langen.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ulv.pro.langen.model.Lexer;
import org.ulv.pro.langen.model.Word;
import org.ulv.pro.langen.model.WordAssign;
import org.ulv.pro.langen.model.WordSearch;
import org.ulv.pro.langen.model.template.TemplateSlot;
import org.ulv.pro.langen.model.word.FixedWord;

@Component
public class WordDao {

	@Autowired
	private SqlSession sqlSession;

	public List<Word> getWordsByFunction(WordSearch wordSearch) {
		return sqlSession.selectList("getWordsByFunction", wordSearch);
	}

	public List<Word> getWords(Word word) {
		return sqlSession.selectList("getWords", word);
	}

	public List<Word> getWordsTop10(Word word) {
		return sqlSession.selectList("getWordsTop10", word);
	}

	public Word getWordById(int wordId) {
		return sqlSession.selectOne("getWordById", wordId);
	}

	public void addWord(Word word) {
		sqlSession.insert("addWord", word);
	}

	public List<Word> getWordsWithGroups(Word word) {
		return sqlSession.selectList("getWordsWithGroups", word);
	}

	public List<Word> getWordsBySlot(TemplateSlot slot) {
		return sqlSession.selectList("getWordsBySlot", slot);
	}

	public List<Word> getFixedWord(int slotId) {
		return sqlSession.selectList("getFixedWord", slotId);
	}

	public void removeLexer(WordAssign wordAssign) {
		sqlSession.delete("removeLexer", wordAssign);
	}

	public void assignCategory(WordAssign wordAssign) {
		sqlSession.insert("assignCategory", wordAssign);
	}

	public void addWordCategoryInclude(WordAssign wordAssign) {
		sqlSession.insert("addWordCategoryInclude", wordAssign);
	}

	public List<Lexer> getWordCategoriesInclude(int wordId) {
		return sqlSession.selectList("getWordCategoriesInclude", wordId);
	}

	public void removeWordCategoryInclude(WordAssign wordAssign) {
		sqlSession.delete("removeWordCategoryInclude", wordAssign);
	}
	
	public void addSlotFixedWord(FixedWord fixedWord) {
		sqlSession.insert("addSlotFixedWord", fixedWord);
	}
	
	public void updateSlotFixedWord(FixedWord fixedWord) {
		sqlSession.update("updateSlotFixedWord", fixedWord);
	}
	
	public void removeFixedWords(List<Integer> ids) {
		sqlSession.delete("removeFixedWords", ids);
	}
	
	public List<FixedWord> getFixedWords(Integer templateId) {
		return sqlSession.selectList("getFixedWords", templateId);
	}
}
