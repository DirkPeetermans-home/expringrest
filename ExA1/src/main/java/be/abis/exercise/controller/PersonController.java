package be.abis.exercise.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.PersonService;

@RestController

public class PersonController {

	@Autowired
	PersonService personService;
	
	@GetMapping("persons/{id}")
	public Person findPerson(@PathVariable("id") int id){
    	return personService.findPerson(id);    	
    }
	
	@GetMapping("persons")
	public ArrayList<Person> getAllPersons(){
    	return personService.getAllPersons();    	
    }
	
	
/**
 * 		ArrayList<Person> getAllPersons();  ==> OK
	    Person findPerson(int id); ==>  OK
	    Person findPerson(String emailAddress, String passWord);
	    void addPerson(Person p) throws IOException;
	    public void deletePerson(int id) throws PersonCanNotBeDeletedException;
	    void changePassword(Person p, String newPswd) throws IOException;	
 */
	

	
	
}
