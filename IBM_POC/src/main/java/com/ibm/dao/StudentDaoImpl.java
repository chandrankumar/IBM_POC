package com.ibm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.ibm.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao{

	@Autowired
	EntityManager entityManager;
	
	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;
	
	@Override
	@Transactional
	public Integer saveStudentDetail(Student student) {

		entityManager.merge(student);
		entityManager.flush();
		return student.getStudentId();
	}

	@Override
	@Transactional
	public List<Student> retrieveStudentDetails() {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
		Root<Student> root = criteriaQuery.from(Student.class);
		criteriaQuery.select(root);
		TypedQuery<Student> query = entityManager.createQuery(criteriaQuery);
		List<Student> resultList = query.getResultList();
		
		redisTemplate.opsForValue().set("studentDtl", resultList);
		return resultList;
	}

	
}
