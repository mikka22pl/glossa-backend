package org.ulv.pro.langen.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ulv.pro.langen.model.SentenceStructure;

@Component
public class SentenceDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<SentenceStructure> getSentenceStructures(SentenceStructure struct) {
		
		return this.sqlSession.selectList("getSentenceStrucutres", struct);
	}
	
}
