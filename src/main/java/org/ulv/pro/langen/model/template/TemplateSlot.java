package org.ulv.pro.langen.model.template;

import java.util.ArrayList;
import java.util.List;

import org.ulv.pro.langen.model.BaseEntity;
import org.ulv.pro.langen.model.LexerItem;
import org.ulv.pro.langen.model.LexerLang;
import org.ulv.pro.langen.model.word.FixedWord;

public class TemplateSlot extends BaseEntity implements Comparable<TemplateSlot> {

	private static final long serialVersionUID = -5052106540971104908L;

	private Integer templateId;
	private Integer ordering;
	private LexerLang functionWord;
	private LexerItem type;
	private Integer connected;
	private List<FixedWord> fixedWords;

	public TemplateSlot() {
		this(null, null);
	}
	
	public TemplateSlot(Integer templateId, Integer ordering) {
		this.templateId = templateId;
		this.ordering = ordering;
		this.fixedWords = new ArrayList<>();
	}
	
	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public Integer getOrdering() {
		return ordering;
	}

	public void setOrdering(Integer ordering) {
		this.ordering = ordering;
	}

	public LexerLang getFunctionWord() {
		return functionWord;
	}

	public void setFunctionWord(LexerLang functionWord) {
		this.functionWord = functionWord;
	}

	public LexerItem getType() {
		return type;
	}

	public void setType(LexerItem type) {
		this.type = type;
	}

	public Integer getConnected() {
		return connected;
	}

	public void setConnected(Integer connected) {
		this.connected = connected;
	}

	public List<FixedWord> getFixedWords() {
		return fixedWords;
	}

	public void setFixedWords(List<FixedWord> fixedWords) {
		this.fixedWords = fixedWords;
	}

	@Override
	public int compareTo(TemplateSlot o) {
		return this.ordering == o.getOrdering() ? 0 : this.ordering < o.getOrdering() ? -1 : 1;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TemplateSlot [templateId=");
		builder.append(templateId);
		builder.append(", ordering=");
		builder.append(ordering);
		builder.append(", functionWord=");
		builder.append(functionWord);
		builder.append(", type=");
		builder.append(type);
		builder.append(", connected=");
		builder.append(connected);
		builder.append("]");
		return builder.toString();
	}
}