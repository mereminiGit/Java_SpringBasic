package com.yedam.app.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.emp.service.EmpVO;

//base-package="com.yedam.app.**.mapper"

public interface EmpMapper {
	// 전체조회 (다건조회)
	public List<EmpVO> selectAllEmpInfo();
	
	// 사원조회 (단건조회) -> 무조건 결과는 하나 where절이 필요
	public EmpVO selectEmpInfo(EmpVO empVO);
	
	// 등록
	public int insertEmpInfo(EmpVO empVO);
	
	// 수정
	public int updateEmpInfo(EmpVO empVO);
	
	// 수정 : Dynamic SQL(이거 때문에 mybatis가 많이 사용되기도 함)
	public int updateEmpInfoDynamic(EmpVO empVO);
	
	// 삭제
	public int deleteEmpInfo(@Param("employeeId") int employeeId);
	// 만약 매게변수가 두개 이상일 떄!
	// @Param("변수") 이름을 동일하게 써줘서 어떤 값인지 알려주면 됨
}
