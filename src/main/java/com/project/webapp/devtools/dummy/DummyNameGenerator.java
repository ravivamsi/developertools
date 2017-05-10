/**
 * 
 */
package com.project.webapp.devtools.dummy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class DummyNameGenerator {

	Faker dummyGenerator = new Faker();
	
	/*
	 * Name
	 * Company/Enterprise
	 * Business
	 * Date
	 * Number
	 * PhoneNumber
	 * IdNumber
	 * DateAndTime
	 * CreditCard
	 * Address
	 */	
	@RequestMapping(value="dummy/fullname", method=RequestMethod.GET)
	public String getDummyFullName(){
		return dummyGenerator.name().fullName();
	}
	
	@RequestMapping(value="dummy/firstname", method=RequestMethod.GET)
	public String getDummyFirstName(){
		return dummyGenerator.name().firstName();
	}
	
	@RequestMapping(value="dummy/lastname", method=RequestMethod.GET)
	public String getDummyLastName(){
		return dummyGenerator.name().lastName();
	}
	
	@RequestMapping(value="dummy/middlename", method=RequestMethod.GET)
	public String getDummyMiddleName(){
		return dummyGenerator.name().nameWithMiddle();
	}
	
	@RequestMapping(value="dummy/title", method=RequestMethod.GET)
	public String getDummyTitle(){
		return dummyGenerator.name().title();
	}

	@RequestMapping(value="dummy/prefix", method=RequestMethod.GET)
	public String getDummyPrefix(){
		return dummyGenerator.name().prefix();
	}
		
	@RequestMapping(value="dummy/suffix", method=RequestMethod.GET)
	public String getDummySuffix(){
		return dummyGenerator.name().suffix();
	}
	
	@RequestMapping(value="dummy/username", method=RequestMethod.GET)
	public String getDummyUsername(){
		return dummyGenerator.name().username();
	}
}
