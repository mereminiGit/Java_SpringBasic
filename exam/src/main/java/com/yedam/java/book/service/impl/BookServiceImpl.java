package com.yedam.java.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.java.book.mapper.BookMapper;
import com.yedam.java.book.service.BookRentVO;
import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	BookMapper bookMapper;


//	전체조회
	@Override
	public List<BookVO> getBookList() {
		return bookMapper.selectBookList();
	}

//	단건조회	
	@Override
	public BookVO getBook(BookVO vo) {
		return bookMapper.selectBook(vo);
	}

//	등록
	@Override
	public int insertBook(BookVO vo) {
		int result = bookMapper.insertBook(vo);
		
		if (result == 1) {			
			return vo.getBookNo();
		} else {
			return -1;
		}
		
	}

//	대여현황조회
	@Override
	public List<BookRentVO> getBookRentList() {
		return bookMapper.selectBookRentList();
	}
	
	
}
