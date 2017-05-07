/**
 * 
 */
package com.project.webapp.devtools.news;

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
public class NewYorkTimes {

	/*	Category Possible Param Values:
	 * home
	 * opinion
	 * world
	 * national 
	 * politics
	 * upshot
	 * nyregion
	 * business
	 * technology
	 * science
	 * health
	 * sports
	 * arts
	 * books
	 * movies
	 * fashion
	 * theater
	 * sundayreview
	 * tmagazine
	 * magazine
	 * food
	 * travel
	 * realestate
	 * automobiles
	 * insider
	 * obituaries
	
	*/
	@RequestMapping(value="news/top/{category}",method=RequestMethod.GET)
	public JSONObject getNewsTopHome(@PathVariable("category") String category) throws UnirestException, ParseException{
		HttpResponse<String> response = Unirest.get("https://api.nytimes.com/svc/topstories/v2/"+category+".json?api-key=f090a535175e40dc8157ba4734b73f27")
				.asString();
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody());
		return json;
	}
}
