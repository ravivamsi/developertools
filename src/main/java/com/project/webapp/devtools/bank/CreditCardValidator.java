/**
 * 
 */
package com.project.webapp.devtools.bank;

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
public class CreditCardValidator {

	@RequestMapping(value="validate/{id}/creditcard", method=RequestMethod.GET)
	public String validateCreditCard(@PathVariable String id ){
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> variables = new HashMap<String, String>();
		String result = restTemplate.getForObject("https://api.bincodes.com/cc/json/"+ConstantValues.API_KEY_BANK_VALIDATOR+"/"+id, String.class, variables);
		return result;
	}
}
