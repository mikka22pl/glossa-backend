package org.ulv.pro.langen.model;

public class SentenceStructure extends BaseEntity {

	private static final long serialVersionUID = 3302033152422268722L;

	private Integer structureId;
	private Integer ordering;
	private LexerLang functionWord;
	private Integer type;

	public Integer getStructureId() {
		return structureId;
	}

	public void setStructureId(Integer structureId) {
		this.structureId = structureId;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
