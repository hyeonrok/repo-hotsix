package com.hotsix.infra.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CompanyController {
	
	@Autowired
	CompanyService service;
	
	@RequestMapping(value="companyXdmList")
	public String companyXdmList(@ModelAttribute("vo") CompanyVo vo,Model model) throws Exception{
		
		model.addAttribute("list", service.selectList(vo));
		
		return "/adm/infra/company/companyXdmList";
	}
}
