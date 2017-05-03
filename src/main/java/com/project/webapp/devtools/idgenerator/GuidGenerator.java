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

import com.project.webapp.devtools.model.UUIDModel;
import com.project.webapp.devtools.util.ConstantValues;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class GuidGenerator {

	/*This Set Get Go Doesn't Work
	 * 
	 * @RequestMapping(value="guid/generator/setgetgo", method= RequestMethod.GET)
	public String guidGeneratorSetGetGo(){
		
		Map<String, String> variables = new HashMap<String, String>();
		//UUIDModel uuidModel = new UUIDModel();
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(ConstantValues.GUID_GENERATOR_URL, String.class, variables );
		//String response = restTemplate.getForObject(ConstantValues.GUID_GENERATOR_URL, String.class, variables );
				
//		return uuidModel;
	}*/
	
	@RequestMapping(value="guid/generator", method= RequestMethod.GET)
	public UUIDModel guidGenerator(){
		
		Map<String, String> variables = new HashMap<String, String>();
		UUIDModel uuidModel = new UUIDModel();
		RestTemplate restTemplate = new RestTemplate();
		
		uuidModel.setUuid(restTemplate.getForObject(ConstantValues.GUID_MULTIPLE_GENERATOR_URL, String.class, variables ).trim());
				
		return uuidModel;
	}
	
	@RequestMapping(value="guid/generator/dash", method= RequestMethod.GET)
	public UUIDModel guidGeneratorWithoutDash(){
		
		Map<String, String> variables = new HashMap<String, String>();
		UUIDModel uuidModel = new UUIDModel();
		RestTemplate restTemplate = new RestTemplate();
		
		uuidModel.setUuid(restTemplate.getForObject(ConstantValues.GUID_MULTIPLE_GENERATOR_URL, String.class, variables ).trim().replaceAll("-", ""));
				
		return uuidModel;
	}
	
	@RequestMapping(value="guid/generator/{id}", method= RequestMethod.GET)
	public List<UUIDModel> guidMultipleGenerator(@PathVariable("id") Integer id){
		
		List<UUIDModel> guidList = new ArrayList<UUIDModel>();
		for(int i = 0 ; i < id; i++){
			Map<String, String> variables = new HashMap<String, String>();
			UUIDModel uuidModel = new UUIDModel();
			RestTemplate restTemplate = new RestTemplate();
			
			uuidModel.setUuid( restTemplate.getForObject(ConstantValues.GUID_MULTIPLE_GENERATOR_URL, String.class, variables ).trim());
			guidList.add(uuidModel);
		}		
		return guidList;
	}
	
	@RequestMapping(value="guid/generator/{id}/dash", method= RequestMethod.GET)
	public List<UUIDModel> guidMultipleGeneratorWithoutDash(@PathVariable("id") Integer id){
		
		List<UUIDModel> guidList = new ArrayList<UUIDModel>();
		for(int i = 0 ; i < id; i++){
			Map<String, String> variables = new HashMap<String, String>();
			UUIDModel uuidModel = new UUIDModel();
			RestTemplate restTemplate = new RestTemplate();
			uuidModel.setUuid( restTemplate.getForObject(ConstantValues.GUID_MULTIPLE_GENERATOR_URL, String.class, variables ).trim().replaceAll("-", ""));
			guidList.add(uuidModel);
		}		
		return guidList;
	}
	
	
}
