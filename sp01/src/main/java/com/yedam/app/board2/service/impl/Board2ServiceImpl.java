package com.yedam.app.board2.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.board2.mapper.Board2Mapper;
import com.yedam.app.board2.service.Board2Service;
import com.yedam.app.board2.service.Board2VO;

@Service
public class Board2ServiceImpl implements Board2Service {
	
	@Autowired
	Board2Mapper board2Mapper;
	
//	전체조회
	@Override
	public List<Board2VO> selectBoardList() {
		return board2Mapper.selectBoardList();
	}

//	단건조회
	@Override
	public Board2VO selectBoardInfo(Board2VO vo) {
		return board2Mapper.selectBoardInfo(vo);
	}

//	등록
	@Override
	public int insertBoard(Board2VO vo) {
		int result = board2Mapper.insertBoardInfo(vo);
		
		if(result == 1) {
			return vo.getBno();
		} else {			
			return -1;
		}
	}

//	수정
	@Override
	public Map<String, Object> updateBoard(Board2VO vo) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean isSuccessed = false;
		
		if(board2Mapper.updateBoardInfo(vo) == 1) {
		 isSuccessed = true;	
		}
		
		map.put("result", isSuccessed);
		map.put("info", vo);
		
		return map;
	}

//	삭제
	@Override
	public int deleteBoard(Integer bno) {
		
		return board2Mapper.deleteBoardInfo(bno);
	}

}
