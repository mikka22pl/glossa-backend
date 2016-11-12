package org.ulv.pro.langen.model;

public class Word extends NamedEntity {

	private static final long serialVersionUID = 4590277252470730078L;
	
	private Integer languageId;

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}
	
}
