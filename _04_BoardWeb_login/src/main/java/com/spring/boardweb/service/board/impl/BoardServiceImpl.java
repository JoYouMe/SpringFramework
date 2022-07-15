package com.spring.boardweb.service.board.impl;

import java.util.List;
import java.util.Map;

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
	public List<BoardVO> getBoardList(Map<String, String> paramMap) {
		return boardDAO.getBoardList(paramMap);
	}
	
	@Override 
	public BoardVO getBoard(int boardSeq) {  //BoardVO boardVO�� ����
		return boardDAO.getBoard(boardSeq);
	}
	
	@Override
	public void updateBoardCnt(int boardSeq) { //BoardVO boardVO�� ����
		boardDAO.updateBoardCnt(boardSeq);
	}

	@Override
	public void deleteBoard(int boardSeq) { //BoardVO boardVO�� ����
		boardDAO.deleteBoard(boardSeq);
		
	}

	@Override
	public void updateBoard(BoardVO boardVO) {
		boardDAO.updateBoard(boardVO);  //������ �����ϱ����� DAO�� �޼ҵ带 ����� ������
	}

//	@Override
//	public List<BoardVO> getBoardListSearch(Map<String, String> paramMap) {
//		return boardDAO.getBoardListSearch(paramMap); //�Ķ���ͷ� key���� paramMap������
//	}
//	
}
