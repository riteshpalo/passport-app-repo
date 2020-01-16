package com.rpcl.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "EDU_DETAILS")
public class EducationalDetailsEntity {
	@Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
      name = "sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "EDU_ID_SEQUENCE"),
        @Parameter(name = "initial_value", value = "555"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	@Column(name = "EDU_ID",length = 10)
	private Integer eduId;
	
	@Column(name = "PASSED_YEAR",length = 5)
	private Integer passedYear; 
	
	@Column(name = "UNIVERSITY",length = 20)
	private String university; 
	
	@Column(name = "HIGHEST_DEGREE",length = 20)
	private String highestDegree;
	
	@OneToOne
	@JoinColumn(name = "PERSON_ID")
	private PersonDetailsEntity personEntity;
	
	@Column(name = "CREATED_DATE",nullable = false, updatable = false)
	@CreationTimestamp
	private Date createdDate;
	
	@Column(name = "UPDATED_DATE")
	@UpdateTimestamp
	private Date updatedDate;
}
