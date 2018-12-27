package com.ibm.dao;

import java.util.List;

import com.ibm.model.Student;

public interface StudentDao {

	public Integer saveStudentDetail(Student student);

	public List<Student> retrieveStudentDetails();

}
