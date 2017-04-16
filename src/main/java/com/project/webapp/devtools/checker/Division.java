/**
 * 
 */
package com.project.webapp.devtools.checker;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class Division {

	@RequestMapping(value="division/{dividend}/divisor/{divisor}")
	public Boolean checkDivision(@PathVariable("dividend") Integer dividend, @PathVariable("divisor") Integer divisor ){
		if(dividend%divisor == 0){
			return true;
		}else{
			return false;
		}
	}
	
	@RequestMapping(value="division/{dividend}/divisor/{divisor}/reminder")
	public Integer reminder(@PathVariable("dividend") Integer dividend, @PathVariable("divisor") Integer divisor ){
		return dividend%divisor;
	}
	
	
	@RequestMapping(value="division/{dividend}/divisor/{divisor}/quotient")
	public float quotient(@PathVariable("dividend") Integer dividend, @PathVariable("divisor") Integer divisor ){
		return dividend/divisor;
	}
	
}
