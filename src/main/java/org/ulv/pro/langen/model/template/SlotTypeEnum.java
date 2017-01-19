package org.ulv.pro.langen.model.template;

public enum SlotTypeEnum {

	FIXED_WORD(19),
	RANDOM(20);
	
	private int code;
	
	private SlotTypeEnum(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
}
