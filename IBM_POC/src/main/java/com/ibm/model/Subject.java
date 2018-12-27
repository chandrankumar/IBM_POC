package com.ibm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "subject", schema = "ibm")
public class Subject implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -6817690426911158574L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUB_SEQ")
    @SequenceGenerator(name = "SUB_SEQ", sequenceName = "SUBJECT_SEQ", allocationSize = 1)
    @Column(name = "sub_id")
    private int subjectId;

    @Column(name = "english")
    private String english;

    @Column(name = "maths")
    private String maths;

    @Column(name = "science")
    private String science;

    @Column(name = "tamil")
    private String tamil;

    @ManyToOne
    @JoinColumn(name = "stud_id")
    private Student student;

    /**
     * @return the subjectId
     */
    public int getSubjectId() {
	return subjectId;
    }

    /**
     * @param subjectId the subjectId to set
     */
    public void setSubjectId(int subjectId) {
	this.subjectId = subjectId;
    }

    /**
     * @return the english
     */
    public String getEnglish() {
	return english;
    }

    /**
     * @param english the english to set
     */
    public void setEnglish(String english) {
	this.english = english;
    }

    /**
     * @return the maths
     */
    public String getMaths() {
	return maths;
    }

    /**
     * @param maths the maths to set
     */
    public void setMaths(String maths) {
	this.maths = maths;
    }

    /**
     * @return the science
     */
    public String getScience() {
	return science;
    }

    /**
     * @param science the science to set
     */
    public void setScience(String science) {
	this.science = science;
    }

    /**
     * @return the tamil
     */
    public String getTamil() {
	return tamil;
    }

    /**
     * @param tamil the tamil to set
     */
    public void setTamil(String tamil) {
	this.tamil = tamil;
    }

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

}
