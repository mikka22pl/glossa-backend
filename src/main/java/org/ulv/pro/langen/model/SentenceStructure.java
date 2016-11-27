package org.ulv.pro.langen.model;

public class SentenceStructure extends BaseEntity {

	private static final long serialVersionUID = 3302033152422268722L;
	
	private Integer languageId;
	private Integer lessonId;
	private Integer ordering;
	private LexerLang func;
	private Integer type;

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

	public Integer getOrdering() {
		return ordering;
	}

	public void setOrdering(Integer ordering) {
		this.ordering = ordering;
	}

	public LexerLang getFunc() {
		return func;
	}

	public void setFunc(LexerLang func) {
		this.func = func;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
