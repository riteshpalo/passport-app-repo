package com.rpcl.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rpcl.domain.PersonDetails;
import com.rpcl.service.PassportApplicationMgmtService;

@Controller
public class PersonDetailsController {
	@Autowired
	private PassportApplicationMgmtService passportAppService;
	
	@RequestMapping("/")
	public String showPersonDetailsForm(Model model,HttpServletRequest request) {
		PersonDetails personDetails=new PersonDetails();
		String personId = request.getParameter("personId");
		if(personId!=null && !personId.isEmpty()) {
			int pid = Integer.parseInt(personId);
			personDetails.setPersonId(pid);
			personDetails = passportAppService.fetchPersonById(pid);
		}
		model.addAttribute("personDetails", personDetails);
		return "personDetailsForm";
	}
	
	@RequestMapping(value="/handleNextBtn",method = RequestMethod.POST)
	public String handleNextBtn(@ModelAttribute("personDetails") PersonDetails personDetails,RedirectAttributes attributes) {
		personDetails = passportAppService.savePersonDetails(personDetails);
		attributes.addFlashAttribute("pid", personDetails.getPersonId());
		return "redirect:/showEduDetails?personId="+personDetails.getPersonId();
	}

}
