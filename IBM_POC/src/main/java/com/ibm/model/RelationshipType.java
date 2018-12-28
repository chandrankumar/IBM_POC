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
@Table(name = "relation_type", schema = "std")
public class RelationshipType implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -6394767594932405849L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RELATION_TYPE_SEQ")
    @SequenceGenerator(name = "RELATION_TYPE_SEQ", sequenceName = "RELATION_TYPE_SEQ", allocationSize = 1)
    @Column(name = "relation_type_id")
    private int relationshipId;

    @Column(name = "relation_type")
    private String relationshipType;

    @OneToMany(mappedBy = "relationsshipType", cascade = CascadeType.ALL)
    private List<StudentRelationship> studentRelationship;

    /**
     * @return the relationshipId
     */
    public int getRelationshipId() {
	return relationshipId;
    }

    /**
     * @param relationshipId the relationshipId to set
     */
    public void setRelationshipId(int relationshipId) {
	this.relationshipId = relationshipId;
    }

    /**
     * @return the relationshipType
     */
    public String getRelationshipType() {
	return relationshipType;
    }

    /**
     * @param relationshipType the relationshipType to set
     */
    public void setRelationshipType(String relationshipType) {
	this.relationshipType = relationshipType;
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

}
