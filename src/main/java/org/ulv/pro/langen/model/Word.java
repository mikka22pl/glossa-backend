package org.ulv.pro.langen.model;

import java.util.ArrayList;
import java.util.List;

public class Word extends NamedEntity {

	private static final long serialVersionUID = 4590277252470730078L;
	
	private Integer languageId;
	
	private List<WordGroup> groups;

	public Word() {
		this.groups = new ArrayList<WordGroup>();
	}
	
	public Word(int id, String name, int languageId) {
		super(id, name);
		this.groups = new ArrayList<WordGroup>();
		this.languageId = languageId;
	}
	
	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public List<WordGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<WordGroup> groups) {
		this.groups = groups;
	}
	
}
