package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.constant.ViewConstant;

@Controller
@RequestMapping("example2/")
public class Example2Controller {

	// http://localhost:8080/example2/request1?nm=Edgar

	@RequestMapping("request1")
	public ModelAndView request1(@RequestParam(name = "nm", required = false, defaultValue = "NULL") String name) {
		ModelAndView mav = new ModelAndView(ViewConstant.EXAMPLE_2);
		mav.addObject("nm_in_controller", name);
		return mav;
	}

	// Segunda Forma
	// http://localhost:8080/example2/request2/EDGAR

	@RequestMapping("request2/{nm}")
	public ModelAndView request2(@PathVariable("nm") String name) {
		ModelAndView mav = new ModelAndView(ViewConstant.EXAMPLE_2);
		mav.addObject("nm_in_controller", name);
		return mav;
	}
}
