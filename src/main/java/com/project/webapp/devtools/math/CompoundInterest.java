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
public class CompoundInterest {

	@RequestMapping(value="compound/{amount}/interest/{rate}/year/{year}", method= RequestMethod.GET)
	public Double compundInterestCalculator(@PathVariable("amount") Double amount, @PathVariable("rate") Double rate, @PathVariable("year") Double year){
		return amount*Math.pow((1+rate/100), year);
	}
}
