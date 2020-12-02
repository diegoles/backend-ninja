package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.constant.ViewConstant;
import com.udemy.model.ContactModel;
import com.udemy.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController {

	private final static Log LOG = LogFactory.getLog(ContactController.class);

	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;

	@RequestMapping("/cancel")
	public String Cancel() {
		return "redirect:/contacts/showContacts?result=0";
	}

	
	@RequestMapping("/contactForm")
	public String redirectContactForm(@RequestParam(name = "id", required = false) int id, Model model) {
		ContactModel contactModel = new ContactModel();
		if (id != 0) {
			contactModel = contactService.findContactByIdModel(id);
		}
		model.addAttribute("contactModel", contactModel);
		LOG.info("METHOD: redirectContactForm() -- PARAMS: " + contactModel.toString());
		return ViewConstant.CONTACT_FORM;
	}

	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	@RequestMapping("/addContact")
	public String addContact(@ModelAttribute(name = "contactModel") ContactModel contactModel) {
		LOG.info("METHOD: addContact() -- PARAMS: " + contactModel.toString());
		int result = 0;
		// Persona agregada correctamente
		if (null != contactService.addContact(contactModel)) {
			result = 1;
		} else {
		    // No se pudo agregar a la persona
			result = 5;
		}

		return "redirect:/contacts/showContacts?result=".concat(result+"");
	}

	@PreAuthorize("permitAll()")
	@GetMapping("/showContacts")
	public ModelAndView showContacts(@RequestParam(name = "result", required = false) int result) {
		ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("userName", user.getUsername());
		mav.addObject("contacts", contactService.listAllContacts());
		mav.addObject("result", result);

		return mav;
	}

	@GetMapping("/removeContact")
	public ModelAndView removeContact(@RequestParam(name = "id", required = true) int id) {
		contactService.removeContact(id);
		return showContacts(2);
	}
}
