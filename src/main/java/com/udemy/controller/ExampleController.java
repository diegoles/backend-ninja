package com.udemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.component.ExampleComponent;
import com.udemy.model.Persona;
import com.udemy.service.ExampleService;

@Controller
@RequestMapping("example/")
public class ExampleController {

	public final static String EXAMPLE_VIEW = "Example";
	public final static String EXAMPLE_DATA_VIEW = "ExampleData";// Nombre de html sin la extension

	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;

	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;

	// Primera forma (solo para devolver la vista o insert muy pocos datos)

	@GetMapping("exampleString")
	// @RequestMapping(value="exampleString", method=RequestMethod.GET)
	public String exampleString() {
		return EXAMPLE_VIEW;
	}

	// Segunda forma (para muchos datos)

	@GetMapping("exampleMAV")
	// @RequestMapping(value="exampleMAV", method=RequestMethod.GET) ********se
	// reemplaza por @GetMapping
	public ModelAndView exampleMAV() {
		return new ModelAndView(EXAMPLE_VIEW); // Nombre de html sin la extension
	}

	// FORMAS DE INSERTAR DATOS

	// Primera forma

	@GetMapping("exampleStringData")
	public String exampleStringData(Model model) {
		exampleComponent.sayHello();
		model.addAttribute("person", new Persona("Edgar", 29));
		model.addAttribute("people", exampleService.getListPeople());
		return EXAMPLE_DATA_VIEW;
	}

	// Segunda forma

	@GetMapping("exampleMAVData")
	public ModelAndView exampleMAVData() {
		ModelAndView mav = new ModelAndView(EXAMPLE_DATA_VIEW);
		mav.addObject("person", new Persona("Efrain", 30));
		mav.addObject("people", exampleService.getListPeople());
		return mav; // Nombre de html sin la extension
	}

}
