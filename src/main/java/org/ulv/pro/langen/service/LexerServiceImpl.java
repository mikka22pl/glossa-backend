package org.ulv.pro.langen.service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ulv.pro.langen.dao.LexerDao;
import org.ulv.pro.langen.model.Lexer;
import org.ulv.pro.langen.model.LexerItem;

@Service(value = "lexerService")
public class LexerServiceImpl implements LexerService {

	@Autowired
	private LexerDao lexerDao;
	
	@Override
	public List<LexerItem> getLexers(String name, String categoryName) {
		LexerItem lexer = new LexerItem();
		lexer.setName(name);
		lexer.getCategory().setName(categoryName);
		return lexerDao.getLexers(lexer);
	}

	@Override
	public List<LexerItem> getLexersByCategory(int categoryId) {
		LexerItem lexer = new LexerItem();
		lexer.getCategory().setId(categoryId);
		return lexerDao.getLexers(lexer);
	}

	@Override
	public LexerItem getLexerById(int id) {
		LexerItem lexer = new LexerItem();
		lexer.setId(id);
		
		List<LexerItem> list = lexerDao.getLexers(lexer);
		
		return CollectionUtils.isNotEmpty(list) ? list.get(0) : null;
	}

	@Override
	public Integer saveLexer(LexerItem lexer) {
		if (lexer.isNew()) {
			return lexerDao.addLexer(lexer);
		} else {
			return lexerDao.updateLexer(lexer);
		}
	}

	@Override
	public List<Lexer> getCategories() {
		return lexerDao.getCategories(null);
	}

	@Override
	public List<Lexer> getCategories(Integer id, String name) {
		Lexer lexer = new Lexer();
		lexer.setId(id);
		lexer.setName(name);
		
		return lexerDao.getCategories(lexer);
	}

	@Override
	public Lexer getCategoryById(int id) {
		Lexer lexer = new Lexer();
		lexer.setId(id);
		List<Lexer> list = lexerDao.getCategories(lexer);
		
		return CollectionUtils.isNotEmpty(list) ? list.get(0) : null;
	}

	@Override
	public Integer saveCategory(Lexer lexer) {
		if (lexer.isNew()) {
			return lexerDao.addLexerCategory(lexer);
		} else {
			return lexerDao.updateLexerCategory(lexer);
		}
	}
}
