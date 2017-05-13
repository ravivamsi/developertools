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
public class DummyBusinessGenerator {
	Faker dummyGenerator = new Faker();
	
	@RequestMapping(value="dummy/business/ccnumber", method=RequestMethod.GET)
	public String getDummyCompanyIndustry(){
		return dummyGenerator.business().creditCardNumber();
	}
	
	@RequestMapping(value="dummy/business/ccexpiry", method=RequestMethod.GET)
	public String getDummyBusinessCCExpiry(){
		return dummyGenerator.business().creditCardExpiry();
	}
	
	@RequestMapping(value="dummy/business/cctype", method=RequestMethod.GET)
	public String getDummyBusinessCCType(){
		return dummyGenerator.business().creditCardType();
	}
	
	@RequestMapping(value="dummy/business/cccvv", method=RequestMethod.GET)
	public int getDummyBusinessCCCVV(){
		return dummyGenerator.number().numberBetween(100, 999);
	}
}
