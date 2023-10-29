package com.yedam.app.board2.service;

import java.util.List;
import java.util.Map;

public interface Board2Service {
//	전체조회
	public List<Board2VO> selectBoardList();
	
//	단건조회
	public Board2VO selectBoardInfo(Board2VO vo);
	
//	등록
	public int insertBoard(Board2VO vo);
	
//	수정
	public Map<String, Object> updateBoard(Board2VO vo);
	
//	삭제
	public int deleteBoard(Integer bno);
}
