package org.ulv.pro.langen.model.template;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ConnectedTypeEnum {

	MAIN(1),
	DESCRIBER(2);
	
	private static final Map<Integer, ConnectedTypeEnum> byCode = new HashMap<Integer, ConnectedTypeEnum>();
	static {
		for (ConnectedTypeEnum type : ConnectedTypeEnum.values()) {
			byCode.put(type.getCode(), type);
		}
	}
	
	private int code;
	
	private ConnectedTypeEnum(int code) {
		this.code = code;
	}
	
	@JsonValue
	public int getCode() {
		return this.code;
	}
	
	@JsonCreator
	public static ConnectedTypeEnum forCode(int code) {
		return byCode.get(code);
	}
}
