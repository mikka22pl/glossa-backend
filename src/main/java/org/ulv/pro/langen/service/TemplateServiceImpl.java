package org.ulv.pro.langen.service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ulv.pro.langen.dao.SentenceDao;
import org.ulv.pro.langen.exceptions.GlossaException;
import org.ulv.pro.langen.exceptions.TooManyObjectsReturnedException;
import org.ulv.pro.langen.model.template.TemplateSentence;

@Service("templateService")
public class TemplateServiceImpl implements TemplateService {

	private static final Logger log = LoggerFactory.getLogger(TemplateServiceImpl.class);
	
	@Autowired
	private SentenceDao sentenceDao;
	
	@Override
	public TemplateSentence getTemplateByLessonId(int lessonId) throws GlossaException {
		log.info("--> getTemplateByLessonId({})", lessonId);
		List<TemplateSentence> templates = sentenceDao.getTemplatesByLessonId(lessonId);
		
		if (CollectionUtils.isEmpty(templates)) {
			return null;
		}
		if (templates.size() == 1) {
			return templates.get(0);
		}
		throw new TooManyObjectsReturnedException("too many templates in lesson #" + lessonId);
	}

	@Override
	public TemplateSentence getTemplateAndSlotsByLessonId(int lessonId)
			throws GlossaException {
		log.info("--> getTemplateAndSlotsByLessonId({})", lessonId);

		List<TemplateSentence> templates = sentenceDao.getTemplateAndSlots(lessonId);
		
		if (CollectionUtils.isEmpty(templates)) {
			return null;
		}
		if (templates.size() == 1) {
			return templates.get(0);
		}
		throw new TooManyObjectsReturnedException("too many templates in lesson #" + lessonId);
	}

}
