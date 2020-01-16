package com.rpcl.service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpcl.domain.EducationalDetails;
import com.rpcl.domain.PassportAppDtls;
import com.rpcl.domain.PersonDetails;
import com.rpcl.entity.EducationalDetailsEntity;
import com.rpcl.entity.PassportAppDtlsEntity;
import com.rpcl.entity.PersonDetailsEntity;
import com.rpcl.repository.DegreesRepository;
import com.rpcl.repository.EducationalDetailsRepository;
import com.rpcl.repository.PassportAppDetailsRepository;
import com.rpcl.repository.PersonDetailsRepository;
import com.rpcl.repository.UniversitiesRepository;
import com.rpcl.repository.YearsRepository;
@Service
public class PassportApplicationMgmtServiceImpl implements PassportApplicationMgmtService {
	
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static SecureRandom rnd = new SecureRandom();
	

	@Autowired
	private PersonDetailsRepository personDtlsRepo;
	
	@Autowired
	private DegreesRepository degreesRepo;
	
	@Autowired
	private UniversitiesRepository univRepo;
	
	@Autowired
	private YearsRepository yearsRepo;
	
	@Autowired
	private EducationalDetailsRepository eduDtlsRepo;
	
	@Autowired
	private PassportAppDetailsRepository passAppRepo;
	
	@Override
	public PersonDetails savePersonDetails(PersonDetails personDetails) {
		PersonDetailsEntity entity=new PersonDetailsEntity();
		BeanUtils.copyProperties(personDetails, entity);
		entity = personDtlsRepo.save(entity);
		BeanUtils.copyProperties(entity, personDetails);
		return personDetails;
	}

	@Override
	public List<String> fetchDegrees() {
		return degreesRepo.getDegrees();
	}

	@Override
	public List<String> fetchUniversities() {
		return univRepo.getUniversities();
	}

	@Override
	public List<Integer> fetchYears() {
		return yearsRepo.getYears();
	}

	@Override
	public PersonDetails fetchPersonById(Integer pid) {
		Optional<PersonDetailsEntity> optional = personDtlsRepo.findById(pid);
		PersonDetails personDetails=new PersonDetails();
		if(optional.isPresent()) {
			PersonDetailsEntity entity = optional.get();
			BeanUtils.copyProperties(entity, personDetails);
		}
		return personDetails;
	}

	@Override
	public EducationalDetails saveEduDetails(EducationalDetails educationalDetails) {
		EducationalDetailsEntity entity=new EducationalDetailsEntity();
		BeanUtils.copyProperties(educationalDetails, entity);
		PersonDetailsEntity personDetailsEntity=new PersonDetailsEntity();
		personDetailsEntity.setPersonId(educationalDetails.getPersonId());
		entity.setPersonEntity(personDetailsEntity);
		entity = eduDtlsRepo.save(entity);
		if(entity!=null) {
			BeanUtils.copyProperties(entity,educationalDetails);
			educationalDetails.setPersonId(entity.getPersonEntity().getPersonId());
		}
		return educationalDetails;
	}

	@Override
	public EducationalDetails fetchEduDtlsByEduId(Integer eduId) {
		Optional<EducationalDetailsEntity> optional = eduDtlsRepo.findById(eduId);
		EducationalDetails educationalDetails=new EducationalDetails();
		if(optional.isPresent()) {
			EducationalDetailsEntity entity = optional.get();
			BeanUtils.copyProperties(entity, educationalDetails);
			educationalDetails.setPersonId(entity.getPersonEntity().getPersonId());
		}
		return educationalDetails;
	}

	@Override
	public PassportAppDtls savePassportDetailsWithPassportNumber(PassportAppDtls passportAppDtls) {
		passportAppDtls.setPassportNumber(generateRandomPassword(8));
		PassportAppDtlsEntity entity=new PassportAppDtlsEntity();
		BeanUtils.copyProperties(passportAppDtls, entity);
		PersonDetailsEntity personDetailsEntity=new PersonDetailsEntity();
		personDetailsEntity.setPersonId(passportAppDtls.getPersonId());
		entity.setPersonEntity(personDetailsEntity);
		entity = passAppRepo.save(entity); 
		if(entity!=null) {
			BeanUtils.copyProperties(entity,passportAppDtls);
			passportAppDtls.setPersonId(entity.getPersonEntity().getPersonId());
		}
		return passportAppDtls;
	}
	
	private String generateRandomPassword(int len){
		StringBuilder sb = new StringBuilder( len );
		for( int i = 0; i < len; i++ ) 
			sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		return sb.toString();
	}

}
