package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("example/")
public class ExampleController {
	
	public final static String EXAMPLE_VIEW = "Example";
	public final static String EXAMPLE_DATA_VIEW = "ExampleData";//Nombre de html sin la extension
	
	// Primera forma     (solo para devolver la vista o insert muy pocos datos)
	
	@GetMapping("exampleString")
	//@RequestMapping(value="exampleString", method=RequestMethod.GET)
	public String exampleString() {
		return EXAMPLE_VIEW;
	}
	
	// Segunda forma   (para muchos datos)
	
	@GetMapping("exampleMAV")
	//@RequestMapping(value="exampleMAV", method=RequestMethod.GET)     		********se reemplaza por @GetMapping
	public ModelAndView exampleMAV() {
		return new ModelAndView(EXAMPLE_VIEW);	//Nombre de html sin la extension
	}
	
	
	
	// FORMAS DE INSERTAR DATOS
	
	// Primera forma 
	
		@GetMapping("exampleStringData")
		public String exampleStringData(Model model) {
			model.addAttribute("name", "Edgar");
			return EXAMPLE_DATA_VIEW;
		}
		
		// Segunda forma
		
		@GetMapping("exampleMAVData")
		public ModelAndView exampleMAVData() {
			ModelAndView mav = new ModelAndView(EXAMPLE_DATA_VIEW);
			mav.addObject("name", "Efrain");
			return mav;	//Nombre de html sin la extension
		}
	

}
