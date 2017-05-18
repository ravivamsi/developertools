/**
 * 
 */
package com.project.webapp.devtools.weather;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.webapp.devtools.util.ConstantValues;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class CurrentWeather {

	@RequestMapping(value="weather/{id}/current", method=RequestMethod.GET)
	public String currentWeather(@PathVariable String id){
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> variables = new HashMap<String, String>();
		String result = restTemplate.getForObject("api.openweathermap.org/data/2.5/weather?id="+id+"&APPID="+ConstantValues.API_KEY_WEATHER, String.class, variables);
		return result;
	}
	
	@RequestMapping(value="weather/{zip}/{country}/current", method=RequestMethod.GET)
	public String currentWeatherByZipAndCountryCode(@PathVariable("zip") Long zip, @PathVariable("country") String country){
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> variables = new HashMap<String, String>();
		String result = restTemplate.getForObject("api.openweathermap.org/data/2.5/weather?zip="+zip+","+country+"&APPID="+ConstantValues.API_KEY_WEATHER, String.class, variables);
		return result;
	}
	
	@RequestMapping(value="weather/{city}/{country}/current", method=RequestMethod.GET)
	public String currentWeatherByCityAndCountryCode(@PathVariable("city") String city, @PathVariable("country") String country){
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> variables = new HashMap<String, String>();
		String result = restTemplate.getForObject("api.openweathermap.org/data/2.5/weather?q="+city+","+country+"&APPID="+ConstantValues.API_KEY_WEATHER, String.class, variables);
		return result;
	}
	
	
	
	
}
