/**
 * 
 */
package com.project.webapp.devtools.string;

import java.util.StringTokenizer;

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
public class FancyText {

	@RequestMapping(value="fancy/{id}/text", method=RequestMethod.GET)
	public JSONObject fancyText(@PathVariable String id) throws UnirestException, ParseException{
		
		StringTokenizer stringTokenizer = new StringTokenizer(id);
		StringBuilder stringBuilder = new StringBuilder();
		while(stringTokenizer.hasMoreElements()){
			stringBuilder.append(stringTokenizer.nextElement()).append("+");
		}
		
		HttpResponse<String> response = Unirest.get("https://ajith-Fancy-text-v1.p.mashape.com/text?text="+stringBuilder.toString())
				.header("X-Mashape-Key", "58Lkq0o1JKmshke2gVhQnQByXO3zp18P2mwjsnaIhmQWmKAsr3")
				.asString();
		
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody());
		return json;
		
	}
}
