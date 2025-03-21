package com.springStudy1.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.springStudy1.DTO.User;

@Repository
public class UserDAO {
	private final JdbcTemplate Jdbc;
	
	@Autowired
	public UserDAO(JdbcTemplate Jdbc) {
		this.Jdbc = Jdbc;
	}
	
	public void saveDB(User user) {
		String query = "insert into user "
				+ "(user_id, user_pw, user_email, user_job, user_addr, user_like) "
				+ "values(?,?,?,?,?,?)";

		Jdbc.update(query,
				new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps) throws SQLException{
						ps.setString(1, user.getUserId());
						ps.setString(2, user.getUserPw());
						ps.setString(3, user.getUserEmail());
						ps.setString(4, user.getUserJob());
						ps.setString(5, user.getUserAddr());
						ps.setString(6, user.getUserLike());
					}
				});
	}

	public boolean findByUserId(String userId) {
		String query = "select user_id from user where user_id=?";
		try {
			String u  = Jdbc.queryForObject(query, String.class, userId);
			System.out.println(u);
		} catch(EmptyResultDataAccessException e) {
			//catch 부분 실행 시 조회 결과가 없다는 뜻
			return false;
		}
		return true;
//		List<User> list = Jdbc.query(query, new UserRowMapper(), userId);
//		if(list.size() != 0) return true;
//		else return false;
	}

	public boolean findByUserIdPw(String id, String pw) {
		String query = "select user_id from user where user_id=? and user_pw=?";
		try {
			String u = Jdbc.queryForObject(query, String.class, id, pw);
		} catch(EmptyResultDataAccessException e) {
			return false;
		}
 		return true;
	}
	
//	public class UserRowMapper implements RowMapper<User> {
//		@Override
//		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//			User u = new User();
//			u.setUserId(rs.getString("user_id"));
//			u.setUserPw(rs.getString("user_pw"));
//			u.setUserAddr(rs.getString("user_addr"));
//			u.setUserJob(rs.getString("user_job"));
//			u.setUserEmail(rs.getString("user_email"));
//			u.setUserLike(rs.getString("user_like"));
//			
//			return u;
//		}
//	}
}
