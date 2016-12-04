package org.ulv.pro.langen.model;

import java.util.ArrayList;
import java.util.List;

public class Translation extends BaseEntity {

	private static final long serialVersionUID = -1027174256147907105L;
	
	private Word word;
	private List<DictionaryEntry> entries;

	public Translation() {
		this.word = new Word();
		this.entries = new ArrayList<DictionaryEntry>();
	}

	public Word getWord() {
		return word;
	}

	public void setWord(Word word) {
		this.word = word;
	}

	public List<DictionaryEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<DictionaryEntry> entries) {
		this.entries = entries;
	}
}
