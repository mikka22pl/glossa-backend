package org.ulv.pro.langen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.EnumTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.ulv.pro.langen.model.WordCategoryType;

public class WordCategoryTypeHandler extends EnumTypeHandler<WordCategoryType>{

	
	public WordCategoryTypeHandler(Class<WordCategoryType> type) {
		super(type);
	}

	@Override
	public WordCategoryType getNullableResult(CallableStatement cs, int col)
			throws SQLException {
		return WordCategoryType.byCode(cs.getString(col));
	}

	@Override
	public WordCategoryType getNullableResult(ResultSet rs, int col)
			throws SQLException {
		return WordCategoryType.byCode(rs.getString(col));
	}

	@Override
	public WordCategoryType getNullableResult(ResultSet rs, String col)
			throws SQLException {
		return WordCategoryType.byCode(rs.getString(col));
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			WordCategoryType genderEnum, JdbcType jdbcType) throws SQLException {

		ps.setString(i, genderEnum.getCode());
	}
}