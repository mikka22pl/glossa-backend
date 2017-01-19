package org.ulv.pro.langen.model;

import java.util.ArrayList;
import java.util.List;

public class Sentence extends BaseEntity {

	private static final long serialVersionUID = 8971532317637250724L;

	private Integer languageId;
	private Integer lessonId;
	private List<WordInSentence> sentence;
	private int sentenceSize;

	public Sentence() {
		this.sentence = new ArrayList<WordInSentence>();
	}
	
	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public Integer getLessonId() {
		return lessonId;
	}

	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}

	public List<WordInSentence> getSentence() {
		return sentence;
	}

	public void setSentence(List<WordInSentence> sentence) {
		this.sentence = sentence;
		this.sentenceSize = sentence.size();
	}

	public int getSentenceSize() {
		return sentenceSize;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("Sentence [languageId=");
		builder.append(languageId);
		builder.append(", lessonId=");
		builder.append(lessonId);
		builder.append(", sentence=");
		builder.append(sentence);
		builder.append("]");
		return builder.toString();
	}

}
