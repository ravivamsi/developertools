/**
 * 
 */
package com.project.webapp.devtools.crypto;

import java.util.Base64;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import com.project.webapp.devtools.util.ConstantValues;

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
	
	@RequestMapping(value="decrytor/{id}", method=RequestMethod.GET)
	public String decrytedString(@PathVariable byte[] id){
		Key aesKey = new SecretKeySpec(ConstantValues.RAW_KEY.getBytes(), "AES");
		Cipher cipher = null;
		String decrypt = "";
		try {
			cipher = Cipher.getInstance("AES");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			decrypt =  new String(cipher.doFinal(id));
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return decrypt;
		
	}
}
