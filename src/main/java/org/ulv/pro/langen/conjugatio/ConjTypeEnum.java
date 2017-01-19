package org.ulv.pro.langen.conjugatio;

public enum ConjTypeEnum {

	TEMPLATE(31),
	SINGULARIS_1(22),
	SINGULARIS_2(23),
	SINGULARIS_3(24),
	DUALIS(25),
	PLURALIS_1(26),
	PLURALIS_2(27),
	PLURALIS_3(28),
	REDUPLICATION(37);
	
	private Integer code;
	
	private ConjTypeEnum(int code) {
		this.code = new Integer(code);
	}
	
	public Integer getCode() {
		return code;
	}
}
