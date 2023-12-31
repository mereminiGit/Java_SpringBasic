package com.yedam.java.book.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	
	// 도서목록조회
	@GetMapping("bookList")
	public String getBookList(Model model) {
		model.addAttribute("bookList", bookService.getBookList());
		return "book/bookList";
	}
	
	// 도서정보등록  페이지
	@GetMapping("bookInsert")
	public String insertBookInfoFrom(Model model) {
		List<BookVO> books = bookService.getBookList();
		
		System.out.println(books.get(books.size() - 1).getBookNo());
		
		model.addAttribute("no", books.get(books.size() - 1).getBookNo() + 1);
		return "book/bookInsert";
	}
	
	// 도서정보등록  처리
	@PostMapping("bookInsert")
	public String insertBookInfoProcess(BookVO vo) {
		bookService.insertBook(vo);
		return "redirect:bookList";
	}
	
	// 도서대여현황
	@GetMapping("bookRentList")
	public String getBookRentList(Model model) {
		model.addAttribute("rentList", bookService.getBookRentList());
		return "book/bookRentList";
	}
}
