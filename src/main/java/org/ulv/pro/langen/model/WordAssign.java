package org.ulv.pro.langen.model;

import java.io.Serializable;

public class WordAssign implements Serializable {

	private static final long serialVersionUID = 880402502034433298L;
	
	private Integer wordId;
	private Integer lexerId;

	public WordAssign() {
		
	}
	
	public WordAssign(Integer wordId) {
		this.wordId = wordId;
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
}