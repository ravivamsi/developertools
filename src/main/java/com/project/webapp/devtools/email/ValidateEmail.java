/**
 * 
 */
package com.project.webapp.devtools.email;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
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
	
	@RequestMapping(value="validate/{email}/email", method=RequestMethod.GET)
	public static boolean isValidEmailAddress(@PathVariable("email") String email) {
		   boolean result = true;
		   try {
		      InternetAddress emailAddr = new InternetAddress(email);
		      emailAddr.validate();
		   } catch (AddressException ex) {
		      result = false;
		   }
		   return result;
		}
	
	
	@RequestMapping(value="verify/{id}/email", method=RequestMethod.GET)
	public JSONObject verifyEmailAddress(@PathVariable String id) throws UnirestException, ParseException{
		HttpResponse<String> response = Unirest.get("https://ajith-Verify-email-address-v1.p.mashape.com/varifyEmail?email=ravivamsi%40yahoo.com")
				.header("X-Mashape-Key", "58Lkq0o1JKmshke2gVhQnQByXO3zp18P2mwjsnaIhmQWmKAsr3")
				.header("Accept", "application/json")
				.asString();
		
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody());
		return json;
		
	}
}
