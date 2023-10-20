package com.yedam.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainExample {
	
	public static void main(String[] args) {
		
		// 일반적으로 사용한 방법
		SamsungTV tv = new SamsungTV();
		tv.on();
		
		// 스프링
		// 컨테이너를 관리하는 얘
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		TV tv_spring = (TV)ctx.getBean("tv");
		tv_spring.on();
	}
}
