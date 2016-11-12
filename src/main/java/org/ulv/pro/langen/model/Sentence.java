package org.ulv.pro.langen.model;

import java.util.List;

public class Sentence extends BaseEntity {

	private static final long serialVersionUID = 8971532317637250724L;

	private Integer languageId;
	private Integer lessonId;
	private List<WordInSentence> sentence;

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
	}

}
