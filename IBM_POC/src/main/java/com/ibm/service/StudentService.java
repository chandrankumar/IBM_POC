package com.ibm.service;

import java.util.List;

import com.ibm.vo.StudentVO;

public interface StudentService {

	public Integer saveStudentDetail(StudentVO studentVO);

	public List<StudentVO> retrieveStudentDetails();
	
}
