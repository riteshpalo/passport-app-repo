package com.rpcl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "YEARS_MASTER")
public class YearsEntity {
	@Id
	@Column(name = "YEAR_ID",length = 10)
	private Integer yearId;
	@Column(name = "YEAR",length = 5)
	private Integer year;

}
