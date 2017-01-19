package org.ulv.pro.langen.gui;

import java.util.ArrayList;
import java.util.List;

import org.ulv.pro.langen.model.NamedEntity;

public class WordGui extends NamedEntity {
	
	private static final long serialVersionUID = 103458675207039265L;

	private Integer languageId;
	private List<WordCategoryGui> categories;

	public WordGui() {
		this.categories = new ArrayList<>();
	}
	
	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public List<WordCategoryGui> getCategories() {
		return categories;
	}

	public void setCategories(List<WordCategoryGui> categories) {
		this.categories = categories;
	}
}