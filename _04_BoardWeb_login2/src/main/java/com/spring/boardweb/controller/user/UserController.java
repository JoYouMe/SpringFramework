package com.spring.boardweb.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String loginView() {
		return "user/login";
	}
	
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	@ResponseBody					
									//����Ʈ�� ��� ���ƴٴϸ鼭�� ��� ���� �� �� �ֵ��� session�� ����
	public String login(HttpSession session, UserVO userVO) throws JsonProcessingException {
	//Json ��ü�� ��ȯ���ִ� Ŭ����: ObjectMapper
	ObjectMapper mapper = new ObjectMapper();
	Map<String, Object> jsonMap = new HashMap<String, Object>();
	
	//1. �����ϴ� ���̵����� üũ
	int idCheck = userService.idCheck(userVO.getUserId());
	
	if(idCheck < 1) {
		jsonMap.put("message", "idFail");
	}else {
		//2.�н����� Ȯ��
		int pwCheck = userService.pwCheck(userVO);
		
		if(pwCheck < 1){
			jsonMap.put("message", "pwFail");
		}else {
			//3. �α��� ó��
			UserVO user = userService.login(userVO);
			
			session.setAttribute("loginUser", user);
			
			jsonMap.put("message", "loginSuccess");
		}
	}
	
	String jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonMap);

	return jsonStr;

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
