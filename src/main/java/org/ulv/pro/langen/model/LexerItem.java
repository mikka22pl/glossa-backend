package org.ulv.pro.langen.model;

public class LexerItem extends Lexer {

	private static final long serialVersionUID = 3284893014035019102L;
	
	private Lexer category;
	
	public LexerItem() {
		this.category = new Lexer();
	}

	public Lexer getCategory() {
		return category;
	}

	public void setCategory(Lexer category) {
		this.category = category;
	}
}
