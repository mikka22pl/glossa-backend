package org.ulv.pro.langen.gui.converters;

import java.util.List;

import org.ulv.pro.langen.gui.WordCategoryGui;
import org.ulv.pro.langen.gui.WordGui;
import org.ulv.pro.langen.model.Word;
import org.ulv.pro.langen.model.WordCategory;
import org.ulv.pro.langen.model.WordCategoryType;

public class WordConverter implements Convertable<WordGui, Word>{

	@Override
	public Word fromGui(WordGui guiObj, Word obj) {
		Word word = new Word();
		word.setId(guiObj.getId());
		word.setName(guiObj.getName());
		word.setDescr(guiObj.getDescr());
		word.setCreatedDate(guiObj.getCreatedDate());
		word.setModifiedDate(guiObj.getModifiedDate());
		word.setLanguageId(guiObj.getLanguageId());
		convertCategories(word, guiObj.getCategories());
		return word;
	}

	@Override
	public WordGui fromDomain(Word obj, WordGui guiObj) {
		// TODO Auto-generated method stub
		return null;
	}

	private void convertCategories(Word word, List<WordCategoryGui> categories) {
		
		for (WordCategoryGui cat : categories) {
			WordCategory category = new WordCategory();
			category.setId(cat.getId());
			category.setName(cat.getName());
			category.setDescr(cat.getDescr());
			category.setCategoryType(WordCategoryType.byCode(cat.getCategoryType()));
			// ...
			word.getCategories().add(category);
		}
	}
}
