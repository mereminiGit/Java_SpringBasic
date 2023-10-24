package com.yedam.app.emp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Service
// Impl는 Service 어노테이션이 필요함
public class EmpServiceImpl implements EmpService {
	
//	Mapper 필요
	@Autowired
	EmpMapper empMapper;
	// @Autowired를 통해 mapper를 불러와야함
	
	@Override
	public List<EmpVO> getEmpAll() {
		return empMapper.selectAllEmpInfo();
	}

	@Override
	public EmpVO getEmpInfo(EmpVO empVO) {
		return empMapper.selectEmpInfo(empVO);
	}

//	등록
	@Override
	public int insertEmpInfo(EmpVO empVO) {
		int result = empMapper.insertEmpInfo(empVO);
		
		if (result == 1) {			
			return empVO.getEmployeeId();
		} else {			
			return -1;
		}
	}
	
//	수정 
	@Override
	public Map<String, Object> updateEmpInfo(EmpVO empVO) {
		Map<String, Object> map = new HashMap<>();
		// Map 잘 사용하기
		boolean isSuccessed = false;
		
		int result = empMapper.updateEmpInfo(empVO);
		if(result == 1) {
			isSuccessed = true;
		}
		
		map.put("result", isSuccessed);
		map.put("target", empVO);
		
		return map;
	}

//	삭제
	@Override
	public boolean deleteEmpInfo(int empId) {
		int result = empMapper.deleteEmpInfo(empId);
		
		if(result == 1) {			
			return true;
		} else {
			return false;			
		}
	}
}