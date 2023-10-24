package com.yedam.app.emp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;

@CrossOrigin
// 웹과 관련된 아이이기 때문에 Controller라는 어노테이션 붙는다.
@Controller
public class EmpTestController {
	
//	커맨드 객체
	@GetMapping("parameterTest")
	public String getMethodTest(EmpVO empVO) {
		System.out.println(empVO);
		return "";
	}
	
	@PostMapping("parameterTest")
	public String postMethodTest(EmpVO empVO) {
		System.out.print("Post: ");
		System.out.println(empVO);
		return "";
	}
	
//	@RequestParam으로 개별개별 분리되어서 데이터가 담긴다
	@GetMapping("reqParamTest")
	public String reqParamGet(String employeeId, String lastName) {
		System.out.print("get: ");
		System.out.printf("%s, %s\n", employeeId, lastName);
		return "";
	}
	
	@PostMapping("reqParamTest")
	public String reqParamPost(@RequestParam String employeeId, 
							   @RequestParam(defaultValue = "guest") String lastName) {
		System.out.print("post: ");
		System.out.printf("%s, %s\n", employeeId, lastName);
		return "";
	}
	
//	@PathVariable
	@GetMapping("pathGet/{employeeId}")
	public String pathGet(@PathVariable String employeeId) {
		System.out.print("get: ");
		System.out.printf("%s\n", employeeId);
		return "";
	}
	@PostMapping("pathPost/{Id}")
	public String pathPost(@PathVariable(name = "Id") String employeeId) {
		System.out.print("post: ");
		System.out.printf("%s\n", employeeId);
		return "";
	}
	
//	@RequestBody
	@PostMapping("ajaxJson")
	@ResponseBody
	public EmpVO ajaxJson(@RequestBody EmpVO empVO) {
		return empVO;
	}
	
	
}
