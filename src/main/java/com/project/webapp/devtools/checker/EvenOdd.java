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
public class EvenOdd {

	@RequestMapping(value="evenodd/{id}", method=RequestMethod.GET)
	public Boolean checkEvenOdd(@PathVariable Integer id){
		if(id%2 == 0){
			return true;
		}else{
			return false;
		}
	}	
	
}
