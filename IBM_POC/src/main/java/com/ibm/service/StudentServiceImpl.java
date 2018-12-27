package com.ibm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.ibm.dao.StudentDao;
import com.ibm.model.Student;
import com.ibm.model.Subject;
import com.ibm.util.StudentUtil;
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
		for (Subject subject : student.getSubject()) {
		    subject.setStudent(student);
		}
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
		//Collections.sort(studentVO);
		return studentVO;
	}

}
