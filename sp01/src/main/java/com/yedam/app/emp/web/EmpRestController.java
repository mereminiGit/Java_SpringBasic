package com.yedam.app.emp.web;
// rest 방식으로

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@RestController		// 페이지 반환이 안 된다.(데이터를 반환하는 용도)
public class EmpRestController {
	
	@Autowired
	EmpService empService;
	
	// 전체 조회
	// 경로 간단하게 표시함
	@GetMapping("emps")
	public List<EmpVO> selectEmpAll() {
		return empService.getEmpAll();
	}
	
	// 단건 조회
	// (@PathVariable이 사용되면서 전체조회와 구분됨 조회하고자 하는 대상을 경로에 넣어준다(쿼리 스트링이 아니라)
	@GetMapping("emps/{eid}")
	public EmpVO selectEmpInfo(@PathVariable Integer eid) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(eid);
		return empService.getEmpInfo(empVO);
	}
	
	// 등록
	@PostMapping("emps")
	public Map<String, Object> insertEmpInfo(@RequestBody EmpVO empVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		String msg = null;
		int employeeId = empService.insertEmpInfo(empVO);
		
		if(employeeId > -1) {
			msg = "success";
		} else {
			msg = "fail";
		}
		
		map.put("result", msg);
		map.put("target", employeeId);
		
		return map;
	}
	
	// 수정
	// @PathVariable 쓸 수도 있고 안 쓸 수도 있음
	@PutMapping("emps/{eid}")
	public Map<String, Object> updateEmpInfo(@PathVariable("eid") Integer employeeId,
											@RequestBody EmpVO empVO) {
		empVO.setEmployeeId(employeeId);
		return empService.updateEmpInfo(empVO);
	}
	
	
	
	// 삭제
	@DeleteMapping("emps/{eid}")
	public Map<String, Object> deleteEmpInfo(@PathVariable("eid") Integer employeeId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", empService.deleteEmpInfo(employeeId));
		map.put("target", employeeId);
		return map;
	}
	
	
}








