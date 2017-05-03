/**
 * 
 */
package com.project.webapp.devtools.sms;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
public class SMSApi {
	
	@RequestMapping(value="send/sms", method= RequestMethod.GET)
	private void sendSMS(){
		
		RestTemplate restTemplate = new RestTemplate();
		
		JSONObject request = new JSONObject();
		

		try {
			request.put("phone", "8572056865" );
			request.put("message","Hello");
			request.put("key", "textbelt");
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);
		
		//restTemplate.postForEntity("https://textbelt.com/text", request, responseType)
		ResponseEntity<String> loginResponse = restTemplate
				  .exchange("https://textbelt.com/text", HttpMethod.POST, entity, String.class);
				if (loginResponse.getStatusCode() == HttpStatus.OK) {
				  try {
					JSONObject userJson = new JSONObject(loginResponse.getBody());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				} else if (loginResponse.getStatusCode() == HttpStatus.UNAUTHORIZED) {
				  // nono... bad credentials
				}
				
					
		
	}
	
	@RequestMapping(value="send/sms/{number}/{message}", method=RequestMethod.GET)
	public String sendShortMessageService(@PathVariable String number,@PathVariable String message){
		 
		return message;
	}

}
