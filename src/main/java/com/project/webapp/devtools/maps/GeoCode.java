/**
 * 
 */
package com.project.webapp.devtools.maps;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class GeoCode {

	@RequestMapping(value="geocode/{id}",method=RequestMethod.GET)
	public JSONObject getGeoCode(@PathVariable String id) throws UnirestException, ParseException{

		HttpResponse<String> response = Unirest.get("https://michele-zonca-google-geocoding.p.mashape.com/geocode/json?address="+id+"&sensor=true")
				.header("X-Mashape-Key", "58Lkq0o1JKmshke2gVhQnQByXO3zp18P2mwjsnaIhmQWmKAsr3")
				.header("Accept", "application/json")
				.asString();
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody());
		return json;
	}
}
