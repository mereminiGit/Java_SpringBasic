package com.yedam.app.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainExample {
	public static void main(String[] args) {
		ApplicationContext ctx 
			= new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		// 빈을 불러올 때는 이름이 있을 경우 이름
		// 이름이 없을 때는 클래스 정보를 넘겨준다 -> 클래스에 있는 빈을 불러와줌
		Restaurant res = ctx.getBean(Restaurant.class);
		res.open();
	}
}
