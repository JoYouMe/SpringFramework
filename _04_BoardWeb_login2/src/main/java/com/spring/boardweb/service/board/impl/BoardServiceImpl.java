package com.spring.boardweb.service.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boardweb.BoardVO;
import com.spring.boardweb.service.board.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardVO boardVO) {
		boardDAO.insertBoard(boardVO);
	}
	
	@Override
	public List<BoardVO> getBoardList(){
		return boardDAO.getBoardList();
	}
	
	@Override
	public BoardVO getBoard(int boardSeq) {
		return boardDAO.getBoard(boardSeq);
	}
	
	@Override
	public void updateBoardCnt(int boardSeq) {
		boardDAO.updateBoardCnt(boardSeq);
	}
}
