package com.yedam.java.book.mapper;

import java.util.List;

import com.yedam.java.book.service.BookRentVO;
import com.yedam.java.book.service.BookVO;

public interface BookMapper {
	// 전체조회
	public List<BookVO> selectBookList();

	// 단건조회
	public BookVO selectBook(BookVO vo);

	// 등록
	public int insertBook(BookVO vo);

	// 대여현황 조회
	public List<BookRentVO> selectBookRentList();
}
