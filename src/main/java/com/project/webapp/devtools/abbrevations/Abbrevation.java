/**
 * 
 */
package com.project.webapp.devtools.abbrevations;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.project.webapp.devtools.model.AbbrevationModel;
import com.project.webapp.devtools.model.DictionaryModel;
import com.project.webapp.devtools.util.ConstantValues;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class Abbrevation {

	
	@RequestMapping(value="abbrevation/{id}", method=RequestMethod.GET)
	public JSONObject getPopularAbbrevation(@PathVariable("id") String id) throws UnirestException, ParseException{
		
		HttpResponse<String> response = Unirest.get("https://daxeel-abbreviations-v1.p.mashape.com/popular/"+id)
				.header("X-Mashape-Key", "58Lkq0o1JKmshke2gVhQnQByXO3zp18P2mwjsnaIhmQWmKAsr3")
				.asString();
		
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody());
		return json;
	
	}
	
	
	@RequestMapping(value="abbrevations/{id}", method=RequestMethod.GET)
	public AbbrevationModel[]  getAllAbbrevation(@PathVariable("id") String id) throws UnirestException, ParseException{
		
		HttpResponse<String> response = Unirest.get("https://daxeel-abbreviations-v1.p.mashape.com/all/"+id)
				.header("X-Mashape-Key", "58Lkq0o1JKmshke2gVhQnQByXO3zp18P2mwjsnaIhmQWmKAsr3")
				.asString();
		
		Gson gson = new Gson();
		AbbrevationModel[] abbrevationArray = gson.fromJson(response.getBody(), AbbrevationModel[].class);
		return abbrevationArray;
	
	}
}
