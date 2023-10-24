package com.yedam.app.dep.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.dep.mapper.DepMapper;
import com.yedam.app.dep.service.DepService;
import com.yedam.app.dep.service.DepVO;

@Service
public class DepServiceImpl implements DepService {
	@Autowired
	DepMapper depMapper;
	
	@Override
	public List<DepVO> getDepAll() {
		return depMapper.selectAllDepInfo();
	}

	@Override
	public DepVO getDepInfo(DepVO depVO) {
		return depMapper.selectDepInfo(depVO);
	}

	@Override
	public int insertDepInfo(DepVO depVO) {
		int result = depMapper.insertDepInfo(depVO);
		
		if(result == 1) {
			return depVO.getDepartmentId();
		} else {			
			return -1;
		}
	}

	@Override
	public Map<String, Object> updateDepInfo(DepVO depVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean isSuccessed = false;
		
		int result = depMapper.updateDepInfoDynamic(depVO);
		if(result == 1) {
			isSuccessed = true;
		}
		
		map.put("result", isSuccessed);
		map.put("target", depVO);
		
		return map;
	}

	@Override
	public boolean deleteDepInfo(int depId) {
		int result = depMapper.deleteDepInfo(depId);
		
		if(result == 1) {
			return true;
		} else {
			return false;			
		}
	}
}
