package org.ulv.pro.langen.service;

import org.ulv.pro.langen.exceptions.GlossaException;
import org.ulv.pro.langen.model.template.TemplateSentence;

public interface TemplateService {

	TemplateSentence getTemplateByLessonId(int lessonId) throws GlossaException;
	
	TemplateSentence getTemplateAndSlotsByLessonId(int lessonId) throws GlossaException;
}
