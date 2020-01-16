package com.rpcl.service;

import java.util.List;

import com.rpcl.domain.EducationalDetails;
import com.rpcl.domain.PassportAppDtls;
import com.rpcl.domain.PersonDetails;

public interface PassportApplicationMgmtService {
	public PersonDetails savePersonDetails(PersonDetails personDetails);
	public List<String> fetchDegrees();
	public List<String> fetchUniversities();
	public List<Integer> fetchYears();
	public PersonDetails fetchPersonById(Integer pid);
	public EducationalDetails saveEduDetails(EducationalDetails educationalDetails);
	public EducationalDetails fetchEduDtlsByEduId(Integer eduId);
	public PassportAppDtls savePassportDetailsWithPassportNumber(PassportAppDtls passportAppDtls);
}
