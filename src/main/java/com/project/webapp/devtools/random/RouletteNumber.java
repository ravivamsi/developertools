/**
 * 
 */
package com.project.webapp.devtools.random;

import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.webapp.devtools.model.RouletteModel;
import com.project.webapp.devtools.service.RouletteService;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class RouletteNumber {

	RouletteService rouletteService = new RouletteService();
	
	@RequestMapping(value="random/roulette/american",method=RequestMethod.GET)
	public RouletteModel getRandomAmericanRoulette(){
		
		Integer[] rouletteNumber =  {0, 1, 2, 3, 4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37};
		
		Random random = new Random();
		
		if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 0){
			return rouletteService.zeroNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 37){
			return rouletteService.zeroZeroNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 1){
			return rouletteService.oneNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 2){
			return rouletteService.twoNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 3){
			return rouletteService.threeNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 4){
			return rouletteService.fourNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 5){
			return rouletteService.fiveNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 6){
			return rouletteService.sixNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 7){
			return rouletteService.sevenNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 8){
			return rouletteService.eightNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 9){
			return rouletteService.nineNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 10){
			return rouletteService.tenNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 11){
			return rouletteService.elevenNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 12){
			return rouletteService.twelveNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 13){
			return rouletteService.thirteenNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 14){
			return rouletteService.fourteenNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 15){
			return rouletteService.fifteenNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 16){
			return rouletteService.sixteenNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 17){
			return rouletteService.seventeenNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 18){
			return rouletteService.eighteenNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 19){
			return rouletteService.ninteenNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 20){
			return rouletteService.twentyNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 21){
			return rouletteService.twentyOneNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 22){
			return rouletteService.twentyTwoNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 23){
			return rouletteService.twentyThreeNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 24){
			return rouletteService.twentyFourNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 25){
			return rouletteService.twentyFiveNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 26){
			return rouletteService.twentySixNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 27){
			return rouletteService.twentySevenNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 28){
			return rouletteService.twnetyEightNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 29){
			return rouletteService.twentyNineNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 30){
			return rouletteService.thirtyNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 31){
			return rouletteService.thirtyOneNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 32){
			return rouletteService.thirtyTwoNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 33){
			return rouletteService.thirtyThreeNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 34){
			return rouletteService.thirtyFourNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 35){
			return rouletteService.thirtyFiveNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 36){
			return rouletteService.thirtySixNumber();
		}else{
			return rouletteService.errorNumber();
		}
	}
	
	@RequestMapping(value="random/roulette/european",method=RequestMethod.GET)
	public RouletteModel getRandomEuropeanRoulette(){
		
		Integer[] rouletteNumber =  {0, 1, 2, 3, 4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36};

		Random random = new Random();
		
		if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 0){
			return rouletteService.zeroNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 1){
			return rouletteService.oneNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 2){
			return rouletteService.twoNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 3){
			return rouletteService.threeNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 4){
			return rouletteService.fourNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 5){
			return rouletteService.fiveNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 6){
			return rouletteService.sixNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 7){
			return rouletteService.sevenNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 8){
			return rouletteService.eightNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 9){
			return rouletteService.nineNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 10){
			return rouletteService.tenNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 11){
			return rouletteService.elevenNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 12){
			return rouletteService.twelveNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 13){
			return rouletteService.thirteenNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 14){
			return rouletteService.fourteenNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 15){
			return rouletteService.fifteenNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 16){
			return rouletteService.sixteenNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 17){
			return rouletteService.seventeenNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 18){
			return rouletteService.eighteenNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 19){
			return rouletteService.ninteenNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 20){
			return rouletteService.twentyNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 21){
			return rouletteService.twentyOneNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 22){
			return rouletteService.twentyTwoNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 23){
			return rouletteService.twentyThreeNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 24){
			return rouletteService.twentyFourNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 25){
			return rouletteService.twentyFiveNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 26){
			return rouletteService.twentySixNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 27){
			return rouletteService.twentySevenNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 28){
			return rouletteService.twnetyEightNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 29){
			return rouletteService.twentyNineNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 30){
			return rouletteService.thirtyNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 31){
			return rouletteService.thirtyOneNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 32){
			return rouletteService.thirtyTwoNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 33){
			return rouletteService.thirtyThreeNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 34){
			return rouletteService.thirtyFourNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 35){
			return rouletteService.thirtyFiveNumber();
		}else if(rouletteNumber[random.nextInt(rouletteNumber.length)] == 36){
			return rouletteService.thirtySixNumber();
		}else{
			return rouletteService.errorNumber();
		}
	}
	
	
}
