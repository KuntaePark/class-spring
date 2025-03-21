package com.springStudy1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springStudy1.DTO.School;

@Repository
public class SchoolDAO {
	private final JdbcTemplate Jdbc;
	
	@Autowired
	public SchoolDAO(JdbcTemplate Jdbc) {
		this.Jdbc = Jdbc;
	}

	//정보 가져오기
	public List<School> findAllByType(String type) {
		String query = "select id,school_name,address,tel,homepage from"
				+ " school where diff=?";
		List<School> list = Jdbc.query(
				query, new PreparedStatementSetter() {
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setString(1, type);
					}
				}, new SchoolRowMapper());
//		List<School> list = Jdbc.query(query, new SchoolRowMapper(), type);
		return list;
	}
	
	/*
	 * JdbcTemplate
	 * methods: query, queryObject(단일 레코드), update : del, ins, upd
	 */
	
	public class SchoolRowMapper implements RowMapper<School> {
		@Override
		public School mapRow(ResultSet rs, int rowNum) throws SQLException {
			School s = new School();
			s.setId(rs.getInt("id"));
			s.setSchoolName(rs.getString("school_name"));
			s.setAddress(rs.getString("address"));
			s.setTel(rs.getString("tel"));
			s.setHomePage(rs.getString("homepage"));
			return s;
		}
	}
}
