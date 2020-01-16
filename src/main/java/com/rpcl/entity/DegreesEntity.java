package com.rpcl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "DEGREES_MASTER")
public class DegreesEntity {
	@Id
	@Column(name = "DEGREE_ID",length = 10)
	private Integer degreeId;
	@Column(name = "DEGREE_NAME",length = 20)
	private String degreeName;

}
