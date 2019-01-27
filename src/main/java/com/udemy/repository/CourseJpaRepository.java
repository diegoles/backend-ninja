package com.udemy.repository;

import java.io.Serializable;
//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.entity.Course;

@Repository("courseJpaRepository")
public interface CourseJpaRepository extends JpaRepository<Course, Serializable> {
//	
//	public abstract Course fingByPrice(int price);
//	
//	public abstract Course fingByPriceAndName(int price, String name);
//	
//	public abstract List<Course> fingByNameOrderByHours(String name);
//	
//	public abstract Course fingByNameOrPrice(String name, int price);
}
