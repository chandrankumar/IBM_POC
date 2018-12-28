package com.ibm.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class StudentRegistrationId implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7161831430205363471L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    private Department department;

    /**
     * @return the student
     */
    public Student getStudent() {
	return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(Student student) {
	this.student = student;
    }

    /**
     * @return the department
     */
    public Department getDepartment() {
	return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(Department department) {
	this.department = department;
    }

}
