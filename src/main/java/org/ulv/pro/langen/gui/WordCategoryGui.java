package org.ulv.pro.langen.gui;

import org.ulv.pro.langen.model.Lexer;

public class WordCategoryGui extends Lexer {

	private static final long serialVersionUID = -7341493702510239363L;
	
	private String categoryType;

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
}
