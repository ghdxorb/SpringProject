package com.mnu.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mnu.sample.dto.UserRequestDTO;
import com.mnu.sample.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequiredArgsConstructor
@RequestMapping("User")
public class UserController {
	//로그 출력용
	private static final Logger log =
			LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private final UserService userService;
	
	//회원가입 폼
	@GetMapping("user_insert")
	public String userInsert() {
		log.info("User Call : user_insert");
		
		return "User/user_insert";
	}
	
/*
	//회원가입 폼
	@GetMapping("user_insert_valid")
	public String userInsert(Model model) {
		log.info("User Call : user_insert_valid");
		
		model.addAttribute("userRequestDTO", new UserRequestDTO());
		return "User/user_insert";
	}
*/
	//ID 중복검사
	@ResponseBody
	@PostMapping("user_idCheck")
	public String userIdCheck(@RequestParam("userid") String userid) {
		log.info("User Call : user_idCheck");
		boolean bool = userService.userIdCheck2(userid);
		return String.valueOf(bool);
	}
	//보인인증(핸드폰)
	
	//보인인증(이메일)
	
	//회원가입처리
	@PostMapping("user_insert")
	public String userInsertPro(UserRequestDTO userRequestDTO, Model model) {
		log.info("User Call : user_insert_pro");
		
		
		return "/";
	}

	/*	
	//회원가입처리
	@PostMapping("user_insert_valid")
	public String userInsertValidPro(@Valid UserRequestDTO userRequestDTO, 
						BindingResult result, Model model) {
		log.info("User Call : user_insert_valid_pro");
		
		if(result.hasErrors()) {
			return "User/user_insert_valid";
		}
		
		return "/";
	}
*/
	
}
