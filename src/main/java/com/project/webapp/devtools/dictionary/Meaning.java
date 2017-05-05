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

import com.project.webapp.devtools.model.DictionaryModel;
import com.project.webapp.devtools.util.ConstantValues;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class Meaning {

	@RequestMapping(value="dictionary/{id}", method=RequestMethod.GET)
	public DictionaryModel getMeaning(@PathVariable("id") String id){
		DictionaryModel dictionaryModel = new DictionaryModel();
		Map<String, String> variables = new HashMap<String, String>();
		RestTemplate restTemplate = new RestTemplate();
		dictionaryModel = restTemplate.getForObject(ConstantValues.DICTIONARY_URL+id, DictionaryModel.class, variables );
		
		return dictionaryModel;
	}
}
