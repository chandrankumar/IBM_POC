package com.ibm.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "student", schema = "std")
public class Student implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -8668846147749956033L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDT_SEQ")
    @SequenceGenerator(name = "STUDT_SEQ", sequenceName = "STUDENT_SEQ", allocationSize = 1)
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "gender")
    private String gender;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "contact_number")
    private String contactNumber;

    @OneToMany(mappedBy = "studentRelationshipId.student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StudentRelationship> studentRelationship;

    @OneToMany(mappedBy = "studentRegistrationId.student", cascade = CascadeType.ALL)
    private List<Registration> registration;

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

    /**
     * @return the studentRelationship
     */
    public List<StudentRelationship> getStudentRelationship() {
	return studentRelationship;
    }

    /**
     * @param studentRelationship the studentRelationship to set
     */
    public void setStudentRelationship(List<StudentRelationship> studentRelationship) {
	this.studentRelationship = studentRelationship;
    }

    /**
     * @return the registration
     */
    public List<Registration> getRegistration() {
	return registration;
    }

    /**
     * @param registration the registration to set
     */
    public void setRegistration(List<Registration> registration) {
	this.registration = registration;
    }

}
