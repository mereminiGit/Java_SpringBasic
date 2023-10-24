package com.yedam.app.dep.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.dep.service.DepService;
import com.yedam.app.dep.service.DepVO;

@Controller
public class DepController {
	@Autowired
	DepService depService;
	
	// 전체 조회
	@GetMapping("depList")
	public String getDepList (Model model) {
		List<DepVO> list = depService.getDepAll();
		model.addAttribute("depList", list);
		return "dep/depList";
	}
	
	// 단건 조회
	@GetMapping("depInfo")
	public String getDepInfo (DepVO depVO, Model model) {
		DepVO findVO = depService.getDepInfo(depVO);
		model.addAttribute("depInfo", findVO);
		return "dep/depInfo";
	}
}
