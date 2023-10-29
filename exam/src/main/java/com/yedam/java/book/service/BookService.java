package com.yedam.java.book.service;

import java.util.List;

public interface BookService {
	// 전체조회
	public List<BookVO> getBookList();
	
	// 단건조회
	public BookVO getBook(BookVO vo);
	
	// 등록
	public int insertBook(BookVO vo);
	
	// 대여현황 조회
	public List<BookRentVO> getBookRentList();
}
