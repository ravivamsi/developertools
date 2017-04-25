/**
 * 
 */
package com.project.webapp.devtools.json;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class JsonEncoder {

	@RequestMapping(value="json/object/create", method=RequestMethod.GET)
	public JSONObject createJSONObject(){
		 JSONObject jsonObject = new JSONObject();
		 
		 try {
			jsonObject.put("name", "name");
			jsonObject.put("amount", new Double(100.25));
			jsonObject.put("num", new Integer(100));
		    jsonObject.put("is_vip", new Boolean(true));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return jsonObject;
	}
}
