package org.ulv.pro.langen.model;

import java.util.ArrayList;
import java.util.List;

public class BuildedSentence {

	private List<SentenceWord> words;

	public BuildedSentence() {
		this.words = new ArrayList<SentenceWord>();
	}
	
	public List<SentenceWord> getWords() {
		return words;
	}

	public void setWords(List<SentenceWord> words) {
		this.words = words;
	}
}