package com.yedam.app.dep.mapper;

import java.util.List;

import com.yedam.app.dep.service.DepVO;

public interface DepMapper {
	// 전체 조회
	public List<DepVO> selectAllDepInfo();
	
	// 단건 조회
	public DepVO selectDepInfo(DepVO depVO);
	
	// 등록
	public int insertDepInfo(DepVO depVO);
	
	// 수정
	public int updateDepInfoDynamic(DepVO depVO);
	
	// 삭제
	public int deleteDepInfo(int departmentId);
}
