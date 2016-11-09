package org.ulv.pro.langen.model;

public class Course extends NamedEntity {

	private static final long serialVersionUID = 4557561178446829460L;
	
	private Integer languageId;

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("Course []");
		return builder.toString();
	}
}
