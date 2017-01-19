package org.ulv.pro.langen.model.word;

import org.ulv.pro.langen.conjugatio.ConjTypeEnum;
import org.ulv.pro.langen.model.BaseEntity;

public class WordSet extends BaseEntity {

	private static final long serialVersionUID = 6970328281911880360L;
	
	private ConjTypeEnum type;
	private String word;

	public WordSet() {
		this(null, null);
	}
	
	public WordSet(ConjTypeEnum type, String word) {
		this.type = type;
		this.word = word;
	}

	public ConjTypeEnum getType() {
		return type;
	}

	public void setType(ConjTypeEnum type) {
		this.type = type;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WordSet [type=");
		builder.append(type);
		builder.append(", word=");
		builder.append(word);
		builder.append("]");
		return builder.toString();
	}

}
