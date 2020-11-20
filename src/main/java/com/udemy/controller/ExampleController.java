package com.udemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.component.ExampleComponent;
import com.udemy.constant.ViewConstant;
import com.udemy.model.Persona;
import com.udemy.service.ExampleService;

@Controller
@RequestMapping("example/")
public class ExampleController {

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
        return ViewConstant.EXAMPLE;
    }

    // Segunda forma (para muchos datos)

    @GetMapping("exampleMAV")
    // @RequestMapping(value="exampleMAV", method=RequestMethod.GET) ********se
    // reemplaza por @GetMapping
    public ModelAndView exampleMAV() {
        return new ModelAndView(ViewConstant.EXAMPLE); // Nombre de html sin la extension
    }

    // FORMAS DE INSERTAR DATOS

    // Primera forma

    @GetMapping("exampleStringData")
    public String exampleStringData(Model model) {
        exampleComponent.sayHello();
        model.addAttribute("person", new Persona("Edgar", 29));
        model.addAttribute("people", exampleService.getListPeople());
        return ViewConstant.EXAMPLE_DATA;
    }

    // Segunda forma

    @GetMapping("exampleMAVData")
    public ModelAndView exampleMAVData() {
        ModelAndView mav = new ModelAndView(ViewConstant.EXAMPLE_DATA);
        mav.addObject("person", new Persona("Efrain", 30));
        mav.addObject("people", exampleService.getListPeople());
        return mav; // Nombre de html sin la extension
    }

}
