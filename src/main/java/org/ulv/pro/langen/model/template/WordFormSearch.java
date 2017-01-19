package org.ulv.pro.langen.model.template;

import java.util.HashSet;
import java.util.Set;

import org.ulv.pro.langen.model.NamedEntity;

public class WordFormSearch extends NamedEntity {

	private static final long serialVersionUID = -6331890519986145904L;

	private Integer templateId;
	private Integer ordering;
	private Set<Integer> formTypes;

	public WordFormSearch() {
		this.formTypes = new HashSet<Integer>();
	}

	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public Integer getOrdering() {
		return ordering;
	}

	public void setOrdering(Integer ordering) {
		this.ordering = ordering;
	}

	public Set<Integer> getFormTypes() {
		return formTypes;
	}

	public void setFormTypes(Set<Integer> formTypes) {
		this.formTypes = formTypes;
	}
}