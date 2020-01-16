package com.rpcl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rpcl.domain.EducationalDetails;
import com.rpcl.domain.PersonDetails;
import com.rpcl.service.PassportApplicationMgmtService;

@Controller
public class EducationalDetailsController {

	@Autowired
	private PassportApplicationMgmtService passportAppService;

	@RequestMapping("/showEduDetails")
	public String showEducationDtls(Model model,HttpServletRequest request) {
		EducationalDetails educationalDetails=new EducationalDetails();
		String personId = request.getParameter("personId");
		if(personId!=null && !personId.isEmpty()) {
			int pid = Integer.parseInt(personId);
			educationalDetails.setPersonId(pid);
		}
		model.addAttribute("educationalDetails", educationalDetails);
		List<String> degreesList = passportAppService.fetchDegrees();
		List<String> universitiesList = passportAppService.fetchUniversities();
		List<Integer> yearsList = passportAppService.fetchYears();
		model.addAttribute("degrees", degreesList);
		model.addAttribute("universities", universitiesList);
		model.addAttribute("years", yearsList);
		return "eduDetailsForm";
		
	}
	
	@RequestMapping(value="/handleEduNextBtn",method=RequestMethod.POST)
	public String handleNextBtn(@ModelAttribute("educationalDetails") EducationalDetails educationalDetails,RedirectAttributes attributes) {
		educationalDetails = passportAppService.saveEduDetails(educationalDetails);
		if(educationalDetails!=null) {
			PersonDetails personDetails = passportAppService.fetchPersonById(educationalDetails.getPersonId());
			educationalDetails = passportAppService.fetchEduDtlsByEduId(educationalDetails.getEduId());
			attributes.addFlashAttribute("personDetails", personDetails);
			attributes.addFlashAttribute("educationalDetails", educationalDetails);
		}
		return "redirect:/showReviewForm?personId="+educationalDetails.getPersonId();
	}
	
	
}
