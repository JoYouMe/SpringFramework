package com.spring.boardweb.service.impl;

import org.springframework.stereotype.Service;

import com.spring.boardweb.service.HomeService;

//어노테이션으로 별칭 만듦
//별칭없이 생성하면 클래스명에 첫 글자만 소문자로 변경됨 이름으로 객체생성
@Service("homeServiceImpl")             //HomeService 상속
public class HomeServiceimplTwo implements HomeService {

}
