package org.ulv.pro.langen.model;

import java.util.List;

public class WordSearch {

	private LexerLang functionWord;
	private List<Lexer> categoriesInclude;

	public LexerLang getFunctionWord() {
		return functionWord;
	}

	public void setFunctionWord(LexerLang functionWord) {
		this.functionWord = functionWord;
	}

	public List<Lexer> getCategoriesInclude() {
		return categoriesInclude;
	}

	public void setCategoriesInclude(List<Lexer> categoriesInclude) {
		this.categoriesInclude = categoriesInclude;
	}
}