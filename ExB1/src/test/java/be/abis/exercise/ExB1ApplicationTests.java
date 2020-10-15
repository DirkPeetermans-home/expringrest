package be.abis.exercise;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import be.abis.exercise.model.Person;
import be.abis.exercise.service.PersonService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExB1ApplicationTests {

	@Autowired
	PersonService ps;
		
	
	@Test
	public void findPersonById() {
		Person p = ps.findPersonById(2);
		assertEquals("Mary",p.getFirstName());
		
	}

}
