package org.ulv.pro.langen.ctrl;

import org.springframework.http.HttpHeaders;

public class HeadersUtil {
	static final HttpHeaders HEADERS = new HttpHeaders();
	static {
		HEADERS.add("Content-Type", "application/json; charset=utf-8");
	}
}
