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
public class DummyCompanyGenerator {
Faker dummyGenerator = new Faker();
	
	@RequestMapping(value="dummy/company/industry", method=RequestMethod.GET)
	public String getDummyCompanyIndustry(){
		return dummyGenerator.company().industry();
	}
	
	@RequestMapping(value="dummy/company/bs", method=RequestMethod.GET)
	public String getDummyCompanyBS(){
		return dummyGenerator.company().bs();
	}
	
	@RequestMapping(value="dummy/company/buzzword", method=RequestMethod.GET)
	public String getDummyCompanyBuzzWord(){
		return dummyGenerator.company().buzzword();
	}
	
	@RequestMapping(value="dummy/company/catchphrase", method=RequestMethod.GET)
	public String getDummyCompanyCatchPhrase(){
		return dummyGenerator.company().catchPhrase();
	}
	
	@RequestMapping(value="dummy/company/logo", method=RequestMethod.GET)
	public String getDummyCompanyLogo(){
		return dummyGenerator.company().logo();
	}

	@RequestMapping(value="dummy/company/name", method=RequestMethod.GET)
	public String getDummyCompanyName(){
		return dummyGenerator.company().name();
	}
		
	@RequestMapping(value="dummy/company/profession", method=RequestMethod.GET)
	public String getDummyCompanyProfession(){
		return dummyGenerator.company().profession();
	}
	
	@RequestMapping(value="dummy/company/url", method=RequestMethod.GET)
	public String getDummyCompanyUrl(){
		return dummyGenerator.company().url();
	}

	@RequestMapping(value="dummy/company/suffix", method=RequestMethod.GET)
	public String getDummyCompanySuffix(){
		return dummyGenerator.company().suffix();
	}
}
