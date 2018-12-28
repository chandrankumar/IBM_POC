package com.ibm.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.ibm.dao.StudentDao;
import com.ibm.model.Address;
import com.ibm.model.Department;
import com.ibm.model.Parent;
import com.ibm.model.Registration;
import com.ibm.model.RelationshipType;
import com.ibm.model.Student;
import com.ibm.model.StudentRelationship;
import com.ibm.util.StudentUtil;
import com.ibm.vo.DepartmentVO;
import com.ibm.vo.ParentVO;
import com.ibm.vo.RegistrationVO;
import com.ibm.vo.RelationshipVO;
import com.ibm.vo.StudentVO;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    Mapper mapper;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    @Transactional
    public Integer saveStudentDetail(StudentVO studentVO) {

	Student student = mapper.map(studentVO, Student.class);
	Integer studentId = studentDao.saveStudentDetail(student);
	return studentId;
    }

    @Override
    @Transactional
    public List<StudentVO> retrieveStudentDetails() {
	List<Student> studentDetails = studentDao.retrieveStudentDetails();

	List<Student> rightPop = (List<Student>) redisTemplate.opsForValue().get("studentDtl");
	System.out.println("Cached Data " + rightPop);
	List<StudentVO> studentVO = StudentUtil.mapperToList(mapper, studentDetails, StudentVO.class);
	// Collections.sort(studentVO);
	return studentVO;
    }

    @Override
    @Transactional
    public List<RelationshipVO> retrieveRelationType() {
	List<RelationshipType> relationship = studentDao.retrieveRelationType();
	List<RelationshipVO> relationshipVO = StudentUtil.mapperToList(mapper, relationship, RelationshipVO.class);
	return relationshipVO;
    }

    @Override
    @Transactional
    public Integer saveParentsDetails(ParentVO parentVO) {

	Parent parent = mapper.map(parentVO, Parent.class);
	for (Address address : parent.getAddress()) {
	    address.setParent(parent);
	}
	Integer savedParentId = studentDao.saveParentsDetails(parent);
	Student student = new Student();
	parent.setParentId(savedParentId);
	student.setStudentId(parentVO.getStudentId());
	RelationshipType relationship = mapper.map(parentVO.getRelationshipVO(), RelationshipType.class);
	StudentRelationship studentRelationships = new StudentRelationship();
	studentRelationships.studentInstance().setParent(parent);
	studentRelationships.studentInstance().setStudent(student);
	studentRelationships.setRelationsshipType(relationship);
	parent.setStudentRelationships(studentRelationships);
	Integer parentId = studentDao.saveParentsDetails(parent);
	return parentId;
    }

    @Override
    @Transactional
    public List<DepartmentVO> retrieveDepartmentDetails() {
	List<Department> department = studentDao.retrieveDepartmentDetails();
	List<DepartmentVO> departmentVO = StudentUtil.mapperToList(mapper, department, DepartmentVO.class);
	return departmentVO;
    }

    @Override
    @Transactional
    public Integer mapStudentRegistration(RegistrationVO registrationVO) {

	Registration registration = new Registration();
	Student student = new Student();
	student.setStudentId(registrationVO.getStudentId());
	Department department = new Department();
	department.setDepartmentId(registrationVO.getDepartmentId());
	registration.registerInstance().setStudent(student);
	registration.registerInstance().setDepartment(department);
	registration.setDateOfRegistration(new Date());

	return studentDao.saveMappedStudent(registration);
    }

}
