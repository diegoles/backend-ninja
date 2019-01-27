package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.constant.ViewConstant;
import com.udemy.entity.Course;
import com.udemy.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

	private final static Log LOG = LogFactory.getLog(CourseController.class);

	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;

	@GetMapping("/listCourses")
	public ModelAndView listAllCourses() {
		LOG.info("CALL: " + "listAllCourses()");
		ModelAndView mav = new ModelAndView(ViewConstant.COURSES);
		mav.addObject("course", new Course());
		mav.addObject("courses", courseService.listAllCourses());
		return mav;
	}

	@PostMapping("/addCourse")
	public String addCourse(@ModelAttribute("course") Course course) {
		LOG.info("CALL: " + "addCourse()" + "  --- PARAM: " + course.toString());
		courseService.addCourse(course);
		return "redirect:/courses/listCourses";
	}

}
