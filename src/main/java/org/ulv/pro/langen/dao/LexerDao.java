package org.ulv.pro.langen.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ulv.pro.langen.model.Lexer;
import org.ulv.pro.langen.model.LexerItem;

@Component
public class LexerDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<LexerItem> getLexers(LexerItem lexer) {
		return sqlSession.selectList("org.ulv.pro.langen.dao.LexerDAO.getLexers", lexer);
	}
	
	public Integer addLexer(LexerItem lexer) {
		return sqlSession.insert("org.ulv.pro.langen.dao.LexerDAO.addLexer", lexer);
	}
	
	public int updateLexer(LexerItem lexer) {
		return sqlSession.insert("org.ulv.pro.langen.dao.LexerDAO.updateLexer", lexer);
	}
	
	public List<Lexer> getCategories(Lexer lexer) {
		return sqlSession.selectList("org.ulv.pro.langen.dao.LexerDAO.getCategories", lexer);
	}
	
	public Integer addLexerCategory(Lexer lexer) {
		return sqlSession.insert("org.ulv.pro.langen.dao.LexerDAO.addLexerCategory", lexer);
	}
	
	public int updateLexerCategory(Lexer lexer) {
		return sqlSession.update("org.ulv.pro.langen.dao.LexerDAO.updateLexerCategory", lexer);
	}
}
