package be.abis.exercise.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.abis.exercise.exception.PersonCanNotBeDeletedException;
import be.abis.exercise.model.Login;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.PersonService;

@RestController
@RequestMapping("persons")

public class PersonController {

	@Autowired
	PersonService personService;
	
	@GetMapping("{id}")
	public Person findPerson(@PathVariable("id") int id){
    	return personService.findPerson(id);    
    	//GET http://localhost:8085/exercise/api/persons/2
    }
	
	@GetMapping("")
	public ArrayList<Person> getAllPersons(){
    	return personService.getAllPersons();   
    	//GET http://localhost:8085/exercise/api/persons
    }
	
	@GetMapping("/login")
	public Person findPersonWithEmailAndPasswd(@RequestBody Login login) {
		Person p = personService.findPerson(login.getEmail(),login.getPassword());
    	return p; 
    	/**GET http://localhost:8085/exercise/api/persons/login
    	 * 
    	 * Put in Body in Postman
    	 * 
    	 * {
		    
		    "emailAddress": "mjones@abis.be",
		    "password": "abc123",
		    }
    	*/
	}
    	   
	
	@PostMapping("")
	public void addPerson(@RequestBody Person person) {
		try {
			 personService.addPerson(person);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/**POST http://localhost:8085/exercise/api/persons
    	 * 
    	 * Put in Body in Postman
    	 * 
    	 * {
		    "personId": 31,
		    "firstName": "Steve",
		    "lastName": "Wickham",
		    "age": 66,
		    "emailAddress": "swickham@waterboys.com",
		    "password": "abc456",
		    "language": "en",
		    "company": {
		        "name": "None",
		        "telephoneNumber": "016/1111111",
		        "vatNr": "BE 0428.407.725",
		        "address": {
		            "street": "Diestsevest",
		            "town": "Leuven",
		            "zipcode": "3000",
		            "nr": 32
		        }
		    }
		}
    	*/
		}
	
	@DeleteMapping("{id}")
	public void deletePerson(@PathVariable("id") int id) {
		try {
			 personService.deletePerson(id);
		} catch (PersonCanNotBeDeletedException e) {
			e.printStackTrace();
		}
		//DELETE http://localhost:8085/exercise/api/persons/70
}
	
	@PutMapping("{id}")
	public void changePasswd(@PathVariable("id") int id,@RequestBody Person person) {
		try {
		 personService.changePassword(personService.findPerson(id),person.getPassword());
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**PUT http://localhost:8085/exercise/api/persons/26
    	 * 
    	 * Put in Body in Postman
    	 * 
    	 * {
		    
		    "password": "abc456",		       
		}
    	*/
}
}
	
/**
 * 		ArrayList<Person> getAllPersons();  ==> OK
	    Person findPerson(int id); ==>  OK
	    Person findPerson(String emailAddress, String passWord); ==> OK
	    void addPerson(Person p) throws IOException; ==> OK
	    public void deletePerson(int id) throws PersonCanNotBeDeletedException; ==> OK
	    void changePassword(Person p, String newPswd) throws IOException;	==> OK
 */
	
	
	

