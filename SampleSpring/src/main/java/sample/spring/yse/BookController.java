package sample.spring.yse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller //��Ʈ�ѷ� ������̼� ����
public class BookController {
	
	//������ �ּҰ� /create�� �� ����Ǵ� �ڹ� ����ѷ� �޼ҵ� �ۼ�
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("book/create");
	}
	//create �޼ҵ�� ���������� /create �ּҰ� GET ������� �ԷµǾ��� �� book/create ����� �並 ������
}