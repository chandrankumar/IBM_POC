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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "parents", schema = "std")
public class Parent implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1841739997629545876L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PARENTS_SEQ")
    @SequenceGenerator(name = "PARENTS_SEQ", sequenceName = "PARENTS_SEQ", allocationSize = 1)
    @Column(name = "parent_id")
    private int parentId;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "contact_num")
    private String contactNumber;

    @OneToOne(mappedBy = "studentRelationshipId.parent", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private StudentRelationship studentRelationships;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Address> address;

    /**
     * @return the parentId
     */
    public int getParentId() {
	return parentId;
    }

    /**
     * @param parentId the parentId to set
     */
    public void setParentId(int parentId) {
	this.parentId = parentId;
    }

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
	this.name = name;
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
     * @return the studentRelationships
     */
    public StudentRelationship getStudentRelationships() {
	return studentRelationships;
    }

    /**
     * @param studentRelationships the studentRelationships to set
     */
    public void setStudentRelationships(StudentRelationship studentRelationships) {
	this.studentRelationships = studentRelationships;
    }

    /**
     * @return the address
     */
    public List<Address> getAddress() {
	return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(List<Address> address) {
	this.address = address;
    }

}
