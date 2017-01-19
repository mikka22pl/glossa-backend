package org.ulv.pro.langen.service;

import org.ulv.pro.langen.model.LexerItem;

public class LexerItemBuilder {

	private LexerItem instance;
	
	public LexerItemBuilder(int id, String name, String descr, Integer parentId) {
		instance = new LexerItem(id, name, descr, parentId);
	}
	
	public LexerItemBuilder withChild(LexerItem item) {
		instance.getChildren().add(item);
		return this;
	}
	
	public LexerItem build() {
		return instance;
	}
}
