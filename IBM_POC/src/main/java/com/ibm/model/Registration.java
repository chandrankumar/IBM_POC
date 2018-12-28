package com.ibm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "registration", schema = "std")
public class Registration implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 31673589655529432L;

    @EmbeddedId
    private StudentRegistrationId studentRegistrationId = new StudentRegistrationId();

    public StudentRegistrationId registerInstance() {

	if (studentRegistrationId == null) {
	    studentRegistrationId = new StudentRegistrationId();
	}
	return studentRegistrationId;
    }

    @Column(name = "date_of_reg")
    private Date dateOfRegistration;

    /**
     * @return the studentRegistrationId
     */
    public StudentRegistrationId getStudentRegistrationId() {
	return studentRegistrationId;
    }

    /**
     * @param studentRegistrationId the studentRegistrationId to set
     */
    public void setStudentRegistrationId(StudentRegistrationId studentRegistrationId) {
	this.studentRegistrationId = studentRegistrationId;
    }

    /**
     * @return the dateOfRegistration
     */
    public Date getDateOfRegistration() {
	return dateOfRegistration;
    }

    /**
     * @param dateOfRegistration the dateOfRegistration to set
     */
    public void setDateOfRegistration(Date dateOfRegistration) {
	this.dateOfRegistration = dateOfRegistration;
    }

}
