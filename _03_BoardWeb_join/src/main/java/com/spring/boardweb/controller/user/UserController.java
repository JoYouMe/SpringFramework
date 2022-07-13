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
	 * @RequestMapping(value="/join.do", method = RequestMethod.GET) //a태그는 GET 방식이기
	 * 때문에 설정 public String joinView() { return "user/join"; }
	 * 
	 * @RequestMapping(value="/join.do", method = RequestMethod.POST) //실제로 회원가입하는
	 * 메소드는 POST 방식으로 실행 public String join() { return "user/join"; }
	 */
	
	@RequestMapping("/join.do")
					  //클래스, 파라미터
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
	
	@RequestMapping("/idCheck.do")
	//ViewResolver를 타게 되면 ResponseBody를 HTML 구조로 만들어서 화면을 리턴
	//만약 ViewResolver를 안타고 반환 값 자체를 ResponseBody로 만드려면 @ResponseBody 사용
	@ResponseBody
	public String idCheck(UserVO userVO) throws JsonProcessingException {
		//Json 객체로 변환해주는 클래스: ObjectMapper
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		//id가 같은 문자를 count해야되기 때문에 int
		int resultIdCheck = userService.idCheck(userVO.getUserId());
		jsonMap.put("resultIdCheck", resultIdCheck);
		//object mapper를 이용해서 json형태로 jsonstring으로 변환해서 spring으로 던져줌
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonMap);
		System.out.println("jsonString===============================" + json);
		
		return json;
		
	}
}
