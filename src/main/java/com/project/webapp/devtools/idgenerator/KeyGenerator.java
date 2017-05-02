/**
 * 
 */
package com.project.webapp.devtools.idgenerator;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class KeyGenerator {
	
	/*
	AES (128)
	DES (56)
	DESede (168)
	HmacSHA1
	HmacSHA256
	*/
	
	@RequestMapping(value="generate/random/aes/key",method=RequestMethod.GET)
	public Key randomAESKeyGeneration() throws NoSuchAlgorithmException{
		javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance("AES"); 
		keyGenerator.init(128, new SecureRandom());
		return keyGenerator.generateKey();
	}
	
	@RequestMapping(value="generate/random/des/key",method=RequestMethod.GET)
	public Key randomDESKeyGeneration() throws NoSuchAlgorithmException{
		javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance("DES"); 
		keyGenerator.init(56, new SecureRandom());
		return keyGenerator.generateKey();
	}
	
	@RequestMapping(value="generate/random/desede/key",method=RequestMethod.GET)
	public Key randomDESedeKeyGeneration() throws NoSuchAlgorithmException{
		javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance("DESede"); 
		keyGenerator.init(168, new SecureRandom());
		return keyGenerator.generateKey();
	}
	
	@RequestMapping(value="generate/random/HmacSHA1/key",method=RequestMethod.GET)
	public Key randomHmacSHA1KeyGeneration() throws NoSuchAlgorithmException{
		javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance("HmacSHA1"); 
		keyGenerator.init( new SecureRandom());
		return keyGenerator.generateKey();
	}
	
	@RequestMapping(value="generate/random/HmacSHA256/key",method=RequestMethod.GET)
	public Key randomHmacSHA256KeyGeneration() throws NoSuchAlgorithmException{
		javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance("HmacSHA256"); 
		keyGenerator.init( new SecureRandom());
		return keyGenerator.generateKey();
	}
	
}
