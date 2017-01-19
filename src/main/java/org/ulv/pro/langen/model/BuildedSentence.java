package org.ulv.pro.langen.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

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
	
	public void addWord(SentenceWord word) {
		words.add(word);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BuildedSentence [words=");
		if (CollectionUtils.isNotEmpty(words)) {
			for (SentenceWord word : words) {
				builder.append(word.getOrdering());
				builder.append("-");
				builder.append(word.getWord().getName());
				builder.append("; ");
			}
		}
		builder.append("]");
		return builder.toString();
	}
	
	
}