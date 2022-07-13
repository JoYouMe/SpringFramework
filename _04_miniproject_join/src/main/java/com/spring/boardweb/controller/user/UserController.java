package com.spring.boardweb.controller.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
					  //Ŭ����, �Ķ����
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
	
	@RequestMapping("/idCheck.do")
	//ViewResolver�� Ÿ�� �Ǹ� ResponseBody�� HTML ������ ���� ȭ���� ����
	//���� ViewResolver�� ��Ÿ�� ��ȯ �� ��ü�� ResponseBody�� ������� @ResponseBody ���
	@ResponseBody
	public String idCheck(UserVO userVO) throws JsonProcessingException {
		//Json ��ü�� ��ȯ���ִ� Ŭ����: ObjectMapper
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		//id�� ���� ���ڸ� count�ؾߵǱ� ������ int
		int resultIdCheck = userService.idCheck(userVO.getUserId());
		jsonMap.put("resultIdCheck", resultIdCheck);
		//object mapper�� �̿��ؼ� json���·� jsonstring���� ��ȯ�ؼ� spring���� ������
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonMap);
		System.out.println("jsonString===============================" + json);
		
		return json;
		
	}
}
