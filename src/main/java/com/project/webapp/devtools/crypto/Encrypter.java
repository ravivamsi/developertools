/**
 * 
 */
package com.project.webapp.devtools.crypto;

import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.webapp.devtools.util.ConstantValues;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class Encrypter {
	
	@RequestMapping(value="encrypt/{id}", method=RequestMethod.GET)
	public byte[] encryptString(@PathVariable String id){
		 return org.apache.commons.codec.binary.Base64.decodeBase64(id);
	}
	
	
	@RequestMapping(value="encrytor/{id}", method=RequestMethod.GET)
	public byte[] stringEncryptor(@PathVariable String id) throws IllegalBlockSizeException, BadPaddingException{
		Key aesKey = new SecretKeySpec(ConstantValues.RAW_KEY.getBytes(), "AES");
        Cipher cipher = null;
        byte[] encrypted = null;
		try {
			cipher = Cipher.getInstance("AES");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // encrypt the text
        try {
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
			encrypted = cipher.doFinal(id.getBytes());
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return encrypted;
	}
}
