package com.udemy.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class ErrorsController {
	// El error 400 por defecto ya se coge por configuracion ya que existe la carpeta error
	private final static String ERROR_VIEW = "error/500";
	
//	@ExceptionHandler(Exception.class)
	public String showInternalError() {
		return ERROR_VIEW;
	}
}
