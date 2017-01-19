package org.ulv.pro.langen.model;

public class Lexer extends NamedEntity {

	private static final long serialVersionUID = 4079006837313519606L;

	private boolean active;

	public Lexer() {
		this(null, null, null);
	}
	
	public Lexer(Integer id) {
		this(id, null, null);
	}
	
	public Lexer(Integer id, String name, String descr) {
		super(id, name, descr);
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}