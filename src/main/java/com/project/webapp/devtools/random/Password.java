/**
 * 
 */
package com.project.webapp.devtools.random;
import static org.bitbucket.dollar.Dollar.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class Password {

	@RequestMapping(value="random/password/{id}", method=RequestMethod.GET)
	public String generateRandomPassword(@PathVariable Integer id){
		return RandomStringUtils.randomAlphanumeric(id);
	}
	
	@RequestMapping(value="random/password/{id}/dollar", method=RequestMethod.GET)
	public String generateRandomPasswordDollar(@PathVariable Integer id){
		String validCharacters = $('0', '9').join() + $('A', 'Z').join()+$('a','z').join();
		return $(validCharacters).shuffle().slice(id).toString();	
	}
	
	
	
}
