package org.ulv.pro.langen.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ulv.pro.langen.model.Lexer;
import org.ulv.pro.langen.model.Word;
import org.ulv.pro.langen.model.template.FormedWord;
import org.ulv.pro.langen.model.template.TemplateSentence;
import org.ulv.pro.langen.model.template.TemplateSlot;
import org.ulv.pro.langen.model.template.WordFormSearch;

@Component
public class SentenceDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<TemplateSlot> getTemplateSlots(int templateId) {
		
		return this.sqlSession.selectList("getTemplateSlots", templateId);
	}
	
	public List<TemplateSentence> getTemplatesByLessonId(int lessonId) {
		return sqlSession.selectList("getTemplatesByLessonId", lessonId);
	}
	
	public List<TemplateSentence> getTemplateAndSlots(int lessonId) {
		return sqlSession.selectList("getTemplateAndSlots",	lessonId);
	}
	
	public List<Word> getVerbForms(WordFormSearch wordForm) {
		return sqlSession.selectList("getVerbForms", wordForm);
	}
	
	public List<Lexer> getSlotSpecified(TemplateSlot slot) {
		return sqlSession.selectList("getSlotSpecified", slot);
	}
	public List<FormedWord> getFormedWords(WordFormSearch wordFormSearch) {
		return sqlSession.selectList("getFormedWord", wordFormSearch);
	}
	
	public void addTemplateSlot(TemplateSlot templateSlot) {
		sqlSession.insert("addTemplateSlot", templateSlot);
	}
	
	public void updateTemplateSlot(TemplateSlot templateSlot) {
		sqlSession.update("updateTemplateSlot", templateSlot);
	}
	
	public Integer addTemplate(TemplateSentence templateSentence) {
		return sqlSession.insert("addTemplate", templateSentence);
	}
	
	public void updateTemplate(TemplateSentence templateSentence) {
		sqlSession.update("updateTemplate", templateSentence);
	}
}
