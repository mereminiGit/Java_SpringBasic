package com.yedam.app.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;

// 필드를 기반으로 생성자 만들 수 있는 어노테이션
@AllArgsConstructor
@Getter
public class LoginUserVO implements UserDetails {
	//	시큐리티는 userDetails만 인식하기 때문에 VO에 인터페이넣어줘야함
	// 인증된 데이터를 들고 있기 때문에 read만 되게 하고 
	
	private UserVO userVO;
	// 아작스에서 UserDetails vo를 하면 불필요한 것들이 많아서 UserVO 일반 통신할 VO만든다
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auths = new ArrayList<>();
		auths.add(new SimpleGrantedAuthority(userVO.getRole()));
		return auths;
	}
//	Collection 리스트 인터페이스의 상위 extends GrantedAuthority만 상속 

	@Override
	public String getPassword() {
		return userVO.getPwd();
	}

	@Override
	public String getUsername() {
		return userVO.getId();
	}

	@Override
	public boolean isAccountNonExpired() { // 계정 만료여부
		return true;
	}

	@Override
	public boolean isAccountNonLocked() { // 계정 잠금여부
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() { // 계정 패스워드 만료여부(1년마다 비밀번호 바꿔라 같은)
		return true;
	}

	@Override
	public boolean isEnabled() { // 계정 사용가능 여부
		return true;
	}

}
