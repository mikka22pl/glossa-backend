package org.ulv.pro.langen.model;

public class SentenceTranslation extends Sentence {

	private static final long serialVersionUID = -773937742189716818L;

	private String translation;
	private Integer translationId;

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
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
		builder.append(super.toString());
		builder.append("SentenceTranslation [translation=");
		builder.append(translation);
		builder.append("]");
		return builder.toString();
	}
}
