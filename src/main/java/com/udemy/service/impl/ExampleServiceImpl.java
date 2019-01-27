package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.model.Persona;
import com.udemy.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

	private final static Log LOG = LogFactory.getLog(ExampleServiceImpl.class);

	@Override
	public List<Persona> getListPeople() {
		List<Persona> people = new ArrayList<>();
		people.add(new Persona("Alex1", 10));
		people.add(new Persona("Alex2", 20));
		people.add(new Persona("Alex3", 30));
		people.add(new Persona("Alex4", 40));

		LOG.info("!!!!!! HELLO FROM SERVICE  !!!!!");

		return people;
	}

}
