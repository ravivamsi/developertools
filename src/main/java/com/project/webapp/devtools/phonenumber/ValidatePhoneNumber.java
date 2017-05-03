/**
 * 
 */
package com.project.webapp.devtools.phonenumber;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.webapp.devtools.util.ConstantValues;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class ValidatePhoneNumber {

	@RequestMapping(value="validate/{id}/phonenumber", method=RequestMethod.GET)
	public String validatePhoneNumber(@PathVariable String id){
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> variables = new HashMap<String, String>();
		String result = restTemplate.getForObject("https://apilayer.net/api/validate?access_key ="+ConstantValues.API_KEY_PHONENUMBER_VALIDATOR+"&number="+id, String.class, variables);
		return result;
		// 		1856dd3429c9974962d4ab4982201491
		//		https://apilayer.net/api/validate	 
//		    ? access_key = YOUR_ACCESS_KEY
//		    & number = +14158586273
	}
}
