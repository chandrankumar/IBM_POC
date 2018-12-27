package com.ibm.vo;

import java.util.List;

import org.dozer.Mapping;

public class StudentVO{

    private int studentId;

    private String studentName;

    private String studentRollNumber;

    @Mapping("subject")
    private List<SubjectVO> subjectVO;

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
     * @return the subjectVO
     */
    public List<SubjectVO> getSubjectVO() {
	return subjectVO;
    }

    /**
     * @param subjectVO the subjectVO to set
     */
    public void setSubjectVO(List<SubjectVO> subjectVO) {
	this.subjectVO = subjectVO;
    }

}
