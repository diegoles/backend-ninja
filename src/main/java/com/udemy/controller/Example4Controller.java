package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.constant.ViewConstant;

@Controller
@RequestMapping("/example4")
public class Example4Controller {

	@RequestMapping("/notFound")
	public String notFound() {
		return ViewConstant.NOT_FOUND;
	}

	@RequestMapping("/error")
	public String error() {
		return ViewConstant.ERROR;
	}
}
