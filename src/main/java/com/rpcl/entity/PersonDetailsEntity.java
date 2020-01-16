package com.rpcl.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
@Data
@Entity
@Table(name = "PERSON_DETAILS")
public class PersonDetailsEntity {
	@Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
      name = "sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "PERSON_ID_SEQUENCE"),
        @Parameter(name = "initial_value", value = "1001"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	@Column(name = "PERSON_ID",length = 10)
	private Integer personId;
	
	@Column(name = "FIRST_NAME",length = 20)
	private String firstName;
	
	@Column(name = "LAST_NAME",length = 20)
	private String lastName;
	
	@Column(name = "EMAIL",length = 30)
	private String email;
	
	@Column(name = "GENDER",length = 10)
	private String gender;
	
	@Column(name = "DOB")
	private Date dob;
	
	@Column(name = "CREATED_DATE",nullable = false, updatable = false)
	@CreationTimestamp
	private Date createdDate;
	
	@Column(name = "UPDATED_DATE")
	@UpdateTimestamp
	private Date updatedDate;
}
