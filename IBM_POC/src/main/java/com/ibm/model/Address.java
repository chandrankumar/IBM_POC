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
@Table(name = "address", schema = "std")
public class Address implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1699399791423168632L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRS_SEQ")
    @SequenceGenerator(name = "ADDRS_SEQ", sequenceName = "ADDRESS_SEQ", allocationSize = 1)
    @Column(name = "address_id")
    private int addressId;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "pincode")
    private String pincode;

    @Column(name = "street_name")
    private String streetName;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    /**
     * @return the addressId
     */
    public int getAddressId() {
	return addressId;
    }

    /**
     * @param addressId the addressId to set
     */
    public void setAddressId(int addressId) {
	this.addressId = addressId;
    }

    /**
     * @return the country
     */
    public String getCountry() {
	return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
	this.country = country;
    }

    /**
     * @return the state
     */
    public String getState() {
	return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
	this.state = state;
    }

    /**
     * @return the city
     */
    public String getCity() {
	return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
	this.city = city;
    }

    /**
     * @return the pincode
     */
    public String getPincode() {
	return pincode;
    }

    /**
     * @param pincode the pincode to set
     */
    public void setPincode(String pincode) {
	this.pincode = pincode;
    }

    /**
     * @return the streetName
     */
    public String getStreetName() {
	return streetName;
    }

    /**
     * @param streetName the streetName to set
     */
    public void setStreetName(String streetName) {
	this.streetName = streetName;
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
