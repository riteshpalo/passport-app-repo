package com.rpcl.domain;

import java.sql.Date;


import lombok.Data;
@Data
public class PersonDetails {
	private Integer personId;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private Date dob;
	

}
