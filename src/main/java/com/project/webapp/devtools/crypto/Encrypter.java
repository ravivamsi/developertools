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
public class Encrypter {
	
	@RequestMapping(value="encrypt/{id}", method=RequestMethod.GET)
	public byte[] encryptString(@PathVariable String id){
		 return Base64.getDecoder().decode(id);
	}
}
