package org.ulv.pro.langen.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum WordCategoryType {

	CATEGORY("C"),
	SPEECH_PART("F");
	
	private static final Map<String, WordCategoryType> INSTANCE_BY_CODE = new HashMap<>();
	static {
		for (WordCategoryType item : WordCategoryType.values()) {
			INSTANCE_BY_CODE.put(item.getCode(), item);
		}
	}
	
	private String code;
	
	WordCategoryType(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}

	@JsonCreator
	public static WordCategoryType byCode(String code) {
		return INSTANCE_BY_CODE.get(code);
	}
}
