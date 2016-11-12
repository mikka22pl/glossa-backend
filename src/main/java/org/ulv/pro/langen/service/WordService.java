package org.ulv.pro.langen.service;

import java.util.List;

import org.ulv.pro.langen.model.Word;

public interface WordService {

	List<Word> getWordsByGroup(int languageId, int groupId);
}
