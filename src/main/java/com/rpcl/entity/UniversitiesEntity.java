package com.rpcl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "UNIVERSITIES_MASTER")
public class UniversitiesEntity {
	@Id
	@Column(name = "UNIV_ID",length = 10)
	private Integer univId;
	@Column(name = "UNIV_NAME",length = 20)
	private String univName;

}
