package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example4")
public class Example4Controller {

	private final static String NOT_FOUND_VIEW = "error/404";
	private final static String ERROR_VIEW = "error/500";
	
	@RequestMapping("/notFound")
	public String notFound() {
		return NOT_FOUND_VIEW;
	}
	
	@RequestMapping("/error")
	public String error() {
		return ERROR_VIEW;
	}
}
