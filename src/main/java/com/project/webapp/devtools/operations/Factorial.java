/**
 * 
 */
package com.project.webapp.devtools.operations;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class Factorial {

	@RequestMapping(value="factorial/{id}", method=RequestMethod.GET)
	public Long calculateFactorial(@PathVariable Integer id){
		
		Integer factorial, looper ;
		factorial =1 ;
		 for(looper=1;looper<=id;looper++){    
		      factorial=factorial*looper;    
		  }    
		return factorial.longValue();
	}
}
