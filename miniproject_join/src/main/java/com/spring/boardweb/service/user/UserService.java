package com.spring.boardweb.service.user;

import com.spring.boardweb.UserVO;

public interface UserService {
	void join(UserVO userVO);
	
	int idCheck(String userId); //아이디 가져옴
}
