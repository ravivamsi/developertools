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
public class Palindrome {

	@RequestMapping(value="palindrome/{id}/ignorecase", method=RequestMethod.GET)
	public Boolean checkPalindromeIgnoreCase(@PathVariable String id){
		
		String reverse = new StringBuilder(id).reverse().toString();
		
		if(reverse.equalsIgnoreCase(id)){
			return true;
		}else{
			return false;
		}
	}
	
	@RequestMapping(value="palindrome/{id}", method=RequestMethod.GET)
	public Boolean checkPalindrome(@PathVariable String id){
		
		String reverse = new StringBuilder(id).reverse().toString();
		
		if(reverse.equals(id)){
			return true;
		}else{
			return false;
		}
	}
}
