/**
 * 
 */
package com.project.webpp.devtools.language;

import java.util.StringTokenizer;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class Detector {

	@RequestMapping(value="language/detect/{id}", method=RequestMethod.GET)
	public JSONObject languageDetector(@PathVariable String id) throws ParseException, UnirestException{

		StringTokenizer stringTokenizer = new StringTokenizer(id);
		StringBuilder stringBuilder = new StringBuilder();
		while(stringTokenizer.hasMoreElements()){
			stringBuilder.append(stringTokenizer.nextElement()).append("%20");
		}
		
		HttpResponse<String> response = Unirest.get("http://apilayer.net/api/detect?access_key=84bdc67521df5af178318aef73b86b72="+stringBuilder.toString())
				.asString();
		
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody());
		return json;
		
	}
}
