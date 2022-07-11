package com.spring.boardweb.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.boardweb.service.HomeService;

@Controller
public class HomeController {

//부모 컨테이너에서 모델객체를 먼저 생성 후 자식 컨네이터에서는 컨드롤러 생성 후 Autowired
	//Autowired는 의존성을 주입할 때 모양만 비교
	//HomeService 모양으로 생성된 객체 존재 여부 확인
	//HomeService 모양의 객체가 여러개 존재하면 에러
//	@Autowired //new HomeServiceImpl();
	//Qualifier는 의존성을 주입할 때 모양과 이름을 비교
	//같은 모양이 객체가 여러가 존재할 때 이름으로 비교하여 의존성 주입
	@Qualifier("homeServiceImpl")
	HomeService homeSevice;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		model.addAttribute("hi", "Hello Spring" );
		
		//1. Session Scope
		//System.out.println("session data ===========" + session.getAttribute("hello"));
		return "home";
	}
	
	//화면단에서 전달되는 파라미터 받기
	//1. @RequestParam 어노테이션을 이용하여 변수에 할
	/*
	 * @RequestMapping(value = "test.do", method = RequestMethod.GET) public String
	 * testGet(@RequestParam("firstName") String firstName,
	 * 
	 * @RequestParam("lastName") String lastName) { System.out.println("get요청 처리");
	 * System.out.println("get firstName======" + firstName);
	 * System.out.println("get lastName======" + lastName); return "home"; }
	 * 
	 * @RequestMapping(value = "test.do", method = RequestMethod.POST) public String
	 * testPost(@RequestParam("firstName") String firstName,
	 * 
	 * @RequestParam("lastName") String lastName) { System.out.println("post요청 처리");
	 * System.out.println("post firstName======" + firstName);
	 * System.out.println("post lastName======" + lastName); return "home"; }
	 */
	
	//2. @RequestParam 어노테이션을 이용하여 Map에 할당
	/*
	 * @RequestMapping(value = "test.do", method = RequestMethod.GET) public String
	 * testGet(@RequestParam Map<String, Object> paramMap) {
	 * System.out.println("get요청 처리"); System.out.println("get firstName======" +
	 * paramMap.get("firstName")); System.out.println("get lastName======" +
	 * paramMap.get("lastName")); System.out.println("get age======" +
	 * paramMap.get("age")); System.out.println("get job======" +
	 * paramMap.get("lastName")); return "redirect:/"; }
	 * 
	 * @RequestMapping(value = "test.do", method = RequestMethod.POST) public String
	 * testPost(@RequestParam Map<String, Object> paramMap) {
	 * System.out.println("post요청 처리"); System.out.println("post firstName======" +
	 * paramMap.get("firstName")); System.out.println("post lastName======" +
	 * paramMap.get("lastName")); System.out.println("get age======" +
	 * paramMap.get("age")); System.out.println("get job======" +
	 * paramMap.get("lastName")); // /WEB-INH/vies/home.jsp // redirect: 주소 설정 시
	 * viewResolver를 타지 않고 원하는 주소로 바로 이동하도록 설정 // redirect 시 주소도 이동할 주소로 변경 return
	 * "redirect:/"; }
	 */
	
	//3. Command 객체를 이용하여 파라미터 받기
	// Command 객체: 함수의 매개변수안에 선언된 객체
	@RequestMapping(value = "test.do", method = RequestMethod.GET)
	public String testGet(HomeVO homeVO) {
		System.out.println("get요청 처리");
		System.out.println("get firstName======" + homeVO.getFirstName());
		System.out.println("get lastName======" + homeVO.getLastName());
		System.out.println("get age======" + homeVO.getAge());
		System.out.println("get job======" + homeVO.getJob());
		return "redirect:/";
	}
	
	@RequestMapping(value = "test.do", method = RequestMethod.POST)
	public String testPost(HomeVO homeVO) {
		System.out.println("post요청 처리");
		System.out.println("post firstName======" + homeVO.getFirstName());
		System.out.println("post lastName======" + homeVO.getLastName());
		System.out.println("post age======" + homeVO.getAge());
		System.out.println("post job======" + homeVO.getJob());
		// /WEB-INH/vies/home.jsp
		// redirect: 주소 설정 시 viewResolver를 타지 않고 원하는 주소로 바로 이동하도록 설정
		// redirect 시 주소도 이동할 주소로 변경
		return "redirect:/";
	}
	
	@RequestMapping("/hello.do")
	public String hello(HttpSession session, Model model) { //HttpSession 커맨드 session 사용 가능
		//1. Session Scope
		//session.setAttribute("hello", "12345");
		
		//2. Reuest Scope
		model.addAttribute("hello","12345");
		return "Hello";
	}
	
}
