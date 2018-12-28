package com.ibm.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_relationship", schema = "std")
public class StudentRelationship implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3642548914951660877L;

    @EmbeddedId
    private StudentRelationshipId studentRelationshipId;

    public StudentRelationshipId studentInstance() {
	
	if(studentRelationshipId == null) {
	    studentRelationshipId  = new StudentRelationshipId();
	}
	return studentRelationshipId;
    }

    @ManyToOne
    @JoinColumn(name = "relation_type_id")
    private RelationshipType relationsshipType;

    /**
     * @return the studentRelationshipId
     */
    public StudentRelationshipId getStudentRelationshipId() {
	return studentRelationshipId;
    }

    /**
     * @param studentRelationshipId the studentRelationshipId to set
     */
    public void setStudentRelationshipId(StudentRelationshipId studentRelationshipId) {
	this.studentRelationshipId = studentRelationshipId;
    }

    /**
     * @return the relationsshipType
     */
    public RelationshipType getRelationsshipType() {
	return relationsshipType;
    }

    /**
     * @param relationsshipType the relationsshipType to set
     */
    public void setRelationsshipType(RelationshipType relationsshipType) {
	this.relationsshipType = relationsshipType;
    }

}
