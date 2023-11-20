package com.yedam.app.aop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.aop.mapper.AopMapper;
import com.yedam.app.aop.service.AopService;

@Service
public class AopServiceImpl implements AopService{
	
	@Autowired
	AopMapper aopMapper;
	
	// sql문을 전체 실행하고 커밋, 롤백할 때 Transactional를 붙이고 사용한다. (간단한 sql문을 하나의 트랜잭션으로 묶어서 사용할 때 사용)
	@Transactional
	@Override
	public void insert() {
		aopMapper.insertNumber("101");
		aopMapper.insertNumber("a101");
	}

}
