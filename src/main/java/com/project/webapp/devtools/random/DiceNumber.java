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
public class DiceNumber {


	@RequestMapping(value="random/craps",method=RequestMethod.GET)
	public Integer getRandomAmericanRoulette(){
		
		Integer[] firstNumber =  { 1 , 2 , 3 , 4 , 5 , 6 };

		Integer[] secondNumber =  { 1 , 2 , 3 , 4 , 5 , 6 };
		
		Random random = new Random();
		
		return firstNumber[random.nextInt(firstNumber.length)]+secondNumber[random.nextInt(secondNumber.length)];
		
	}
}
