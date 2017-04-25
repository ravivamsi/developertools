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
public class ToDecimalConversion {

	@RequestMapping(value="binary/{id}/decimal", method=RequestMethod.GET)
	public Integer binaryToDecimal(@PathVariable String id){
		if(id.matches("[01]+")){
		return Integer.parseInt(id,2);
		}else {
			return 0;
		}
	}
	
	@RequestMapping(value="hex/{id}/decimal", method=RequestMethod.GET)
	public Integer hexToDecimal(@PathVariable String id){
		if(id.matches("-?[0-9a-fA-F]+")){
		return Integer.parseInt(id,16);
		}else{
			return 0;
		}
		
	}
	
	@RequestMapping(value="octal/{id}/decimal", method=RequestMethod.GET)
	public Integer octalToDecimal(@PathVariable String id){
		if(id.matches("[0-7]*$")){
			return Integer.parseInt(id,8);
		}else{
			return 0;
		}
	}
}
