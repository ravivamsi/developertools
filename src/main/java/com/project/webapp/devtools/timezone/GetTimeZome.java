/**
 * 
 */
package com.project.webapp.devtools.timezone;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class GetTimeZome {

	@RequestMapping(value="timezone/longitude/{longitude}/latitude/{latitude}", method= RequestMethod.GET)
	public JSONObject getTimeZoneFromLongitudeAndLatitude(@PathVariable("longitude") String longitude, @PathVariable("latitude") String latitude) throws UnirestException, ParseException{
		HttpResponse<String> response = Unirest.get("https://tehuano-time-zone-v1.p.mashape.com/api2/timezone/"+latitude+"/"+longitude)
				.header("X-Mashape-Key", "58Lkq0o1JKmshke2gVhQnQByXO3zp18P2mwjsnaIhmQWmKAsr3")
				.header("Accept", "application/json")
				.asString();
		
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody());
		return json;
	}
	
	@RequestMapping(value="timezone/country/{country}/zipcode/{zipcode}", method= RequestMethod.GET)
	public String getTimeZoneFromZipCode(@PathVariable String country, @PathVariable String zipcode) throws UnirestException, ParseException{
		HttpResponse<String> response = Unirest.get("https://api.zippopotam.us/"+country+"/"+zipcode)
				.asString();
		
		JSONParser parser = new JSONParser();
		JSONObject jsonLocation = (JSONObject) parser.parse(response.getBody());
						
		HttpResponse<String> timeZonResponse = Unirest.get("https://tehuano-time-zone-v1.p.mashape.com/api2/timezone/"+jsonLocation.get("places.latitude")+"/"+jsonLocation.get("places.longitude"))
				.header("X-Mashape-Key", "58Lkq0o1JKmshke2gVhQnQByXO3zp18P2mwjsnaIhmQWmKAsr3")
				.header("Accept", "application/json")
				.asString();
		
		return timeZonResponse.getBody().toString();
		/*
		 * 
		 * Error in retreiving
		 * 
		 * Please resolve before using this API
		JSONObject json = (JSONObject) parser.parse(timeZonResponse.getBody());
		return json;*/
	}
	
	
	
	
}
