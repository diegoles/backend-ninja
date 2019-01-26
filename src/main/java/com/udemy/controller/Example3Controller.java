package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.model.Persona;

@Controller
@RequestMapping("/example3")
public class Example3Controller {
	
	public final static String FORM_VIEM = "Form";
	public final static String RESULT_VIEM = "Result";
	
	@GetMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("person", new Persona());
		//int i=6/0;    //para desplegar un mensaje de error
		return FORM_VIEM;
	}
	
	@PostMapping("/addPerson")
	public ModelAndView addPerson(@ModelAttribute("person") Persona person) {
		ModelAndView mav = new ModelAndView(RESULT_VIEM);
		mav.addObject("person", person);
		return mav;
	}
	
	// Primera forma de redireccion por defecto
//	@GetMapping("/")
//	public String redirect() {
//		return "redirect:/example3/showForm"; 
//	}
	
	// Segunda forma de redireccion por defecto
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/example3/showForm");
	}

}
