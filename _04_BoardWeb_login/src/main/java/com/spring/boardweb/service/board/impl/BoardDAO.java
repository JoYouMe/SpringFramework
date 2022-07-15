package com.spring.boardweb.service.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.boardweb.BoardVO;

@Repository
public class BoardDAO {
	@Autowired
	SqlSessionTemplate mybatis;
	
	public void insertBoard(BoardVO boardVO) {
		mybatis.insert("BoardDAO.insertBoard", boardVO);
	}
	
	public List<BoardVO> getBoardList() {
		return mybatis.selectList("BoardDAO.getBoardList");
	}
	
	public BoardVO getBoard(int boardSeq) {
		return mybatis.selectOne("BoardDAO.getBoard", boardSeq);
	}
	
	public void updateBoardCnt(int boardSeq) {
		mybatis.update("BoardDAO.updateBoardCnt", boardSeq);
	}
	
	public void deleteBoard(int boardSeq) {
		mybatis.delete("BoardDAO.deleteBoard",boardSeq);
	}
	
	public void updateBoard(BoardVO boardVO) {
		mybatis.update("BoardDAO.updateBoard",boardVO);
	}
}
