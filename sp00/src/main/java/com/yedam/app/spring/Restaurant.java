package com.yedam.app.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 레스토랑이 빈으로 등록 -> 스프링으로 제어
@Component
public class Restaurant {

//	필드 선언
//	Chef chef;
	
	// 이 클래스에 대해 빈으로 되어 있어야 Autowired 사용가능 스프링이 제어하기 때문에
	// 동시에 Chef 해당 클래스도 빈으로 등록되어야 함
	// @Autowired만 붙인다고 스프링이 관리 X / xml파일에 스캔을 등록해야함(component-scan : 하위 패키지에 있는 모든 어노테이션 기반으로 빈에 등록해줌)
	
	@Autowired
	Chef chef;
	
	public void open() {
		
//		spring 이전
//		1. Chef chef = new Chef(); 
//		2. open(Chef chef) 매게변수로
		
		chef.cooking();
	}
}
