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
public class MortgageCalculator {

	@RequestMapping(value="mortgage/principal/{principal}/interest/{interest}/term/{term}", method=RequestMethod.GET)
	public Double mortgageCalculator(@PathVariable("principal") Double principal, @PathVariable("interest") Double interest, @PathVariable("term") Integer term){
		
		// rate = Monthly Rate
		Double rate = interest/100/12; 
		// term = in months
		Double payment = (principal * rate) / (1 - Math.pow(1 + rate, -term));
		
		return (double)Math.round(payment * 100) / 100;
	}
}
