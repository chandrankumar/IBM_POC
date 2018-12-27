package com.ibm.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "student", schema = "ibm")
public class Student implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -8668846147749956033L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDT_SEQ")
    @SequenceGenerator(name = "STUDT_SEQ", sequenceName = "STUDENT_SEQ", allocationSize = 1)
    @Column(name = "stud_id")
    private int studentId;

    @Column(name = "stud_name")
    private String studentName;

    @Column(name = "stud_roll")
    private String studentRollNumber;

    @OneToMany(mappedBy="student", cascade=CascadeType.ALL)
    private List<Subject> subject;

    /**
     * @return the studentId
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    /**
     * @return the studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @param studentName the studentName to set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * @return the studentRollNumber
     */
    public String getStudentRollNumber() {
        return studentRollNumber;
    }

    /**
     * @param studentRollNumber the studentRollNumber to set
     */
    public void setStudentRollNumber(String studentRollNumber) {
        this.studentRollNumber = studentRollNumber;
    }

    /**
     * @return the subject
     */
    public List<Subject> getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(List<Subject> subject) {
        this.subject = subject;
    }

    
  
}
