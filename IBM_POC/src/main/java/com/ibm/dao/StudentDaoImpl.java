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

import com.ibm.model.Department;
import com.ibm.model.Parent;
import com.ibm.model.Registration;
import com.ibm.model.RelationshipType;
import com.ibm.model.Student;
import com.ibm.model.StudentRegistrationId;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    EntityManager entityManager;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    @Transactional
    public Integer saveStudentDetail(Student student) {

	Student std = entityManager.merge(student);
	entityManager.flush();
	return std.getStudentId();
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

    @Override
    @Transactional
    public List<RelationshipType> retrieveRelationType() {

	CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	CriteriaQuery<RelationshipType> criteriaQuery = builder.createQuery(RelationshipType.class);
	Root<RelationshipType> root = criteriaQuery.from(RelationshipType.class);
	criteriaQuery.select(root);
	TypedQuery<RelationshipType> query = entityManager.createQuery(criteriaQuery);
	List<RelationshipType> resultList = query.getResultList();
	redisTemplate.opsForValue().set("relationTyp", resultList);
	return resultList;
    }

    @Override
    public Integer saveParentsDetails(Parent parent) {

	Parent parnt = entityManager.merge(parent);
	entityManager.flush();
	return parnt.getParentId();
    }

    @Override
    @Transactional
    public List<Department> retrieveDepartmentDetails() {

	CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	CriteriaQuery<Department> criteriaQuery = builder.createQuery(Department.class);
	Root<Department> root = criteriaQuery.from(Department.class);
	criteriaQuery.select(root);
	TypedQuery<Department> query = entityManager.createQuery(criteriaQuery);
	List<Department> resultList = query.getResultList();
	redisTemplate.opsForValue().set("department", resultList);
	return resultList;
    }

    @Override
    @Transactional
    public Integer saveMappedStudent(Registration registration) {

	Registration reg = entityManager.merge(registration);
	return reg.getStudentRegistrationId().getStudent().getStudentId();
    }

}
