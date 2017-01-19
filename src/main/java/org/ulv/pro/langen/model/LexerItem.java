package org.ulv.pro.langen.model;

import java.util.ArrayList;
import java.util.List;

public class LexerItem extends Lexer {

	private static final long serialVersionUID = 3284893014035019102L;
	
	private Lexer category;
	private Integer parentId;
	private List<LexerItem> children;
	
	public LexerItem() {
		this.category = new Lexer();
	}
	
	public LexerItem(Integer id, String name, String descr, Integer parentId) {
		super(id, name, descr);
		this.parentId = parentId;
	}

	public Lexer getCategory() {
		return category;
	}

	public void setCategory(Lexer category) {
		this.category = category;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public List<LexerItem> getChildren() {
		if (children == null) {
			this.children = new ArrayList<LexerItem>();
		}
		return children;
	}

	public void setChildren(List<LexerItem> children) {
		this.children = children;
	}
}
