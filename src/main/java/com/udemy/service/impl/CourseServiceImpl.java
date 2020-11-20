package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.converter.CourseConverter;
import com.udemy.entity.Course;
import com.udemy.model.CourseModel;
import com.udemy.repository.CourseJpaRepository;
import com.udemy.service.CourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {

	private final static Log LOG = LogFactory.getLog(CourseService.class);

	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	@Autowired
    @Qualifier("courseConverter")
    private CourseConverter courseConverter;

	@Override
	public List<CourseModel> listAllCourses() {
		LOG.info("CALL: " + "listAllCourses()");
		
		List<Course> courses = courseJpaRepository.findAll();
        List<CourseModel> coursesModel = new ArrayList<>();

        courses.stream().forEach(x -> coursesModel.add(courseConverter.entity2model(x)));
        return coursesModel;
		
	}

	@Override
	public CourseModel addCourse(Course course) {
		LOG.info("CALL: " + "addCourse()");
		return courseConverter.entity2model(courseJpaRepository.save(course));
	}

	@Override
	public int removeCourse(int id) {
		courseJpaRepository.deleteById(id);
		return 0;
	}

	@Override
	public Course updateCourse(Course course) {
		courseJpaRepository.save(course);
		return null;
	}

}
