/**
 * 
 */
package com.project.webapp.devtools.joke;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class RandomJoke {

	@RequestMapping(value="joke/random", method=RequestMethod.GET)
	public JSONObject getRandomJoke() throws UnirestException, ParseException{
		HttpResponse<String> response = Unirest.get("https://api.chucknorris.io/jokes/random")
				.asString();
		
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody());
		return json;
		
	}
	
	
}
