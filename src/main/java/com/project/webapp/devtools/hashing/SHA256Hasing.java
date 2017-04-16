/**
 * 
 */
package com.project.webapp.devtools.hashing;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class SHA256Hasing {

	@RequestMapping(value="/hasing/sha/{id}", method=RequestMethod.GET)
	private byte[] getSHAHash(@PathVariable String id){
		byte[] shaBytes = new byte[100];
				Arrays.fill( shaBytes, (byte) 0);
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
			shaBytes =  messageDigest.digest(id.getBytes(StandardCharsets.UTF_8)); 
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return shaBytes;
		
	}
	
}
