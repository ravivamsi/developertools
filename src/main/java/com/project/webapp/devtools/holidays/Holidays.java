/**
 * 
 */
package com.project.webapp.devtools.holidays;

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
import com.project.webapp.devtools.util.ConstantValues;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class Holidays {

	@RequestMapping(value="holiday/country/{country}/year/{year}/month/{month}",method=RequestMethod.GET)
	public JSONObject getHolidayInformationByCountryYearMonth(@PathVariable("country") String country, @PathVariable("year") String year, @PathVariable("month") String month) throws UnirestException, ParseException{
		
		HttpResponse<String> response = Unirest.get("https://holidayapi.com/v1/holidays?key="+ConstantValues.API_KEY_HOLIDAYS+"&country="+country+"&year="+year+"&month="+month)
				.asString();
		
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody());
		
		return json;
	}

}
