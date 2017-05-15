/**
 * 
 */
package com.project.webapp.devtools.news;

import org.jboss.netty.handler.codec.http.DefaultHttpResponse;
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

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class NewsLive {

	
	@RequestMapping(value="news/sources",method=RequestMethod.GET)
	public JSONObject getNewsSources() throws UnirestException, ParseException{
		HttpResponse<String> response = Unirest.get("https://newsapi.org/v1/sources")
				.asString();
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody());
		return json;
	}
	
	
	/*category	(optional) - The category you would like to get sources for.
Possible options: business, entertainment, gaming, general, music, politics, science-and-nature, sport, technology.
Default: empty (all sources returned)*/
	@RequestMapping(value="news/sources/category/{category}",method=RequestMethod.GET)
	public JSONObject getNewsSourcesByCategory(@PathVariable("category") String category) throws UnirestException, ParseException{
		HttpResponse<String> response = Unirest.get("https://newsapi.org/v1/sources?category="+category)
				.asString();		
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody());
		return json;
	}
	
	/*language	(optional) - The 2-letter ISO-639-1 code of the language you would like to get sources for.
Possible options: en, de, fr.
Default: empty (all sources returned)*/
	
	@RequestMapping(value="news/sources/language/{language}",method=RequestMethod.GET)
	public JSONObject getNewsSourcesByLanguage(@PathVariable("language") String language) throws UnirestException, ParseException{
		HttpResponse<String> response = Unirest.get("https://newsapi.org/v1/sources?category="+language)
				.asString();		
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody());
		return json;
	}
	
	
	/*
	country	(optional) - The 2-letter ISO 3166-1 code of the country you would like to get sources for.
	Possible options: au, de, gb, in, it, us.
	Default: empty (all sources returned)*/
	@RequestMapping(value="news/sources/country/{country}",method=RequestMethod.GET)
	public JSONObject getNewsSourcesByCountry( @PathVariable("country") String country) throws UnirestException, ParseException{
		HttpResponse<String> response = Unirest.get("https://newsapi.org/v1/sources?category="+country)
				.asString();		
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody());
		return json;
	}
	
	/*
	 * sortby - top, latest, popular
	 * 
	 * 
*/
	@RequestMapping(value="news/articles/{source}/{sortby}",method=RequestMethod.GET)
	public JSONObject getNewsArticleBySourceAndSort( @PathVariable("source") String source, @PathVariable("sortby") String sortby) throws UnirestException, ParseException{
		HttpResponse<String> response = Unirest.get("https://newsapi.org/v1/articles?source="+source+"&sortBy="+sortby+"&apiKey=2df3c32ef6ff497b8c422bdf33fdcf71")
				.asString();		
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody());
		return json;
	}
	
	
}
