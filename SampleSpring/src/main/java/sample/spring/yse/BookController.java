package sample.spring.yse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller //컨트롤러 어노테이션 설정
public class BookController {
	
	//브라우저 주소가 /create일 때 실행되는 자바 컨드롤러 메소드 작성
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("book/create");
	}
	//create 메소드는 브라우저에서 /create 주소가 GET 방식으로 입력되었을 때 book/create 경로의 뷰를 보여줌
}