package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.constant.ViewConstant;
import com.udemy.model.UserCredential;

@Controller
public class LoginController {
	
	private final static Log LOG = LogFactory.getLog(LoginController.class);

	@GetMapping("/")
	public String redirectToLogin() {
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String showLoginForm(Model model,
			@RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		LOG.info("METHOD: showLoginForm() -- PARAM: error="+error+", logout="+logout);
		model.addAttribute("userCredential", new UserCredential());
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		LOG.info("Returning to login view");
		return ViewConstant.LOGIN;
	}

	@PostMapping("/loginCheck")
	public String loginCheck(@ModelAttribute(name = "userCredential") UserCredential userCredential) {
		LOG.info("METHOD: loginCheck() -- PARAM: "+userCredential.toString());
		if ("user".equals(userCredential.getUsername()) && "user".equals(userCredential.getPassword())) {
			LOG.info("Returning to contacts view");
			return "redirect:/contacts/showContacts";
		}
		LOG.info("Returning to login?error view");
		return "redirect:/login?error";
	}
}
