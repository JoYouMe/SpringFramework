package com.spring.boardweb.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.boardweb.UserVO;
import com.spring.boardweb.service.user.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	/*
	 * @RequestMapping(value="/join.do", method = RequestMethod.GET) //a태그는 GET 방식이기
	 * 때문에 설정 public String joinView() { return "user/join"; }
	 * 
	 * @RequestMapping(value="/join.do", method = RequestMethod.POST) //실제로 회원가입하는
	 * 메소드는 POST 방식으로 실행 public String join() { return "user/join"; }
	 */
	
	@RequestMapping("/join.do")
	public String join(UserVO userVO) {
		if(userVO.getUserId()== null || userVO.getUserId().equals("")) {
			return "user/join";
		}
		//회원가입 정보가 넘어왔을 때는 회원가입 처리 후 로그인 화면으로 이동
		userService.join(userVO); //userService에 join 함수를 실행시킴
		return "user/login";
	}

	@RequestMapping("/login.do")
	public String login() {
		return "user/login";
	}
}
