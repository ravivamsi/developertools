/**
 * 
 */
package com.project.webapp.devtools.email;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class Email {
	
	@RequestMapping(value="email/{id}", method=RequestMethod.GET)
	private void sendEmail(@PathVariable String id){
		
	}

}
