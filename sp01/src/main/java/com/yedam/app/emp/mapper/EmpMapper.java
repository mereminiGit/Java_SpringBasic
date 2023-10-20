package com.yedam.app.emp.mapper;

import java.util.List;

import com.yedam.app.emp.service.EmpVO;

//base-package="com.yedam.app.**.mapper"

public interface EmpMapper {
	public List<EmpVO> selectAllEmpInfo();
	public EmpVO selectEmpInfo(EmpVO empVO);
}
