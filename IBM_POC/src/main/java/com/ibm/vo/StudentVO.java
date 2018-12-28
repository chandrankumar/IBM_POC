package com.ibm.vo;

public class StudentVO {

    private int studentId;

    private String gender;

    private String firstName;

    private String lastName;

    private String contactNumber;

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
     * @return the gender
     */
    public String getGender() {
	return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
	this.gender = gender;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
	return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
	return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    /**
     * @return the contactNumber
     */
    public String getContactNumber() {
	return contactNumber;
    }

    /**
     * @param contactNumber the contactNumber to set
     */
    public void setContactNumber(String contactNumber) {
	this.contactNumber = contactNumber;
    }

}
