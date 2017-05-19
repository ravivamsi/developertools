/**
 * 
 */
package com.project.webapp.devtools.zip;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonObject;
import com.project.webapp.devtools.util.ConstantValues;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class DistanceWithZip {

	@RequestMapping(value="distance/{zip1}/zip/{zip2}/kms",method=RequestMethod.GET)
	public String calculateDistanceInKmsBetweenZip(@PathVariable("zip1") Long zip1, @PathVariable("zip2") Long zip2) throws ParseException{
		
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> variables = new HashMap<String, String>();
		String result = restTemplate.getForObject(ConstantValues.ZIP_CODE_URL+ConstantValues.API_KEY_ZIP_CODE+"/distance.json/"+zip1+"/"+zip2+"/kms", String.class, variables);
		
		return result;
	}
	
	@RequestMapping(value="distance/{zip1}/zip/{zip2}/mile",method=RequestMethod.GET)
	public String calculateDistanceInMilesBetweenZip(@PathVariable("zip1") Long zip1, @PathVariable("zip2") Long zip2) throws ParseException{
		
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> variables = new HashMap<String, String>();
		String result = restTemplate.getForObject(ConstantValues.ZIP_CODE_URL+ConstantValues.API_KEY_ZIP_CODE+"/distance.json/"+zip1+"/"+zip2+"/mile", String.class, variables);
		
		return result;
	}
	
	@RequestMapping(value="details/{zip}/degrees",method=RequestMethod.GET)
	public String findZipCodeDetailsDegrees(@PathVariable("zip") Long zip) throws ParseException{
		
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> variables = new HashMap<String, String>();
		String result = restTemplate.getForObject(ConstantValues.ZIP_CODE_URL+ConstantValues.API_KEY_ZIP_CODE+"/info.json/"+zip+"/degrees", String.class, variables);
		
		return result;
	}
	
	@RequestMapping(value="details/{zip}/radians",method=RequestMethod.GET)
	public String findZipCodeDetailsRadians(@PathVariable("zip") Long zip) throws ParseException{
		
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> variables = new HashMap<String, String>();
		String result = restTemplate.getForObject(ConstantValues.ZIP_CODE_URL+ConstantValues.API_KEY_ZIP_CODE+"/info.json/"+zip+"/radians", String.class, variables);
		
		return result;
	}
	
	@RequestMapping(value="details/{city}/{state}",method=RequestMethod.GET)
	public String findZipCodeDetailsWithCityAndState(@PathVariable("city") String city, @PathVariable("state") String state) throws ParseException{
		
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> variables = new HashMap<String, String>();
		String result = restTemplate.getForObject(ConstantValues.ZIP_CODE_URL+ConstantValues.API_KEY_ZIP_CODE+"/city-zips.json/"+city+"/"+state, String.class, variables);
		
		return result;
	}
	
}
