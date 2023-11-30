package com.yedam.app.emp.service;

import java.util.List;

import lombok.Data;

@Data
public class MemberVO {
	private String firstName;
	private int dept;
	private List<String> hobby;
}
