/**
 * 
 */
package com.project.webapp.devtools.vin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.webapp.devtools.model.VINModel;
import com.project.webapp.devtools.util.ConstantValues;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class VehicleidentificationNumber {

	@RequestMapping(value="vin/{vin}/year/{year}", method= RequestMethod.GET)
	public VINModel getVinDetails(@PathVariable("vin") String vin, @PathVariable("year") String year){
		RestTemplate restTemplate = new RestTemplate();
		VINModel vinModel = new VINModel();
		Map<String, String> variables = new HashMap<String, String>();
		vinModel = restTemplate.getForObject("https://vpic.nhtsa.dot.gov/api/vehicles/DecodeVinValues/"+vin+"?format=json&modelyear="+year, VINModel.class, variables );
		return vinModel;
	}
}
