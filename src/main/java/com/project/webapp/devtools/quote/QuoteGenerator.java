/**
 * 
 */
package com.project.webapp.devtools.quote;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.project.webapp.devtools.model.QuoteModel;

/**
 * @author Vamsi Ravi
 *
 */
@RestController 
public class QuoteGenerator {
	
	@RequestMapping(value="today/quote", method=RequestMethod.GET)
	public JSONObject getTodayQuote() throws UnirestException, ParseException{
		HttpResponse<String> response = Unirest.get("http://quotes.rest/qod")
				.asString();
		
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody());
		return json;
	}

	@RequestMapping(value="random/quote", method=RequestMethod.POST)
	public JSONObject generateRandomQuote() throws UnirestException, ParseException{
		HttpResponse<String> response = Unirest.get("http://api.forismatic.com/api/1.0/?method=getQuote&key=457653&format=json&lang=en")
				.asString();
		
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody());
		return json;
		}
}
