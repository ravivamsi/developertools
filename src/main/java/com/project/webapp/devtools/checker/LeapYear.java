/**
 * 
 */
package com.project.webapp.devtools.checker;

import java.util.Calendar;
import java.util.TimeZone;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class LeapYear {

	@RequestMapping(value="leapyear/{id}", method= RequestMethod.GET)
	public Boolean checkLeapYear(@PathVariable Integer id){
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		calendar.set(Calendar.YEAR,id);
		if(calendar.getActualMaximum(Calendar.DAY_OF_YEAR)> 365){
			return true;
		}else{
			return false;
		}
	}
}
