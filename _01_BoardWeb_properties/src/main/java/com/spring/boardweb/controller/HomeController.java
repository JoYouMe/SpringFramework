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

//�θ� �����̳ʿ��� �𵨰�ü�� ���� ���� �� �ڽ� �������Ϳ����� ����ѷ� ���� �� Autowired
	//Autowired�� �������� ������ �� ��縸 ��
	//HomeService ������� ������ ��ü ���� ���� Ȯ��
	//HomeService ����� ��ü�� ������ �����ϸ� ����
//	@Autowired //new HomeServiceImpl();
	//Qualifier�� �������� ������ �� ���� �̸��� ��
	//���� ����� ��ü�� ������ ������ �� �̸����� ���Ͽ� ������ ����
	@Qualifier("homeServiceImpl")
	HomeService homeSevice;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		model.addAttribute("hi", "Hello Spring" );
		
		//1. Session Scope
		//System.out.println("session data ===========" + session.getAttribute("hello"));
		return "home";
	}
	
	//ȭ��ܿ��� ���޵Ǵ� �Ķ���� �ޱ�
	//1. @RequestParam ������̼��� �̿��Ͽ� ������ ��
	/*
	 * @RequestMapping(value = "test.do", method = RequestMethod.GET) public String
	 * testGet(@RequestParam("firstName") String firstName,
	 * 
	 * @RequestParam("lastName") String lastName) { System.out.println("get��û ó��");
	 * System.out.println("get firstName======" + firstName);
	 * System.out.println("get lastName======" + lastName); return "home"; }
	 * 
	 * @RequestMapping(value = "test.do", method = RequestMethod.POST) public String
	 * testPost(@RequestParam("firstName") String firstName,
	 * 
	 * @RequestParam("lastName") String lastName) { System.out.println("post��û ó��");
	 * System.out.println("post firstName======" + firstName);
	 * System.out.println("post lastName======" + lastName); return "home"; }
	 */
	
	//2. @RequestParam ������̼��� �̿��Ͽ� Map�� �Ҵ�
	/*
	 * @RequestMapping(value = "test.do", method = RequestMethod.GET) public String
	 * testGet(@RequestParam Map<String, Object> paramMap) {
	 * System.out.println("get��û ó��"); System.out.println("get firstName======" +
	 * paramMap.get("firstName")); System.out.println("get lastName======" +
	 * paramMap.get("lastName")); System.out.println("get age======" +
	 * paramMap.get("age")); System.out.println("get job======" +
	 * paramMap.get("lastName")); return "redirect:/"; }
	 * 
	 * @RequestMapping(value = "test.do", method = RequestMethod.POST) public String
	 * testPost(@RequestParam Map<String, Object> paramMap) {
	 * System.out.println("post��û ó��"); System.out.println("post firstName======" +
	 * paramMap.get("firstName")); System.out.println("post lastName======" +
	 * paramMap.get("lastName")); System.out.println("get age======" +
	 * paramMap.get("age")); System.out.println("get job======" +
	 * paramMap.get("lastName")); // /WEB-INH/vies/home.jsp // redirect: �ּ� ���� ��
	 * viewResolver�� Ÿ�� �ʰ� ���ϴ� �ּҷ� �ٷ� �̵��ϵ��� ���� // redirect �� �ּҵ� �̵��� �ּҷ� ���� return
	 * "redirect:/"; }
	 */
	
	//3. Command ��ü�� �̿��Ͽ� �Ķ���� �ޱ�
	// Command ��ü: �Լ��� �Ű������ȿ� ����� ��ü
	@RequestMapping(value = "test.do", method = RequestMethod.GET)
	public String testGet(HomeVO homeVO) {
		System.out.println("get��û ó��");
		System.out.println("get firstName======" + homeVO.getFirstName());
		System.out.println("get lastName======" + homeVO.getLastName());
		System.out.println("get age======" + homeVO.getAge());
		System.out.println("get job======" + homeVO.getJob());
		return "redirect:/";
	}
	
	@RequestMapping(value = "test.do", method = RequestMethod.POST)
	public String testPost(HomeVO homeVO) {
		System.out.println("post��û ó��");
		System.out.println("post firstName======" + homeVO.getFirstName());
		System.out.println("post lastName======" + homeVO.getLastName());
		System.out.println("post age======" + homeVO.getAge());
		System.out.println("post job======" + homeVO.getJob());
		// /WEB-INH/vies/home.jsp
		// redirect: �ּ� ���� �� viewResolver�� Ÿ�� �ʰ� ���ϴ� �ּҷ� �ٷ� �̵��ϵ��� ����
		// redirect �� �ּҵ� �̵��� �ּҷ� ����
		return "redirect:/";
	}
	
	@RequestMapping("/hello.do")
	public String hello(HttpSession session, Model model) { //HttpSession Ŀ�ǵ� session ��� ����
		//1. Session Scope
		//session.setAttribute("hello", "12345");
		
		//2. Reuest Scope
		model.addAttribute("hello","12345");
		return "Hello";
	}
	
}
