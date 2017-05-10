/**
 * 
 */
package com.project.webapp.devtools.dummy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class DummyInitialDataSets {

	Faker dummyGenerator = new Faker();
	
	@RequestMapping(value="initial/data", method= RequestMethod.GET)
	public List<String> getInitialDataSets(){
		List<String> initialDataSets = new ArrayList<String>();
		
		initialDataSets.add("Name");
		initialDataSets.add("Company");
		initialDataSets.add("Date");
		initialDataSets.add("Number");
		initialDataSets.add("PhoneNumber");
		initialDataSets.add("IdNumber");
		initialDataSets.add("CreditCard");
		initialDataSets.add("DateAndTime");
		initialDataSets.add("Address");
		
		return initialDataSets;
	}
	
	@RequestMapping(value="initial/data/name", method= RequestMethod.GET)
	public List<String> getInitialDataSetsName(){
		List<String> initialDataSets = new ArrayList<String>();
		
		initialDataSets.add("First Name");
		initialDataSets.add("Last Name");
		initialDataSets.add("Full Name");
		initialDataSets.add("Name with Middle");
		initialDataSets.add("Prefix");
		initialDataSets.add("Suffix");
		initialDataSets.add("Title");
		initialDataSets.add("Username");
		
		return initialDataSets;
	}
	
	@RequestMapping(value="initial/data/company", method= RequestMethod.GET)
	public List<String> getInitialDataSetsCompany(){
		
		List<String> initialDataSets = new ArrayList<String>();
		
		initialDataSets.add("Company Name");
		initialDataSets.add("Industry");
		initialDataSets.add("BuzzWord");
		initialDataSets.add("bs");
		initialDataSets.add("Catch Phrase");
		initialDataSets.add("Logo");
		initialDataSets.add("Suffix");
		initialDataSets.add("Profession");
		initialDataSets.add("URL");
		
		return initialDataSets;
	}
	
	
	
	@RequestMapping(value="initial/data/business", method= RequestMethod.GET)
	public List<String> getInitialDataSetsBusiness(){
		
		List<String> initialDataSets = new ArrayList<String>();
		
		initialDataSets.add("Credit Card Number");
		initialDataSets.add("Expiry Date");
		initialDataSets.add("Card Type");
		initialDataSets.add("CVV");
		
		return initialDataSets;
	}
	
	@RequestMapping(value="initial/data/date", method= RequestMethod.GET)
	public List<String> getInitialDataSetsDate(){
		
		
		List<String> initialDataSets = new ArrayList<String>();
		
		initialDataSets.add("Current Date");
		initialDataSets.add("Past Date");
		initialDataSets.add("Future Date");
		initialDataSets.add("Random");
		
		return initialDataSets;
	}
	
	@RequestMapping(value="initial/data/number", method= RequestMethod.GET)
	public List<String> getInitialDataSetsNumber(){
		
		List<String> initialDataSets = new ArrayList<String>();
		
		initialDataSets.add("Digit");
		initialDataSets.add("Digits");
		initialDataSets.add("Random Digit");
		initialDataSets.add("Random Long");
		
		return initialDataSets;
	}
	
	@RequestMapping(value="initial/data/phonenumber", method= RequestMethod.GET)
	public List<String> getInitialDataSetsPhoneNumber(){
		
		List<String> initialDataSets = new ArrayList<String>();
		
		initialDataSets.add("Cell Phone");
		initialDataSets.add("Phone Number");
		
		return initialDataSets;
	}
	
	@RequestMapping(value="initial/data/idnumber", method= RequestMethod.GET)
	public List<String> getInitialDataSetsIdNumber(){
		
		
		List<String> initialDataSets = new ArrayList<String>();
		
		initialDataSets.add("Invalid ID");
		initialDataSets.add("Valid ID");
		initialDataSets.add("SSN Valid");
		initialDataSets.add("Valid SVSESSN");
		initialDataSets.add("Invalid SVSESSN");
		
		return initialDataSets;
	}
	
	
	@RequestMapping(value="initial/data/address", method= RequestMethod.GET)
	public List<String> getInitialDataSetsAddress(){
		
		List<String> initialDataSets = new ArrayList<String>();
		
		initialDataSets.add("Building Number");
		initialDataSets.add("City");
		initialDataSets.add("City Name");
		initialDataSets.add("City Prefix");
		initialDataSets.add("City Suffix");
		initialDataSets.add("Country");
		initialDataSets.add("Country Code");
		initialDataSets.add("Full Address");
		initialDataSets.add("Longitude");
		initialDataSets.add("Latitude");
		initialDataSets.add("Longitude");
		initialDataSets.add("Seconday Address");
		initialDataSets.add("Primary Address");
		initialDataSets.add("State");
		initialDataSets.add("State Abbrevation");
		initialDataSets.add("ZIP Code");
		initialDataSets.add("Street Address");
		initialDataSets.add("Street Number");
		initialDataSets.add("Street Name");
		initialDataSets.add("Time Zone");
		
		return initialDataSets;
	}
}
