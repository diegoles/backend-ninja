package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.constant.ViewConstant;

@Controller
@RequestMapping("/say")
public class HelloWorldController {

	@GetMapping("/helloWorld")
	public String helloWorld() {
		return ViewConstant.HELLO_WORLD; // Nombre del html
	}
}
