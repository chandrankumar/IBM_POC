package com.ibm.vo;

import java.util.List;

import org.dozer.Mapping;

public class ParentVO {

    private int studentId;

    private int parentId;

    private String name;

    private String gender;

    private String contactNumber;

    @Mapping("address")
    private List<AddressVO> addressVO;

    private RelationshipVO relationshipVO;
    
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
     * @return the addressVO
     */
    public List<AddressVO> getAddressVO() {
	return addressVO;
    }

    /**
     * @param addressVO the addressVO to set
     */
    public void setAddressVO(List<AddressVO> addressVO) {
	this.addressVO = addressVO;
    }

    /**
     * @return the relationshipVO
     */
    public RelationshipVO getRelationshipVO() {
	return relationshipVO;
    }

    /**
     * @param relationshipVO the relationshipVO to set
     */
    public void setRelationshipVO(RelationshipVO relationshipVO) {
	this.relationshipVO = relationshipVO;
    }

}
