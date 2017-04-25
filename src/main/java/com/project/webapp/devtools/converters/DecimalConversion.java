/**
 * 
 */
package com.project.webapp.devtools.converters;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class DecimalConversion {

	@RequestMapping(value="decimal/{id}/binary", method=RequestMethod.GET)
	public String decimalToBinary(@PathVariable Integer id){
		return Integer.toBinaryString(id);		
	}
	
	@RequestMapping(value="decimal/{id}/hex", method=RequestMethod.GET)
	public String decimalToHex(@PathVariable Integer id){
		return Integer.toHexString(id);		
	}
	
	@RequestMapping(value="decimal/{id}/octal", method=RequestMethod.GET)
	public String decimalToOctal(@PathVariable Integer id){
		return Integer.toOctalString(id);		
	}
}
