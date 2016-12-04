package org.ulv.pro.langen.model;

public class WordCategory extends Lexer {

	private static final long serialVersionUID = 1192131494691297060L;
	
	private WordCategoryType categoryType;
	
	public WordCategory() {
		
	}

	public WordCategoryType getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(WordCategoryType categoryType) {
		this.categoryType = categoryType;
	}
	
	
}
