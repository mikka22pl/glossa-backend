package org.ulv.pro.langen.model;

import java.util.ArrayList;
import java.util.List;

public class Word extends NamedEntity {

	private static final long serialVersionUID = 4590277252470730078L;
	
	private Integer languageId;
	// klasa konjugacji
	private LexerItem conjugatioType;
	
	private List<WordCategory> categories;
	
	private List<DictionaryEntry> translations;
	
	private List<Lexer> categoriesInclude;

	public Word() {
		this(null, null);
	}
	
	public Word(Integer id) {
		this(id, null);
	}
	
	public Word(Integer id, String name) {
		this(id, name, null);
	}
	
	public Word(Integer id, String name, Integer languageId) {
		super(id, name);
		this.categories = new ArrayList<WordCategory>();
		this.languageId = languageId;
		this.translations = new ArrayList<DictionaryEntry>();
		this.categoriesInclude = new ArrayList<Lexer>();
		this.conjugatioType = new LexerItem();
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

	public List<DictionaryEntry> getTranslations() {
		return translations;
	}

	public void setTranslations(List<DictionaryEntry> translations) {
		this.translations = translations;
	}

	public List<Lexer> getCategoriesInclude() {
		return categoriesInclude;
	}

	public void setCategoriesInclude(List<Lexer> categoriesInclude) {
		this.categoriesInclude = categoriesInclude;
	}

	

	public LexerItem getConjugatioType() {
		return conjugatioType;
	}

	public void setConjugatioType(LexerItem conjugatioType) {
		this.conjugatioType = conjugatioType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("Word [languageId=");
		builder.append(languageId);
		builder.append("]");
		return builder.toString();
	}
}
