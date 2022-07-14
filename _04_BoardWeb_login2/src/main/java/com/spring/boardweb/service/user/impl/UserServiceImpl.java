package com.spring.boardweb.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boardweb.UserVO;
import com.spring.boardweb.service.user.UserService;
//쿼리를 실행시키려면 DAO 호출해서 DAO에 있는 mapper의 메소드를 호출
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDAO userDAO;
	
	@Override
	public void join(UserVO userVO) {
		userDAO.join(userVO);
	}
	
	@Override
	public int idCheck(String userId) {
		return userDAO.idCheck(userId);
	}
	
	@Override
	public int pwCheck(UserVO userVO) {
		return userDAO.pwCheck(userVO);
	}
	
	@Override
	public UserVO login(UserVO userVO) {
		return userDAO.login(userVO);
	}
	
	
}
