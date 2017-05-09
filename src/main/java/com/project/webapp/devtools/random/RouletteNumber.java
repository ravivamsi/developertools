/**
 * 
 */
package com.project.webapp.devtools.random;

import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class RouletteNumber {

	@RequestMapping(value="random/roulette/american",method=RequestMethod.GET)
	public Integer getRandomAmericanRoulette(){
		
		Integer[] rouletteNumber =  {0, 1, 2, 3, 4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37};
		
		Random random = new Random();
		
		return rouletteNumber[random.nextInt(rouletteNumber.length)];
		
	}
	
	@RequestMapping(value="random/roulette/european",method=RequestMethod.GET)
	public Integer getRandomEuropeanRoulette(){
		
		Integer[] rouletteNumber =  {0, 1, 2, 3, 4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36};

		Random random = new Random();
		
		return rouletteNumber[random.nextInt(rouletteNumber.length)];
	}
	
	
}
