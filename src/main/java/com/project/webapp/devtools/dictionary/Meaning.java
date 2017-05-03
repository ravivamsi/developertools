/**
 * 
 */
package com.project.webapp.devtools.dictionary;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class Meaning {

	@RequestMapping(value="dictionary/{id}", method=RequestMethod.GET)
	public String getMeaning(@PathVariable("id") String id){
//		https://mashape-community-urban-dictionary.p.mashape.com/define?term=
		RestTemplate restTemplate = new RestTemplate();
		/*restTemplate.headForHeaders("58Lkq0o1JKmshke2gVhQnQByXO3zp18P2mwjsnaIhmQWmKAsr3", "X-Mashape-Key");
		restTemplate.headForHeaders("Accept", "text/plain");*/
		Map<String, String> variables = new HashMap<String, String>();
		String result = restTemplate.getForObject("https://mashape-community-urban-dictionary.p.mashape.com/define?term="+id, String.class, variables);
		return result;
	}
}
