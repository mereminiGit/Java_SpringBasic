package com.yedam.app.user.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.user.service.UserService;
import com.yedam.app.user.service.UserVO;
import com.yedam.app.user.service.UserVOList;

@CrossOrigin("*")
@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	// 1) Ajax + get + QueryString
	@GetMapping("getAjax")
	@ResponseBody
	public UserVO insertGetAjax(UserVO userVO) {
		return userService.insertUserInfo(userVO);
	}
	
	
	// 2) Ajax + post + QueryString
	@ResponseBody
	@PostMapping("postAjax")
	public UserVO insertPostAjax(UserVO userVO) {
		return userService.insertUserInfo(userVO);
	}
	
	
	// 3) Ajax + JSON(=> @RequestBody => @PostMapping) - 바디에 있는 정보를 가져와야하기에 get은 바디 X, post만 바디 가짐
	// -> 단건
	@PostMapping("jsonAjax")
	@ResponseBody
	public UserVO insertJsonAjax(@RequestBody UserVO userVO) {
		return userService.insertUserInfo(userVO);
	}
	
	// -> 배열
	@PostMapping("jsonListAjax")
	@ResponseBody Map<String, Object> insertJsonListAjax(@RequestBody List<UserVO> list){
		return userService.insertUserList(list);
	}
	
	@PostMapping("postListAjax")
	@ResponseBody 
	public Map<String, Object> insertPostListAjax(UserVOList userlist){	// 커멘트 객체
		return userService.insertUserList(userlist.getList());
	}
}
