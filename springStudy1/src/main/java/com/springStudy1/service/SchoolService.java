package com.springStudy1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springStudy1.DAO.SchoolDAO;
import com.springStudy1.DTO.School;

@Service
public class SchoolService {
	private final SchoolDAO schoolDAO;
	
	@Autowired //생성자의 경우 자동 인식: 굳이 autowired tag 안해줘도 됨
	public SchoolService(SchoolDAO schoolDAO) {
		this.schoolDAO = schoolDAO;
	}
	
	public List<School> find(String type) {
		return this.schoolDAO.findAllByType(type);
	}
}

