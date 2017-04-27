/**
 * 
 */
package com.project.webapp.devtools.converters;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class Temperature {

	@RequestMapping(value="fahrenheit/{id}/celsius", method=RequestMethod.GET)
	public Double fahrenheitToCelsius(@PathVariable Double id){
		return (id - 32) * (5d / 9d);
	}
	
	@RequestMapping(value="celsius/{id}/fahrenheit", method=RequestMethod.GET)
	public Double celsiusToFahrenheit(@PathVariable Double id){
		return 32 + (id * 9d / 5d);
	}
	
	@RequestMapping(value="kelvin/{id}/celsius", method=RequestMethod.GET)
	public Double kelvinToCelsius(@PathVariable Double id){
		return id - 273.15f;
	}
	
	@RequestMapping(value="celsius/{id}/kelvin", method=RequestMethod.GET)
	public Double celsiusToKelvin(@PathVariable Double id){
		return id + 273.15f;
	}
	
	@RequestMapping(value="kelvin/{id}/fahrenheit", method=RequestMethod.GET)
	public Double kelvinToFahrenheit(@PathVariable Double id){
		return (( id - 273.15) * 9d/5d) + 32;
	}
	
	@RequestMapping(value="fahrenheit/{id}/kelvin", method=RequestMethod.GET)
	public Double fahrenheitToKelvin(@PathVariable Double id){
		return (5d/9d * (id - 32) + 273.15);
	}
	
	
	// (5/9 * (fahrenheit - 32) + 273.15);
	
	
}
