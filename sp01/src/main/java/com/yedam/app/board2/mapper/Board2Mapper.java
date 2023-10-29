package com.yedam.app.board2.mapper;

import java.util.List;

import com.yedam.app.board2.service.Board2VO;

public interface Board2Mapper {
//	전체조회
	public List<Board2VO> selectBoardList();
	
//	한건조회 : 조건 bno
	public Board2VO selectBoardInfo(Board2VO vo);
	
//	등록 : 대상 - bno(selectkey), title, contents, writer, image
	public int insertBoardInfo(Board2VO vo);
	
//	수정 : 대상 title, contents, writer, updatedate, image 
	public int updateBoardInfo(Board2VO vo);
	
//	삭제 : 조건 bno
	public int deleteBoardInfo(Integer bno);
}
