/**
 * 
 */
package com.project.webapp.devtools.converters;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.webapp.devtools.util.ConstantValues;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class Weight {
	
	@RequestMapping(value="kilogram/{id}/pound", method=RequestMethod.GET)
	public double convertKilogramsToPounds(@PathVariable double id){
		return id*ConstantValues.KGLB;
	}

	@RequestMapping(value="pound/{id}/kilogram", method=RequestMethod.GET)
	public double convertPoundsToKilogram(@PathVariable double id){
		return id/ConstantValues.KGLB;
	}
	
	@RequestMapping(value="kilogram/{id}/gram", method=RequestMethod.GET)
	public double convertKilogramToGram(@PathVariable double id){
		return id*ConstantValues.THOUSAND;
	}
	
	@RequestMapping(value="gram/{id}/kilogram", method=RequestMethod.GET)
	public double convertGramToKilogram(@PathVariable double id){
		return id/ConstantValues.THOUSAND;
	}
	
	@RequestMapping(value="kilogram/{id}/ounce", method=RequestMethod.GET)
	public double convertKilogramToOunce(@PathVariable double id){
		return id/ConstantValues.OZKG;
	}
	
	@RequestMapping(value="ounce/{id}/kilogram", method=RequestMethod.GET)
	public double convertOunceToKilogram(@PathVariable double id){
		return id*ConstantValues.OZKG;
	}
	
	@RequestMapping(value="kilogram/{id}/carat", method=RequestMethod.GET)
	public double convertKilogramToCarat(@PathVariable double id){
		return id/ConstantValues.CARATKG;
	}
	
	@RequestMapping(value="carat/{id}/kilogram", method=RequestMethod.GET)
	public double convertCaratToKilogram(@PathVariable double id){
		return id*ConstantValues.CARATKG;
	}
	
	@RequestMapping(value="kilogram/{id}/ton", method=RequestMethod.GET)
	public double convertKilogramToTon(@PathVariable double id){
		return id/ConstantValues.THOUSAND;
	}
	
	@RequestMapping(value="ton/{id}/kilogram", method=RequestMethod.GET)
	public double convertTonToKilogram(@PathVariable double id){
		return id*ConstantValues.THOUSAND;
	}
	
	@RequestMapping(value="kilogram/{id}/quintal", method=RequestMethod.GET)
	public double convertKilogramToQuintal(@PathVariable double id){
		return id/ConstantValues.HUNDRED;
	}
	
	@RequestMapping(value="quintal/{id}/kilogram", method=RequestMethod.GET)
	public double convertQuintalToKilogram(@PathVariable double id){
		return id*ConstantValues.HUNDRED;
	}
	
	@RequestMapping(value="kilogram/{id}/quarter/us", method=RequestMethod.GET)
	public double convertKilogramToUSQuarter(@PathVariable double id){
		return id/ConstantValues.QUARTERUS;
	}
	
	@RequestMapping(value="quarter/{id}/kilogram/us", method=RequestMethod.GET)
	public double convertUSQuarterToKilogram(@PathVariable double id){
		return id*ConstantValues.QUARTERUS;
	}
	
	@RequestMapping(value="kilogram/{id}/quarter/uk", method=RequestMethod.GET)
	public double convertKilogramToUKQuarter(@PathVariable double id){
		return id/ConstantValues.QUARTERUK;
	}
	
	@RequestMapping(value="quarter/{id}/kilogram/uk", method=RequestMethod.GET)
	public double convertUKQuarterToKilogram(@PathVariable double id){
		return id*ConstantValues.QUARTERUK;
	}
	
	
	@RequestMapping(value="kilogram/{id}/stone/us", method=RequestMethod.GET)
	public double convertKilogramToUSStone(@PathVariable double id){
		return id/ConstantValues.STONEUS;
	}
	
	@RequestMapping(value="stone/{id}/kilogram/us", method=RequestMethod.GET)
	public double convertUSStoneToKilogram(@PathVariable double id){
		return id*ConstantValues.STONEUS;
	}
	
	@RequestMapping(value="kilogram/{id}/stone/uk", method=RequestMethod.GET)
	public double convertKilogramToUKStone(@PathVariable double id){
		return id/ConstantValues.STONEUK;
	}
	
	@RequestMapping(value="stone/{id}/kilogram/uk", method=RequestMethod.GET)
	public double convertUKStoneToKilogram(@PathVariable double id){
		return id*ConstantValues.STONEUK;
	}
	
}
