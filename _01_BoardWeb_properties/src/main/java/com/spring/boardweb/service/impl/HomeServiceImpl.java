package com.spring.boardweb.service.impl;

import org.springframework.stereotype.Service;

import com.spring.boardweb.service.HomeService;

//어노테이션으로 별칭을 만들어 줄수 있다.
//별칭없이 생성하면 클래스명에서 첫 글자만 소문자로 변경된 이름으로 객체생성
@Service("homeServiceImpl")
public class HomeServiceImpl implements HomeService {

}
