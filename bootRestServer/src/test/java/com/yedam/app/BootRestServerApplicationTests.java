package com.yedam.app;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.app.emp.service.GreetingVO;
import com.yedam.app.emp.service.MemberVO;

@SpringBootTest
class BootRestServerApplicationTests {

	// spring에서는 JSON jackson으로 처리
	@Test
	void jacksonTest() throws JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		GreetingVO vo = new GreetingVO("hello","철수");
		String str = om.writeValueAsString(vo);	// JSON형태의 스트링
		System.out.println(str);
		assertThat(str.startsWith("{"));
		//@ResponseBody의 역할 : vo객체를(vo, map, List) json스트링으로 바꿔주는 역할
			
	}
	
	@Test
	void mapTest() throws JsonProcessingException {
		HashMap<String, Object> map = new HashMap<>();
		map.put("firstName", "min");
		map.put("dept", 10);
		map.put("hobby", new String[] {"reading", "game"});
		
		// {firstName:"min", dept:10, hobby:["reading","gmae"]}
		ObjectMapper om = new ObjectMapper();
		String str = om.writeValueAsString(map);
		System.out.println(str);
		//assertThat(str.startsWith("{"));
	}
	
	
	@Test
	void jacksonReadTest() throws JsonMappingException, JsonProcessingException {
		String str = "{\"msg\":\"hello\",\"name\":\"철수\"}";
		ObjectMapper om = new ObjectMapper();
		GreetingVO vo = om.readValue(str, GreetingVO.class); // spring을 읽어서 VO타입으로 읽어서 파싱
		System.out.println(vo);
		assertThat(vo.getMsg().equals("hello"));
	}
	// @RequestBody의 역할 : JSON형식의 스트링을 객체( {} => vo, map / [] => list)로 바꿔줌 readValue
	
	@Test
	void readTest() throws JsonMappingException, JsonProcessingException { 
		String str = "{\"firstName\":\"min\",\"dept\":10,\"hobby\":[\"reading\",\"game\"]}";
		ObjectMapper om = new ObjectMapper();
		//HashMap<String, Object> map = om.readValue(str, HashMap.class);
		MemberVO vo = om.readValue(str, MemberVO.class);
		System.out.println(vo);
	}
	
	
}
