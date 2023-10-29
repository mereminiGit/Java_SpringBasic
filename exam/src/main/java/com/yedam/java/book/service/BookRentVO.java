package com.yedam.java.book.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BookRentVO {
	private Integer bookNo;
	private String bookName;
	private Integer rentTotal;
	private Integer rentCount;
//	private Integer bookNo;
//	private Integer rentPrice;
//	@DateTimeFormat(pattern = "yyyy/MM/dd")
//	private Date rentDate;
//	private char rentStatus;
}
