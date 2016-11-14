package org.ulv.pro.langen.service;

import java.util.List;

import org.ulv.pro.langen.model.Lexer;
import org.ulv.pro.langen.model.LexerItem;

public interface LexerService {
	
	List<LexerItem> getLexers(String name, String categoryName);
	
	LexerItem getLexerById(int id);
	
	Integer saveLexer(LexerItem lexer);
	
	List<Lexer> getCategories();

	List<Lexer> getCategories(Integer id, String name);
	
	Lexer getCategoryById(int id);
	
	Integer saveCategory(Lexer lexer);
}
