package org.ulv.pro.langen.model.template;

import java.util.List;

import org.ulv.pro.langen.model.NamedEntity;

public class TemplateSentence extends NamedEntity {

	private static final long serialVersionUID = 310881585304197037L;

	private Integer languageId;
	private List<TemplateSlot> items;

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public List<TemplateSlot> getItems() {
		return items;
	}

	public void setItems(List<TemplateSlot> items) {
		this.items = items;
	}
	
}
