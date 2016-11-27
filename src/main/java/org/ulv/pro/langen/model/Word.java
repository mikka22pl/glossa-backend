package org.ulv.pro.langen.model;

import java.util.ArrayList;
import java.util.List;

public class Word extends NamedEntity {

	private static final long serialVersionUID = 4590277252470730078L;
	
	private Integer languageId;
	
	private List<Lexer> functions;
	private List<Lexer> categories;

	public Word() {
		this(null, null, null);
	}
	
	public Word(Integer id, String name, Integer languageId) {
		super(id, name);
		this.functions = new ArrayList<Lexer>();
		this.categories = new ArrayList<Lexer>();
		this.languageId = languageId;
	}
	
	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public List<Lexer> getFunctions() {
		return functions;
	}

	public void setFunctions(List<Lexer> functions) {
		this.functions = functions;
	}

	public List<Lexer> getCategories() {
		return categories;
	}

	public void setCategories(List<Lexer> categories) {
		this.categories = categories;
	}
}
