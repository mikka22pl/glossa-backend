package org.ulv.pro.langen.service;

import java.util.List;

import org.ulv.pro.langen.model.BuildedSentence;
import org.ulv.pro.langen.model.SentenceStructure;

public interface SentenceService {

	List<SentenceStructure> getSentenceStructures(SentenceStructure struct);
	
	BuildedSentence getSentence(int structureId);
}
