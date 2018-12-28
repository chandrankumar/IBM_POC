package com.ibm.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class StudentRelationshipId implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 8148391147212648586L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Parent parent;

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
     * @return the parent
     */
    public Parent getParent() {
	return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(Parent parent) {
	this.parent = parent;
    }

}
