/**
 * 
 */
package com.project.webapp.devtools.timezone;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
public class TimeZoneConverter {

	@RequestMapping(value="timezone/{to}", method=RequestMethod.GET)
	public String convertLocalTimeZoneTo(@PathVariable("to") String to){
		
		TimeZone localTimeZone = TimeZone.getDefault();
		localTimeZone.getID();
		return "";
	}
	
	
	@RequestMapping(value="timezone/now/{timezone}", method=RequestMethod.GET)
	public String getTimeZoneNow(@PathVariable("timezone") String timezone){
		
		Date currentDateTime = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		df.setTimeZone(TimeZone.getTimeZone(timezone));
		/*Calendar timeZone = new GregorianCalendar(TimeZone.getTimeZone(timezone));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		Date date = new Date(timeZone.getTimeInMillis());*/
		return df.format(currentDateTime);
		
	}
	
	@RequestMapping(value="/timezone/{from}/{to}", method=RequestMethod.GET)
	public String convertFromTimeZoneTo(@PathVariable("to") String to){
		
		TimeZone localTimeZone = TimeZone.getDefault();
		
		localTimeZone.getID();
		return "";
	}
	
	
	
}
