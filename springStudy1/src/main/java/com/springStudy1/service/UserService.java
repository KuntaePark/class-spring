package com.springStudy1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springStudy1.DAO.UserDAO;
import com.springStudy1.DTO.User;

@Service
public class UserService {
	private final UserDAO userDAO;
	
	@Autowired
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public void save(User user) {
		if(!this.userDAO.findByUserId(user.getUserId())) {
			this.userDAO.saveDB(user);
		}
	}

	public boolean loginCheck(String id, String pw) {
		return this.userDAO.findByUserIdPw(id,pw);
	}
}
