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
public class SimpleInterest {

	@RequestMapping(value="simple/{amount}/interest/{rate}/year/{year}", method= RequestMethod.GET)
	public Double simpleInterestCalculator(@PathVariable("amount") Double amount, @PathVariable("rate") Double rate, @PathVariable("year") Double year){
		return (amount*rate*year)/100;
	}
}
