package com.ibm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "classes", schema = "std")
public class Department implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -6817690426911158574L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLASS_SEQ")
    @SequenceGenerator(name = "CLASS_SEQ", sequenceName = "CLASS_SEQ", allocationSize = 1)
    @Column(name = "class_id")
    private int departmentId;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "section")
    private String section;

    /**
     * @return the departmentId
     */
    public int getDepartmentId() {
	return departmentId;
    }

    /**
     * @param departmentId the departmentId to set
     */
    public void setDepartmentId(int departmentId) {
	this.departmentId = departmentId;
    }

    /**
     * @return the departmentName
     */
    public String getDepartmentName() {
	return departmentName;
    }

    /**
     * @param departmentName the departmentName to set
     */
    public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
    }

    /**
     * @return the section
     */
    public String getSection() {
	return section;
    }

    /**
     * @param section the section to set
     */
    public void setSection(String section) {
	this.section = section;
    }

}
