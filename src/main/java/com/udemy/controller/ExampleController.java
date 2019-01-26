package com.udemy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.model.Persona;

@Controller
@RequestMapping("example/")
public class ExampleController {

	public final static String EXAMPLE_VIEW = "Example";
	public final static String EXAMPLE_DATA_VIEW = "ExampleData";// Nombre de html sin la extension

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
		model.addAttribute("person", new Persona("Edgar", 29));
		model.addAttribute("people", getPeople());
		return EXAMPLE_DATA_VIEW;
	}

	// Segunda forma

	@GetMapping("exampleMAVData")
	public ModelAndView exampleMAVData() {
		ModelAndView mav = new ModelAndView(EXAMPLE_DATA_VIEW);
		mav.addObject("person", new Persona("Efrain", 30));
		mav.addObject("people", getPeople());
		return mav; // Nombre de html sin la extension
	}

	private List<Persona> getPeople() {
		List<Persona> people = new ArrayList<>();
		people.add(new Persona("Alex1", 10));
		people.add(new Persona("Alex2", 20));
		people.add(new Persona("Alex3", 30));
		people.add(new Persona("Alex4", 40));

		return people;
	}

}
