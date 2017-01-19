package org.ulv.pro.langen.exceptions;

public class TooManyObjectsReturnedException extends GlossaException {

	private static final long serialVersionUID = 6323555856249388946L;

	public TooManyObjectsReturnedException(String msg) {
		super(msg);
	}
	
	public TooManyObjectsReturnedException(String msg, Throwable cause) {
		super(msg, cause);
	}
}