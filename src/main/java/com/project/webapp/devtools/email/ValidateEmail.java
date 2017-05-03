/**
 * 
 */
package com.project.webapp.devtools.email;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;


import com.project.webapp.devtools.util.ConstantValues;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class ValidateEmail {

	@RequestMapping(value="email/{id}/validate", method=RequestMethod.GET)
	public String validateEmail(@PathVariable String id){
		
		 Client client = ClientBuilder.newClient();
	        client.register(HttpAuthenticationFeature.basic(
	            "api",
	            ConstantValues.API_KEY_EMAIL_VALIDATOR
	        ));
		
	        WebTarget mgRoot = client.target("https://api.mailgun.net/v3");

	        return mgRoot
	            .path("/address/parse")
	            .queryParam("addresses", id)
	            .request()
	            .buildGet()
	            .invoke(String.class);
		
	}
	
}
