package be.abis.exercise.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.abis.exercise.exception.PersonCanNotBeDeletedException;
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
    }
	
	@GetMapping("")
	public ArrayList<Person> getAllPersons(){
    	return personService.getAllPersons();    	
    }
	
	@PostMapping("")
	public Person findPersonWithEmailAndPasswd(@RequestBody Person person) {
		Person p = personService.findPerson(person.getEmailAddress(),person.getPassword());
    	return p; 
    	/**POST http://localhost:8085/exercise/api/persons
    	 * 
    	 * Put in Body in Postman
    	 * 
    	 * {
		    "personId": 2,
		    "firstName": "Mary",
		    "lastName": "Jones",
		    "age": 27,
		    "emailAddress": "mjones@abis.be",
		    "password": "abc123",
		    "language": "fr",
		    "company": {
		        "name": "Abis",
		        "telephoneNumber": "016/245610",
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
    	   
	
	@PostMapping("new")
	public void addPerson(@RequestBody Person person) {
		try {
			 personService.addPerson(person);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/**POST http://localhost:8085/exercise/api/persons/new
    	 * 
    	 * Put in Body in Postman
    	 * 
    	 * {
		    "personId": 26,
		    "firstName": "Mike",
		    "lastName": "Scott",
		    "age": 62,
		    "emailAddress": "mscot@waterboys.com",
		    "password": "abc123",
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
	
	@PostMapping("passwd")
	public void changePasswd(@RequestBody Person person) {
		try {
		 personService.changePassword(person,person.getPassword());
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**POST http://localhost:8085/exercise/api/persons/passwd
    	 * 
    	 * Put in Body in Postman
    	 * 
    	 * {
		    "personId": 26,
		    "firstName": "Mike",
		    "lastName": "Scott",
		    "age": 62,
		    "emailAddress": "mscot@waterboys.com",
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
}
	
/**
 * 		ArrayList<Person> getAllPersons();  ==> OK
	    Person findPerson(int id); ==>  OK
	    Person findPerson(String emailAddress, String passWord); ==> OK
	    void addPerson(Person p) throws IOException; ==> OK
	    public void deletePerson(int id) throws PersonCanNotBeDeletedException; ==> OK
	    void changePassword(Person p, String newPswd) throws IOException;	==> OK
 */
	
	
	

