package com.yedam.app.dep.service;

import java.util.List;
import java.util.Map;

public interface DepService {
	// 전체조회
	public List<DepVO> getDepAll();
	
	// 단건조회
	public DepVO getDepInfo(DepVO depVO);
	
	// 등록
	public int insertDepInfo(DepVO depVO);
	
	// 수정
	public Map<String, Object> updateDepInfo(DepVO depVO);
	
	// 삭제
	public boolean deleteDepInfo(int depId);
}
