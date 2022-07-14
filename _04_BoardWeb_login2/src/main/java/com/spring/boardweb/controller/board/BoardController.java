package com.spring.boardweb.controller.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.boardweb.BoardVO;
import com.spring.boardweb.UserVO;
import com.spring.boardweb.service.board.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/getBoardList.do") 
	public String getBoardList(HttpSession session, Model model) {
		UserVO loginUser = (UserVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "user/login";
		}
		
		//BoardVO 데이터를 List로 담아줌
		List<BoardVO> boardList = boardService.getBoardList();
		
		for(int i = 0; i < boardList.size(); i++) {
			System.out.println(boardList.get(i).toString());
		}
		
		model.addAttribute("boardList",boardList);
		return "board/getBoardList";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(HttpSession session, @RequestParam int boardSeq, Model model) {
		UserVO loginUser = (UserVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "user/login";
		}
		
		boardService.updateBoardCnt(boardSeq);
		
		BoardVO board = boardService.getBoard(boardSeq);
		
						//board라는 키 값으로 가져옴
		model.addAttribute("board",board);
		
		return "board/getBoard";
	}
	
	@RequestMapping("/insertBoard.do")                    //입력값을 받아오는 파라미터
	public String insertBoard(HttpSession session, BoardVO boardVO) {
		UserVO loginUser = (UserVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "user/login";
		}
		 //입력값이 없으면 insertBoard 화면으로 이동
		if(boardVO.getBoardTitle() == null || boardVO.getBoardTitle().equals("")) {
			return "board/insertBoard";
		}
		
		boardService.insertBoard(boardVO);
		
		return "redirect:getBoardList.do";
	}
}
