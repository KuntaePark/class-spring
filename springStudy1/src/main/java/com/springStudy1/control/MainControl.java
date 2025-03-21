package com.springStudy1.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springStudy1.DTO.School;
import com.springStudy1.DTO.User;
import com.springStudy1.service.SchoolService;
import com.springStudy1.service.UserService;

import jakarta.servlet.http.HttpSession;

// 컨트롤러 지정
@Controller
public class MainControl {
	@Autowired //생성자 권장
	private SchoolService schoolService;
	@Autowired
	private UserService userService;
	
	//@GetMapping
	//@PostMapping
	@GetMapping("/signIn")
	public String login() {
		return "signIn";
	}
	@PostMapping("/signIn")
	public String login(
			@RequestParam("id") String id, 
			@RequestParam("pw") String pw,
			HttpSession session) {
		boolean isSuccess = userService.loginCheck(id, pw);
		if(isSuccess) {
			session.setAttribute("user",id);
		}
		return "index";
	}
	
	
	@GetMapping("/signUp")
	public String join() {
		return "signUp";
	}
	@PostMapping("signUp")
	public String joinSave(@ModelAttribute User user) {
		System.out.println(user);
		this.userService.save(user);
		return "index";
	}
	
	@GetMapping("/userUpdate")
	public String memberUpdate() {
		return "memberModify";
	}
	@PostMapping("/memberModify")
	public String memberModify() {
		return "";
	}
	
	@GetMapping("/")
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/list")
	public ModelAndView listPage(@RequestParam String type) {
		List<School> list = this.schoolService.find(type);
		ModelAndView mav = new ModelAndView("list"); //페이지 제공/ 데이터 제공
		mav.addObject("list",list);
		return mav;
	}
	
}
