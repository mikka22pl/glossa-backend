package org.ulv.pro.langen.model;

import java.io.Serializable;

public class WordAssign implements Serializable {

	private static final long serialVersionUID = 880402502034433298L;
	
	private Integer wordId;
	private Integer lexerId;
	private WordCategoryType categoryType;

	public WordAssign() {
		this(null);
	}
	
	public WordAssign(Integer wordId) {
		this.wordId = wordId;
		this.categoryType = WordCategoryType.SPEECH_PART;
	}
	
	public Integer getWordId() {
		return wordId;
	}

	public void setWordId(Integer wordId) {
		this.wordId = wordId;
	}

	public Integer getLexerId() {
		return lexerId;
	}

	public void setLexerId(Integer lexerId) {
		this.lexerId = lexerId;
	}

	public WordCategoryType getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(WordCategoryType categoryType) {
		this.categoryType = categoryType;
	}
}