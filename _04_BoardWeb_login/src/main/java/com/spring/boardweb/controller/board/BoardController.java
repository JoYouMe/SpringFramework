package com.spring.boardweb.controller.board;

import java.util.List;
import java.util.Map;

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
	public String getBoardList(HttpSession session, Model model, @RequestParam Map<String, String> paramMap) {
		UserVO loginUser = (UserVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "user/login";
		}
		
		List<BoardVO> boardList = boardService.getBoardList(paramMap);
		
		for(int i=0; i < boardList.size(); i++) {
			System.out.println(boardList.get(i).toString());
		}
		
		model.addAttribute("boardList", boardList);
		
		if(paramMap.get("searchCondition") != null && !paramMap.get("searchCondition").equals("")) {
			System.out.println("searchCondition================" + paramMap.get("searchCondition"));
			model.addAttribute("searchCondition", paramMap.get("searchCondition"));
		}
		
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
		
		model.addAttribute("board", board);
		
		return "board/getBoard";
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(HttpSession session, BoardVO boardVO) {
		UserVO loginUser = (UserVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "user/login";
		}
		
		if(boardVO.getBoardTitle() == null || boardVO.getBoardTitle().equals("")) {
			return "board/insertBoard";
		}
		
		boardService.insertBoard(boardVO);
		
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO boardVO) {
		boardService.updateBoard(boardVO);
		
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(@RequestParam int boardSeq) {
		boardService.deleteBoard(boardSeq);
		
		//바로 화면으로 이동하면 게시글 목록 데이터를 조회하지 못함
		//return "board/getBoardList";
		//게시글 목록 데이터를 조회한 후에 화면으로 이동시키기 위해서
		//getBoardList.do라는 요청을 보냄
		return "redirect:getBoardList.do";
	}
	
	/*
	 * @RequestMapping("/getBoardListSearch.do") public String
	 * getBoardListSearch(@RequestParam Map<String, String> paramMap, Model model) {
	 * List<BoardVO> searchBoardList = boardService.getBoardListSearch(paramMap);
	 * 
	 * model.addAttribute("boardList", searchBoardList);
	 * 
	 * return "board/getBoardList"; }
	 */
}
