package org.ulv.pro.langen.model;

import java.util.ArrayList;
import java.util.List;

public class Word extends NamedEntity {


	private static final long serialVersionUID = 4590277252470730078L;
	
	private Integer languageId;
	
	private List<WordCategory> categories;

	public Word() {
		this(null, null, null);
	}
	
	public Word(Integer id, String name, Integer languageId) {
		super(id, name);
		this.categories = new ArrayList<WordCategory>();
		this.languageId = languageId;
	}
	
	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public List<WordCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<WordCategory> categories) {
		this.categories = categories;
	}
}
