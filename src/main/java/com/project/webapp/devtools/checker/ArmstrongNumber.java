/**
 * 
 */
package com.project.webapp.devtools.checker;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vamsi Ravi	
 *
 */
@RestController
public class ArmstrongNumber {

	@RequestMapping(value="/armstrong/{id}", method= RequestMethod.GET)
	public Boolean checkArmstrongNumber(@PathVariable("id") Integer id){
		
		int init = 0;
		int temp, tripler;
		temp = id;
		while(id>0){
			tripler = id%10;
			id = id/10;
			init = init +(tripler*tripler*tripler);
		}
		if(temp == init){
			return true;
		}else{
			return false;
		}
	}
}
