/**
 * 
 */
package com.project.webapp.devtools.checker;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class PrimeNumber {

	@RequestMapping(value="prime/{id}", method = RequestMethod.GET)
	public boolean primeNumberChecker(@PathVariable("id") Integer id){
		
		for(int i=2;i<id/2;i++) {
	        if(id%i==0)
	            return false;
	    }
		
		return true;
	}
	
	
}
