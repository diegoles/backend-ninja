package com.udemy.service;

import java.util.List;

import com.udemy.entity.Course;
import com.udemy.model.CourseModel;

public interface CourseService {

	public abstract List<CourseModel> listAllCourses();

	public abstract CourseModel addCourse(Course course);

	public abstract int removeCourse(int id);

	public abstract Course updateCourse(Course course);

}
