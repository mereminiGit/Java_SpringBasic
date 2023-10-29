package com.yedam.app.board2.web;

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

import com.yedam.app.board2.service.Board2Service;
import com.yedam.app.board2.service.Board2VO;

@Controller
public class Board2Controller {
	
	@Autowired
	Board2Service board2Service;
	
//	전체조회	: URI - board2List / RETURN - board2/board2List
	@GetMapping("board2List")
	public String selectBoard2List(Model model) {
		List<Board2VO> boards =  board2Service.selectBoardList();
		model.addAttribute("board2List", boards);
		return "board2/board2List";
	}
//	단건조회	: URI - board2Info / RETURN - board2/board2Info / PARAMETER - Board2VO
	@GetMapping("board2Info")
	public String selectBoard2Info(Model model, Board2VO vo) {
		Board2VO board = board2Service.selectBoardInfo(vo);
		model.addAttribute("board2Info", board);
		return "board2/board2Info";
	}
	
//	등록 - 페이지
	@GetMapping("board2Insert")
	public String insertBoard2Info() {
		return "board2/board2Insert";
	}
	
//	등록 - 처리
	@PostMapping("board2Insert")
	public String insertBoard2Process(Board2VO vo) {
		board2Service.insertBoard(vo);
		
		return "redirect:board2List";
	}
	
//	수정 - 페이지
	@GetMapping("board2Update")
	public String updateBoard2Info(Board2VO vo, Model model) {
		model.addAttribute("board2Info", board2Service.selectBoardInfo(vo));
		return "board2/board2Update";
	}
	
//	수정 - 처리
	@PostMapping("board2Update")
	@ResponseBody
	public Map<String, Object> updateBoard2Process(@RequestBody Board2VO vo) {
		return board2Service.updateBoard(vo);
	}
	
//	삭제
	@GetMapping("board2Delete")
	public String deleteBoard(@RequestParam Integer bno, RedirectAttributes ratt) {
		int result = board2Service.deleteBoard(bno);
		
		String msg = null;
		
		if(result == 1) {
			msg = "Success. Id - " + bno;
		} else {
			msg = "Fail. Id - " + bno;			
		}
		
		ratt.addFlashAttribute("result" ,msg);
		
		return "redirect:board2List"; 
	}
}












