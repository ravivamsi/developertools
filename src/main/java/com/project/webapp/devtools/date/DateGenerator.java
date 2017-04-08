/**
 * 
 */
package com.project.webapp.devtools.date;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class DateGenerator {
	
	@RequestMapping(value="generate/date",method=RequestMethod.GET)
	public Date dategenerator(){
		return new Date();
	}
	
	@RequestMapping(value="generate/localDate", method=RequestMethod.GET)
	public LocalDate localDateGenerator(){
		LocalDate localDate = LocalDate.now();
		return localDate;
	}
	
	@RequestMapping(value="generate/localDate/tomorrow", method=RequestMethod.GET)
	public LocalDate localDateTomorrowGenerator(){
		LocalDate localDate = LocalDate.now();
		return localDate.plus(1, ChronoUnit.DAYS);
	}
	
	@RequestMapping(value="generate/localDate/yesterday", method=RequestMethod.GET)
	public LocalDate localDateYesterdayGenerator(){
		LocalDate localDate = LocalDate.now();
		return localDate.plus(-1, ChronoUnit.DAYS);
	}
	
	@RequestMapping(value="generate/localDate/tomorrow/{id}", method=RequestMethod.GET)
	public LocalDate localDateDateFromTodayGenerator(@PathVariable Long id){
		LocalDate localDate = LocalDate.now();
		return localDate.plus(id, ChronoUnit.DAYS);
	}
	
	@RequestMapping(value="generate/localDate/yesterday/{id}", method=RequestMethod.GET)
	public LocalDate localDateDateBeforeTodayGenerator(@PathVariable Long id){
		LocalDate localDate = LocalDate.now();
		return localDate.minusDays(id);
	}
	
	@RequestMapping(value="generate/timestamp",method=RequestMethod.GET)
	public Timestamp timestampGenerator(){
		return Timestamp.from(Instant.now());
	}
	
	
}
