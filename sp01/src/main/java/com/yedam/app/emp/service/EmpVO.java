package com.yedam.app.emp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmpVO {
//	private String employee_id;
//	private String first_name;
//	private String last_name;
//	private String email;
//	private String hire_date;
//	private String job_id;
//	private String department_id;
//	private String salary;
	
	// 1) 컬럼따라 타입을 구분하거나 or 실제 타입 대신 String 사용
	// 2) 기본타입(int, double 등) 사용 or Wrap 클래스(Integer, Double 등) 사용하거나
	
	// VO클래스에서는 가능하면 wrapper class	
	
	private int employeeId;	
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
//	여기에서 날짜 처리 서버에서 날짜 처리 해주는것
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hireDate;
	private String jobId;
	private double salary;
	private Double commissionPct;
	private Integer managerId;
	private Integer departmentId;
	
//	private int empCount;	-> 마이바티스는 알리아스와 같으면 불러올 수 있음
}
