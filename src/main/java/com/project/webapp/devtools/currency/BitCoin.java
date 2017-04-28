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

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class BitCoin {
	
	@RequestMapping(value="bitcoin", method=RequestMethod.GET)
	public String getBitCoinCurrentDetails(){
		
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> variables = new HashMap<String, String>();
		String result = restTemplate.getForObject("https://blockchain.info/ticker", String.class, variables);
		
		return result;
		
	}
}
