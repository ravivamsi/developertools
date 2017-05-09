/**
 * 
 */
package com.project.webapp.devtools.universities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.project.webapp.devtools.model.AbbrevationModel;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class UniversityInformation {

	@RequestMapping(value="university/{university}", method=RequestMethod.GET)
	public JSONObject[] getUniversityDetails(@PathVariable("university") String university) throws UnirestException, ParseException{
		
		HttpResponse<String> response = Unirest.get("http://universities.hipolabs.com/search?name="+university)
				.asString();
		
		Gson gson = new Gson();
		JSONObject[] universityArray = gson.fromJson(response.getBody(), JSONObject[].class);
		return universityArray;
	}
	

	@RequestMapping(value="university/{university}/country/{country}", method=RequestMethod.GET)
	public JSONObject[] getUniversityDetailsByCountry(@PathVariable("university") String university, @PathVariable("country") String country) throws UnirestException, ParseException{
		
		HttpResponse<String> response = Unirest.get("http://universities.hipolabs.com/search?name="+university+"&country="+country)
				.asString();
				
		Gson gson = new Gson();
		JSONObject[] universityArray = gson.fromJson(response.getBody(), JSONObject[].class);
		return universityArray;
	}
}
