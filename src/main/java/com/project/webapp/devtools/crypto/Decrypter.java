/**
 * 
 */
package com.project.webapp.devtools.crypto;

import java.util.Base64;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class Decrypter {

	@RequestMapping(value="decrypt/{id}", method=RequestMethod.GET)
	public String decryptString(@PathVariable byte[] id){
		 return Base64.getEncoder().withoutPadding().encodeToString(id);
	}
	
	@RequestMapping(value="decrypt/{id}/padding", method=RequestMethod.GET)
	public String decryptPaddingString(@PathVariable byte[] id){
		 return Base64.getEncoder().encodeToString(id);
	}
}
