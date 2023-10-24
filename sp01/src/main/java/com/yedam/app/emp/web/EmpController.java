package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

// 4번째, 클래스를 만들면 해당 어노테이션 먼저 붙이기(클래스는 대부분 빈으로 등록되어야 함)
@Controller
public class EmpController {
	@Autowired
	EmpService empService;
//	여러개의 서비스를 불러올 수 있다.
	
	// GET  : 	조회, 페이지 호출 
	// POST : 	데이터 조작과 관련된 기능(등록, 수정, 삭제)
	
	// 전체 조회
	@GetMapping("empList")
	public String getEmpList(Model model) {			// 페이지가 필요하므로 String
		List<EmpVO> list = empService.getEmpAll();
		model.addAttribute("empList", list);
		return "emp/empList";	// 페이지 위치
	}
	
	// 단건 조회
	@GetMapping("empInfo")
	public String getEmpInfo(EmpVO empVO, Model model) {			// 단건 조회는 조건이 필요
		EmpVO findVO = empService.getEmpInfo(empVO);
		model.addAttribute("empInfo", findVO);
		return "emp/empInfo";
	}
		
	// (화면을 어케 설정하냐에 따라 컨트롤러가 하나 이상일 수 있다. - 등록, 수정)
	// 등록 - Form
	@GetMapping("empInsert")
	public String insertEmpInfoForm() {
		
		return "emp/empInsert";
	}
	
	// 등록 - Process 데이터가 넘어오기에) / 커맨드 객채 사용
	@PostMapping("empInsert")
	public String insertEmpInfoProcess(EmpVO empVO) {
		int empId = empService.insertEmpInfo(empVO);
		
		if (empId > -1) {			
			return "redirect:empInfo?employeeId=" + empId;
		} else {
			return "redirect:empList";
		}
	}
	
	// 일반적으로 forward 화면으로 갈때 model을 사용한다.
	
	// 수정 - Process => Ajax : @ResposeBody
	
	//	1)				+ QueryString => 커맨드 객체
	@PostMapping("empUpdate")
	@ResponseBody	// 돌려주는건 리턴 위에
	public Map<String, Object> empUpdateProcess(EmpVO empVO) { 
		
		return empService.updateEmpInfo(empVO);
	}
	// 	2)				+ JSON => @RequestBody
	@PostMapping("empUpdateAjax")
	@ResponseBody
	public Map<String, Object> empUpdateAjaxProcess(@RequestBody EmpVO empVO) { // 받는거는 매게변수 넣는곳에
		return empService.updateEmpInfo(empVO);
	}
	
	// 삭제
	@GetMapping("empDelete")
	public String empDeleteProcess(@RequestParam Integer employeeId,
								   RedirectAttributes ratt) {
		boolean result = empService.deleteEmpInfo(employeeId);
		
		String msg = null;
		
		if(result) {
			msg = "Success. | employeeId: " + employeeId;
		} else {
			msg = "Fail. | employeeId: " + employeeId;			
		}
		ratt.addFlashAttribute("result", msg);
		
		return "redirect:empList";
	}
}
















