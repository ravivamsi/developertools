/**
 * 
 */
package com.project.webapp.devtools.currency;

import java.util.HashMap;
import java.util.Map;

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
public class CurrencyRates {

	@RequestMapping(value="currency/getlatest", method= RequestMethod.GET)
	public String getLatestCurrencyExchangeInfo(){
		
		Map<String, String> variables = new HashMap<String, String>();
		variables.put("base", "USD");
		
		RestTemplate restTemplate = new RestTemplate();
		
		String result = restTemplate.getForObject(ConstantValues.CURRENCY_EXCHANGE_RATES_USA, String.class, variables);
		
		return result;
		
	}
	
}
