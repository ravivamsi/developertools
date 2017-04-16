/**
 * 
 */
package com.project.webapp.devtools.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class RandomNumbers {

	@RequestMapping(value="random/{number}/min/{min}/max/{max}", method=RequestMethod.GET)
	public List<Integer> generateRandomNumber(@PathVariable("number") Integer number, @PathVariable("min") Integer min, @PathVariable("max") Integer max){
	List<Integer> integerList = new ArrayList<Integer>();
	Random randomGenerator = new Random();
	for (int i = 1; i <= number; ++i){
	      integerList.add(showRandomInteger(min, max, randomGenerator));
	    }
	
	return integerList;
	}
	
	@RequestMapping(value="randomUnique/{number}/min/{min}/max/{max}", method=RequestMethod.GET)
	public List<Integer> generateRandomUniqueNumber(@PathVariable("number") Integer number, @PathVariable("min") Integer min, @PathVariable("max") Integer max){
	List<Integer> integerList = new ArrayList<Integer>();
	
	IntStream.range(min, max).boxed()
    .collect(Collectors.toCollection(ArrayList::new));
	Collections.shuffle(integerList);
	//integerList.subList(min, max);
	return integerList;
	}
	
	
	
	private static Integer showRandomInteger(int aStart, int aEnd, Random aRandom){
	    if (aStart > aEnd) {
	      throw new IllegalArgumentException("Start cannot exceed End.");
	    }
	    long range = (long)aEnd - (long)aStart + 1;
	    long fraction = (long)(range * aRandom.nextDouble());
	    Integer randomNumber =  (int)(fraction + aStart);    
	    log("Generated : " + randomNumber);
	    return randomNumber;
	  }
	  
	  private static void log(String aMessage){
	    System.out.println(aMessage);
	  }
	
	
}
