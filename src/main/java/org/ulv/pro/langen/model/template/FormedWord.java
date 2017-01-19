package org.ulv.pro.langen.model.template;

import org.ulv.pro.langen.model.LexerItem;
import org.ulv.pro.langen.model.NamedEntity;

public class FormedWord extends NamedEntity {

	private static final long serialVersionUID = -1517316820191212151L;

	private LexerItem verbForm;

	public FormedWord() {
		this.verbForm = new LexerItem();
	}

	public LexerItem getVerbForm() {
		return verbForm;
	}

	public void setVerbForm(LexerItem verbForm) {
		this.verbForm = verbForm;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("FormedWord [verbForm=");
		builder.append(verbForm);
		builder.append("]");
		return builder.toString();
	}

}
