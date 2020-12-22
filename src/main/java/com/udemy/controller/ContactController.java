package com.udemy.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @RequestMapping("/addContact")
    public String addContactTable(@Valid @ModelAttribute(name = "contactModel") ContactModel contactModel, BindingResult bindingResult) {
        LOG.info("METHOD: addContact() -- PARAMS: " + contactModel.toString());
        int result = 0;
        if (bindingResult.hasErrors()) {
            return ViewConstant.CONTACT_FORM;
        } else {
            // Persona agregada correctamente
            if (null != contactService.addContact(contactModel)) {
                result = 1;
            } else {
                // No se pudo agregar a la persona
                result = 5;
            }
        }

        return "redirect:/contacts/table?result=".concat(result + "");
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

    @PreAuthorize("permitAll()")
    @GetMapping("/showContacts")
    public ModelAndView showContacts(@RequestParam(name = "result", required = false) int result) {
        return getMavContacts(result, ViewConstant.CONTACTS);
    }
    
    @PreAuthorize("permitAll()")
    @GetMapping("/table")
    public ModelAndView table(@RequestParam(name = "result", required = false) int result) {
        return getMavContacts(result, ViewConstant.TABLE);
    }

    @GetMapping("/removeContact")
    public ModelAndView removeContact(@RequestParam(name = "id", required = true) int id) {
        contactService.removeContact(id);
        return table(2);
    }
    
    private ModelAndView getMavContacts(int result, String viewConstant) {
        ModelAndView mav = new ModelAndView(viewConstant);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mav.addObject("userName", user.getUsername());
        mav.addObject("contacts", contactService.listAllContacts());
        mav.addObject("result", result);

        return mav;
    }
}
