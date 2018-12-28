package com.ibm.service;

import java.util.List;

import com.ibm.vo.DepartmentVO;
import com.ibm.vo.ParentVO;
import com.ibm.vo.RegistrationVO;
import com.ibm.vo.RelationshipVO;
import com.ibm.vo.StudentVO;

public interface StudentService {

    public Integer saveStudentDetail(StudentVO studentVO);

    public List<StudentVO> retrieveStudentDetails();

    public Integer saveParentsDetails(ParentVO parentVO);

    public List<RelationshipVO> retrieveRelationType();

    public Integer mapStudentRegistration(RegistrationVO registrationVO);

    public List<DepartmentVO> retrieveDepartmentDetails();

}
