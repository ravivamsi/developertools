/**
 * 
 */
package com.project.webapp.devtools.math;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class MathFunctions {

	@RequestMapping(value="math/{id}/sin", method=RequestMethod.GET)
	public Double calculateSin(@PathVariable Double id){
		return Math.sin(id);
	}
	
	@RequestMapping(value="math/{id}/cos", method=RequestMethod.GET)
	public Double calculateCos(@PathVariable Double id){
		return Math.cos(id);
	}
	
	@RequestMapping(value="math/{id}/tan", method=RequestMethod.GET)
	public Double calculateTan(@PathVariable Double id){
		return Math.tan(id);
	}
	
	@RequestMapping(value="math/{id}/cot", method=RequestMethod.GET)
	public Double calculateCot(@PathVariable Double id){
		return 1/Math.tan(id);
	}
	
	
	@RequestMapping(value="math/{id}/cosec", method=RequestMethod.GET)
	public Double calculateCosec(@PathVariable Double id){
		return 1/Math.sin(id);
	}
	
	@RequestMapping(value="math/{id}/sec", method=RequestMethod.GET)
	public Double calculateSec(@PathVariable Double id){
		return 1/Math.cos(id);
	}
	
	@RequestMapping(value="math/{id}/sqrt", method=RequestMethod.GET)
	public Double calculateSquareRoot(@PathVariable Double id){
		return Math.sqrt(id);
	}
	
	@RequestMapping(value="math/{id}/deg", method=RequestMethod.GET)
	public Double calculateRadianToDegree(@PathVariable Double id){
		return Math.toDegrees(id);
	}
	
	@RequestMapping(value="math/{id}/rad", method=RequestMethod.GET)
	public Double calculateDegreeToRadian(@PathVariable Double id){
		return Math.toRadians(id);
	}
	
	@RequestMapping(value="math/{id}/pow/{pow}", method=RequestMethod.GET)
	public Double calculatePower(@PathVariable("id") Double id, @PathVariable("pow") Double pow){
		return Math.pow(id, pow);
	}
	
	@RequestMapping(value="math/{id}/euler", method=RequestMethod.GET)
	public Double calculateEulerNumber(@PathVariable("id") Double id, @PathVariable("pow") Double pow){
		return Math.exp(id);
	}
}
