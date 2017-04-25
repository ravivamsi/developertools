/**
 * 
 */
package com.project.webapp.devtools.json;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class JsonDecoder {

	@RequestMapping(value="json/parse/{id}", method=RequestMethod.GET)
	public List<String> decodeJsonString(@PathVariable String id) throws org.json.simple.parser.ParseException{
		
		List<String> stringList = new ArrayList<String>();		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(id);
		JSONArray array = (JSONArray)obj;
		
		for(int i=0; i<array.size(); i++){
			JSONObject jsonObject = (JSONObject)array.get(i);
			stringList.add(jsonObject.toJSONString());
		}
		
		return stringList;
		
	}
	
}
