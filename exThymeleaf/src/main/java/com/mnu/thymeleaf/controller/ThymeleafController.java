package com.mnu.thymeleaf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mnu.thymeleaf.domain.DeptDTO;

@Controller
public class ThymeleafController {
	//로그 출력용
	private static final Logger log =
			LoggerFactory.getLogger(ThymeleafController.class);
	
	@GetMapping("/")
	public String mainIndex() {
		return "index";
	}
	
	@GetMapping("Board/board_list")
	public String boardList() {
		return "Board/board_list";
	}
	
	//실습 1 (표현식 ${})
	@GetMapping("exam01")
	public String exam01(Model model) {
		log.info("Call : exam01");
		model.addAttribute("name","홍길동" );
		model.addAttribute("score",99);
		
		return "exam01";
	}
	
	//실습2 DTO 출력
	@GetMapping("exam02")
	public String exam02(Model model) {
		log.info("Call : exam02");
		DeptDTO deptDTO = new DeptDTO();
		deptDTO.setDno(10);
		deptDTO.setDname("인사과");
		deptDTO.setLoc("목포");
		
		model.addAttribute("deptDTO", deptDTO);
		return "exam02";
	}
	
	//실습3 DTO 출력(table)
	@GetMapping("exam03")
	public String exam03(Model model) {
		log.info("Call : exam03");
		DeptDTO deptDTO = new DeptDTO();
		deptDTO.setDno(10);
		deptDTO.setDname("인사과");
		deptDTO.setLoc("목포");
		
		model.addAttribute("deptDTO", deptDTO);
		return "exam03";
	}
	
}
