package com.yedam.app.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 이 내부의 설정되어 있는 메소드를 기반으로 빈을 등록하겠다.라는 어노테이션
@Configuration
public class JasyptConfig {
	// 프로펄타이즈 + 환경변수를 불러옴
	@Value("${jasypt.encryptor.password}") // 환경변수 이름
	private String password;
	
	@Bean("jasyptStringEncryptor")	// ""이 이름이 세팅을 가지고 빈을 등록
	public StringEncryptor stringEncryptor() {	// StringEncryptor 리턴되는 타입 - 빈이
		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
		
		SimpleStringPBEConfig config = new SimpleStringPBEConfig();
		config.setPassword(password); // 패스워드가 핵심 -> 이걸 변수로 돌린다. 프로젝트 어디에서든 있으면 안 됨.
		config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
		config.setKeyObtentionIterations("1000");
		config.setPoolSize("1");
		config.setProviderName("SunJCE");
		config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
		config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
		config.setStringOutputType("base64");
		// 세팅하고나서 리턴해주면 
		encryptor.setConfig(config);
		return encryptor;
	}
}
