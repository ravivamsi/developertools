/**
 * 
 */
package com.project.webapp.devtools.country;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
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
public class CountyInformation {

	@RequestMapping(value="country/all", method=RequestMethod.GET)
	public JSONArray allCountriesInformation() throws UnirestException, ParseException{
		HttpResponse<JsonNode> response = Unirest.get("https://restcountries-v1.p.mashape.com/all")
				.header("X-Mashape-Key", "58Lkq0o1JKmshke2gVhQnQByXO3zp18P2mwjsnaIhmQWmKAsr3")
				.header("Accept", "application/json")
				.asJson();
		JSONParser parser = new JSONParser();
		JSONArray json = (JSONArray) parser.parse(response.getBody().toString());
		return json;
	}
	
	@RequestMapping(value="country/{id}/code", method=RequestMethod.GET)
	public List<JSONObject> allCountryInformationByCode(@PathVariable String id) throws UnirestException, ParseException{
		HttpResponse<JsonNode> response = Unirest.get("https://restcountries-v1.p.mashape.com/alpha/"+id)
				.header("X-Mashape-Key", "58Lkq0o1JKmshke2gVhQnQByXO3zp18P2mwjsnaIhmQWmKAsr3")
				.header("Accept", "application/json")
				.asJson();
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody().toString());
		List<JSONObject> res = new ArrayList<JSONObject>();
		res.add(json);
		return res;
	}
	
	@RequestMapping(value="country/{id}/name", method=RequestMethod.GET)
	public JSONArray allCountryInformationByName(@PathVariable String id) throws UnirestException, ParseException{
		HttpResponse<JsonNode> response = Unirest.get("https://restcountries-v1.p.mashape.com/name/"+id)
				.header("X-Mashape-Key", "58Lkq0o1JKmshke2gVhQnQByXO3zp18P2mwjsnaIhmQWmKAsr3")
				.header("Accept", "application/json")
				.asJson();
		JSONParser parser = new JSONParser();
		JSONArray json = (JSONArray) parser.parse(response.getBody().toString());
		return json;
	}
	
	
	@RequestMapping(value="country/{id}/callingcode", method=RequestMethod.GET)
	public JSONArray allCountryInformationByCallingCode(@PathVariable String id) throws UnirestException, ParseException{

		HttpResponse<JsonNode> response = Unirest.get("https://restcountries-v1.p.mashape.com/callingcode/"+id)
				.header("X-Mashape-Key", "58Lkq0o1JKmshke2gVhQnQByXO3zp18P2mwjsnaIhmQWmKAsr3")
				.header("Accept", "application/json")
				.asJson();
		JSONParser parser = new JSONParser();
		JSONArray json = (JSONArray) parser.parse(response.getBody().toString());
		return json;
	}
	
	@RequestMapping(value="country/{id}/capital", method=RequestMethod.GET)
	public JSONArray allCountryInformationByCapital(@PathVariable String id) throws UnirestException, ParseException{

		HttpResponse<JsonNode> response = Unirest.get("https://restcountries-v1.p.mashape.com/capital/"+id)
				.header("X-Mashape-Key", "58Lkq0o1JKmshke2gVhQnQByXO3zp18P2mwjsnaIhmQWmKAsr3")
				.header("Accept", "application/json")
				.asJson();
		JSONParser parser = new JSONParser();
		JSONArray json = (JSONArray) parser.parse(response.getBody().toString());
		return json;
	}
	
	@RequestMapping(value="country/{id}/currency", method=RequestMethod.GET)
	public JSONArray allCountryInformationByCurrency(@PathVariable String id) throws UnirestException, ParseException{

		HttpResponse<JsonNode> response = Unirest.get("https://restcountries-v1.p.mashape.com/currency/"+id)
				.header("X-Mashape-Key", "58Lkq0o1JKmshke2gVhQnQByXO3zp18P2mwjsnaIhmQWmKAsr3")
				.header("Accept", "application/json")
				.asJson();
		JSONParser parser = new JSONParser();
		JSONArray json = (JSONArray) parser.parse(response.getBody().toString());
		return json;
	}

	@RequestMapping(value="country/{id}/language", method=RequestMethod.GET)
	public JSONArray allCountryInformationByLanguage(@PathVariable String id) throws UnirestException, ParseException{
		// ISO 639-1 Language Code - ET 
		HttpResponse<JsonNode> response = Unirest.get("https://restcountries-v1.p.mashape.com/lang/"+id)
				.header("X-Mashape-Key", "58Lkq0o1JKmshke2gVhQnQByXO3zp18P2mwjsnaIhmQWmKAsr3")
				.header("Accept", "application/json")
				.asJson();	JSONParser parser = new JSONParser();
		JSONArray json = (JSONArray) parser.parse(response.getBody().toString());
		return json;
	}	
	
	@RequestMapping(value="country/{id}/continent", method=RequestMethod.GET)
	public JSONArray allCountryInformationByContinent(@PathVariable String id) throws UnirestException, ParseException{
		// Sample Request Asia 
		HttpResponse<JsonNode> response = Unirest.get("https://restcountries-v1.p.mashape.com/region/"+id)
				.header("X-Mashape-Key", "58Lkq0o1JKmshke2gVhQnQByXO3zp18P2mwjsnaIhmQWmKAsr3")
				.header("Accept", "application/json")
				.asJson();
		JSONParser parser = new JSONParser();
		JSONArray json = (JSONArray) parser.parse(response.getBody().toString());
		return json;
	}	
	
	@RequestMapping(value="country/{id}/subcontinent", method=RequestMethod.GET)
	public JSONArray allCountryInformationBySubContinent(@PathVariable String id) throws UnirestException, ParseException{
		// Sample Request western%2520asia
		HttpResponse<JsonNode> response = Unirest.get("https://restcountries-v1.p.mashape.com/subregion/"+id)
				.header("X-Mashape-Key", "58Lkq0o1JKmshke2gVhQnQByXO3zp18P2mwjsnaIhmQWmKAsr3")
				.header("Accept", "application/json")
				.asJson();
		JSONParser parser = new JSONParser();
		JSONArray json = (JSONArray) parser.parse(response.getBody().toString());
		return json;
	}	
	
	
}
