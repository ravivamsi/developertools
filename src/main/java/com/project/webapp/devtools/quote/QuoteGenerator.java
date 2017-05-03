/**
 * 
 */
package com.project.webapp.devtools.quote;


import java.util.ArrayList;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.project.webapp.devtools.model.QuoteModel;

/**
 * @author Vamsi Ravi
 *
 */
@RestController 
public class QuoteGenerator {

	@RequestMapping(value="generate/quote", method=RequestMethod.POST)
	public HttpResponse<JsonNode> generateQuote() throws UnirestException{
		QuoteModel quoteModel = new QuoteModel();
		
		HttpResponse<JsonNode> response = Unirest.post("https://andruxnet-random-famous-quotes.p.mashape.com/?cat=movies&count=1")
				.header("X-Mashape-Key", "58Lkq0o1JKmshke2gVhQnQByXO3zp18P2mwjsnaIhmQWmKAsr3")
				.header("Content-Type", "application/x-www-form-urlencoded")
				.header("Accept", "application/json").asJson();
		
		return response;
		
		/*
		QuoteModel quoteModel = new QuoteModel();
		
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);//("Content-Type", "application/x-www-form-urlencoded");
		headers.set("X-Mashape-Key", "58Lkq0o1JKmshke2gVhQnQByXO3zp18P2mwjsnaIhmQWmKAsr3");
		headers.set("Accept", "application/json");
		
		HttpEntity<QuoteModel> entity = new HttpEntity<QuoteModel>(quoteModel,headers);
		return restTemplate.exchange("https://andruxnet-random-famous-quotes.p.mashape.com/?cat=famous&count=1", HttpMethod.POST,entity, QuoteModel.class).getBody();
		
	*/}
}
