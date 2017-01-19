package org.ulv.pro.langen.model;

public class WordInSentence extends BaseEntity {

	private static final long serialVersionUID = 2655126490490197598L;
	
	private Word word;
	private WordGroup group;
	private Integer ordering;
	private Integer translationId;

	public WordInSentence() {
		this.word = new Word();
		this.group = new WordGroup();
	}
	
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

	public Integer getTranslationId() {
		return translationId;
	}

	public void setTranslationId(Integer translationId) {
		this.translationId = translationId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WordInSentence [word=");
		builder.append(word);
		builder.append(", group=");
		builder.append(group);
		builder.append(", ordering=");
		builder.append(ordering);
		builder.append(", translationId=");
		builder.append(translationId);
		builder.append("]");
		return builder.toString();
	}

}
