/**
 * 
 */
package com.project.webapp.devtools.idgenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class GuidGenerator {

	@RequestMapping(value="guid/generator/setgetgo", method= RequestMethod.GET)
	public String guidGeneratorSetGetGo(){
		
		Map<String, String> variables = new HashMap<String, String>();
		
		RestTemplate restTemplate = new RestTemplate();
		
		String response = restTemplate.getForObject(ConstantValues.GUID_GENERATOR_URL, String.class, variables );
				
		return response;
	}
	
	@RequestMapping(value="guid/generator", method= RequestMethod.GET)
	public String guidGenerator(){
		
		Map<String, String> variables = new HashMap<String, String>();
		
		RestTemplate restTemplate = new RestTemplate();
		
		String response = restTemplate.getForObject(ConstantValues.GUID_MULTIPLE_GENERATOR_URL, String.class, variables );
				
		return response.trim();
	}
	
	@RequestMapping(value="guid/generator/{id}", method= RequestMethod.GET)
	public List<String> guidMultipleGenerator(@PathVariable("id") Integer id){
		
		List<String> guidList = new ArrayList<String>();
		for(int i = 0 ; i < id; i++){
			Map<String, String> variables = new HashMap<String, String>();
			
			RestTemplate restTemplate = new RestTemplate();
			
			String response = restTemplate.getForObject(ConstantValues.GUID_MULTIPLE_GENERATOR_URL, String.class, variables );
			guidList.add(response.trim());
		}		
		return guidList;
	}
}
