package org.ulv.pro.langen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ulv.pro.langen.dao.WordDao;
import org.ulv.pro.langen.model.Word;
import org.ulv.pro.langen.model.WordGroup;

@Service(value = "wordService")
public class WordServiceImpl implements WordService {

	@Autowired
	private WordDao wordDao;
	
	@Override
	public List<Word> getWordsByGroup(int languageId, int groupId) {
		WordGroup group = new WordGroup();
		group.setId(groupId);
		group.setLanguageId(languageId);
		
		return wordDao.getWordsByGroup(group);
	}

}
