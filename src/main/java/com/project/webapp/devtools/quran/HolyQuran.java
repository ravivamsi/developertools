/**
 * 
 */
package com.project.webapp.devtools.quran;

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
public class HolyQuran {

	@RequestMapping(value="quran/asad/en", method=RequestMethod.GET)
	public JSONObject getQuranAsadEnglish() throws UnirestException, ParseException{
		HttpResponse<String> response = Unirest.get("http://api.alquran.cloud/quran/en.asad")
				.asString();
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody());
		return json;
	}
	
	@RequestMapping(value="quran/simple", method=RequestMethod.GET)
	public JSONObject getQuranSimple() throws UnirestException, ParseException{
		HttpResponse<String> response = Unirest.get("http://api.alquran.cloud/quran/quran-simple")
				.asString();
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody());
		return json;
	}
	
	@RequestMapping(value="quran/surah", method=RequestMethod.GET)
	public JSONObject getQuranSurah() throws UnirestException, ParseException{
		HttpResponse<String> response = Unirest.get("http://api.alquran.cloud/surah")
				.asString();
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody());
		return json;
	}
	
	
	@RequestMapping(value="quran/simple/juz/{id}", method=RequestMethod.GET)
	public JSONObject getQuranSimpleByJuz(@PathVariable String id) throws UnirestException, ParseException{
		HttpResponse<String> response = Unirest.get("http://api.alquran.cloud/juz/"+id+"/quran-simple")
				.asString();
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody());
		return json;
	}
	
	@RequestMapping(value="quran/asad/en/juz/{id}", method=RequestMethod.GET)
	public JSONObject getQuranAsadEnglishByJuz(@PathVariable String id) throws UnirestException, ParseException{
		HttpResponse<String> response = Unirest.get("http://api.alquran.cloud/juz/"+id+"/en.asad")
				.asString();
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody());
		return json;
	}
	
	@RequestMapping(value="quran/asad/en/surah/{id}", method=RequestMethod.GET)
	public JSONObject getQuranAsadEnglishBySurah(@PathVariable String id) throws UnirestException, ParseException{
		HttpResponse<String> response = Unirest.get("http://api.alquran.cloud/surah/"+id+"/en.asad")
				.asString();
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody());
		return json;
	}
	
	@RequestMapping(value="quran/asad/ar/surah/{id}", method=RequestMethod.GET)
	public JSONObject getQuranAsadArabicBySurah(@PathVariable String id) throws UnirestException, ParseException{
		HttpResponse<String> response = Unirest.get("http://api.alquran.cloud/surah/"+id)
				.asString();
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody());
		return json;
	}
	
	@RequestMapping(value="quran/asad/ar/surah/{id}/alafasy", method=RequestMethod.GET)
	public JSONObject getQuranAsadArabicBySurahAlafasy(@PathVariable String id) throws UnirestException, ParseException{
		HttpResponse<String> response = Unirest.get("http://api.alquran.cloud/surah/"+id+"/ar.alafasy")
				.asString();
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody());
		return json;
	}

	@RequestMapping(value="quran/asad/en/ayah/{id}", method=RequestMethod.GET)
	public JSONObject getQuranAsadEnglishByAyahId(@PathVariable String id) throws UnirestException, ParseException{
		HttpResponse<String> response = Unirest.get("http://api.alquran.cloud/ayah/"+id)
				.asString();
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody());
		return json;
	}
	
	
	@RequestMapping(value="quran/asad/en/ayah/{stanza}/{verse}", method=RequestMethod.GET)
	public JSONObject getQuranAsadEnglishByAyahVerse(@PathVariable("stanza") String stanza, @PathVariable("verse") String verse) throws UnirestException, ParseException{
		HttpResponse<String> response = Unirest.get("http://api.alquran.cloud/ayah/"+stanza+":"+verse)
				.asString();
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody());
		return json;
	}
	
}
