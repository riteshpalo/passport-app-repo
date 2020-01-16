package com.rpcl.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rpcl.domain.PassportAppDtls;
import com.rpcl.service.PassportApplicationMgmtService;

@Controller
public class ApplicationReviewController {
	
	@Autowired
	private PassportApplicationMgmtService passAppService;

	@RequestMapping(value = "/showReviewForm")
	public String showApplicationReviewForm(Model model,HttpServletRequest request) {
		PassportAppDtls passportAppDtls=new PassportAppDtls();
		String personId= request.getParameter("personId");
		if(personId!=null && !personId.isEmpty()) {
			int pid = Integer.parseInt(personId);
			passportAppDtls.setPersonId(pid);
		}
		model.addAttribute("passportAppDtls", passportAppDtls);
		return "applicationReviewForm";
	}
	
	@RequestMapping(value="/handleConfirmBtn",method =RequestMethod.POST)
	public String handleConfirmBtn(@ModelAttribute("passportAppDtls") PassportAppDtls passportAppDtls ,RedirectAttributes attributes) {
		passportAppDtls = passAppService.savePassportDetailsWithPassportNumber(passportAppDtls);
		if(passportAppDtls!=null) {
			attributes.addFlashAttribute("successMsg", "Your Passport Number Generated Successfully");
			attributes.addFlashAttribute("passportNumber", passportAppDtls.getPassportNumber());
		}else {
			attributes.addFlashAttribute("errorMsg", "Your Passport Number Generation Failed");
		}
		
		return "redirect:/passportDashBoard";
	}
	
	@RequestMapping(value = "/passportDashBoard")
	public String enterIntoPassportDashBoard() {
		return "passportDashBoard";
	}
}
