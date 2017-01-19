package org.ulv.pro.langen.model.word;

import org.ulv.pro.langen.model.Word;

public class FixedWord extends Word {

	private static final long serialVersionUID = -2700602680364611216L;
	
	private Integer slotId;

	public FixedWord() {
		this(null, null);
	}
	
	public FixedWord(Integer wordId, Integer slotId) {
		super(wordId);
		this.slotId = slotId;
	}
	
	public Integer getSlotId() {
		return slotId;
	}

	public void setSlotId(Integer slotId) {
		this.slotId = slotId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FixedWord [id=");
		builder.append(super.getId());
		builder.append(", slotId=");
		builder.append(slotId);
		builder.append("]");
		return builder.toString();
	}
}
