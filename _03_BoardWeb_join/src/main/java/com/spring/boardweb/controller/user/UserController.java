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
	 * @RequestMapping(value="/join.do", method = RequestMethod.GET) //a�±״� GET ����̱�
	 * ������ ���� public String joinView() { return "user/join"; }
	 * 
	 * @RequestMapping(value="/join.do", method = RequestMethod.POST) //������ ȸ�������ϴ�
	 * �޼ҵ�� POST ������� ���� public String join() { return "user/join"; }
	 */
	
	@RequestMapping("/join.do")
	public String join(UserVO userVO) {
		if(userVO.getUserId()== null || userVO.getUserId().equals("")) {
			return "user/join";
		}
		//ȸ������ ������ �Ѿ���� ���� ȸ������ ó�� �� �α��� ȭ������ �̵�
		userService.join(userVO); //userService�� join �Լ��� �����Ŵ
		return "user/login";
	}

	@RequestMapping("/login.do")
	public String login() {
		return "user/login";
	}
}
