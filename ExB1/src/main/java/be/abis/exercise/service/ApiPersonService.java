package be.abis.exercise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import be.abis.exercise.model.Person;

@Service
public class ApiPersonService implements PersonService {
	
	@Autowired
	RestTemplate rt;
	
	String baseURL="http://localhost:8085/exercise/api/persons";
	
	@Override
	public Person findPersonById(int id) {
				
		Person p = rt.getForObject(baseURL + "/" + id, Person.class);
		
		return p;
		
		
	}
}
