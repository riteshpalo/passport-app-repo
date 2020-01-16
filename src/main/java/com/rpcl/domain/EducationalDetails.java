package com.rpcl.domain;

import lombok.Data;

@Data
public class EducationalDetails {
	private Integer eduId;
	private Integer passedYear; 
	private String university; 
	private String highestDegree;
	private Integer personId;
}
