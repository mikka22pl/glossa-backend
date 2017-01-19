package org.ulv.pro.langen.exceptions;

public class GlossaException extends Exception {

	private static final long serialVersionUID = -5778312552578276043L;

	public GlossaException(String msg) {
		super(msg);
	}
	
	public GlossaException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
