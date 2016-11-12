package org.ulv.pro.langen.model;

public class WordInSentence extends BaseEntity {

	private static final long serialVersionUID = 2655126490490197598L;
	
	private Word word;
	private WordGroup group;
	private Integer ordering;

	public Word getWord() {
		return word;
	}

	public void setWord(Word word) {
		this.word = word;
	}

	public WordGroup getGroup() {
		return group;
	}

	public void setGroup(WordGroup group) {
		this.group = group;
	}

	public Integer getOrdering() {
		return ordering;
	}

	public void setOrdering(Integer ordering) {
		this.ordering = ordering;
	}

}
