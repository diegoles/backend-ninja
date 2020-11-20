package com.udemy.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.constant.ViewConstant;
import com.udemy.model.Persona;

@Controller
@RequestMapping("/example3")
public class Example3Controller {

	private final static Log LOG = LogFactory.getLog(Example3Controller.class);

	@GetMapping("/showForm")
	public String showForm(Model model) {
		LOG.info("INFO TRACE");
		LOG.warn("WARNING TRACE");
		LOG.error("ERROR TRACE");
		LOG.debug("DEBUG TRACE");
		model.addAttribute("person", new Persona());
		//int i=6/0; //para desplegar un mensaje de error
		return ViewConstant.FORM;
	}

	@PostMapping("/addPerson")
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Persona person, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView();
		if (bindingResult.hasErrors()) {
			mav.setViewName(ViewConstant.FORM);
		} else {
			LOG.info("METHOD: 'addPerson' --- PARAMS:' " + person + "'");
			mav.setViewName(ViewConstant.RESULT);
			mav.addObject("person", person);
			LOG.info("TEMPLATE: '" + ViewConstant.RESULT + "' -- DATA: '" + person + "'");
		}

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
