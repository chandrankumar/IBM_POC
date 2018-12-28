package com.ibm.dao;

import java.util.List;

import com.ibm.model.Department;
import com.ibm.model.Parent;
import com.ibm.model.Registration;
import com.ibm.model.RelationshipType;
import com.ibm.model.Student;

public interface StudentDao {

    public Integer saveStudentDetail(Student student);

    public List<Student> retrieveStudentDetails();

    public List<RelationshipType> retrieveRelationType();

    public Integer saveParentsDetails(Parent parent);

    public List<Department> retrieveDepartmentDetails();

    public Integer saveMappedStudent(Registration registration);

}
