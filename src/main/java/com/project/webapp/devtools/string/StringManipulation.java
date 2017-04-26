/**
 * 
 */
package com.project.webapp.devtools.string;



import org.apache.commons.lang3.text.WordUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Vamsi Ravi
 *
 */
public class StringManipulation {

	@RequestMapping(value="string/{id}/substring/{id}/check", method = RequestMethod.GET)
	public boolean subStringChecker(@PathVariable String string, @PathVariable String substring){
		
		if(string.contains(substring)){
			return true;
		}else{
			return false;
		}
	}
	
	@RequestMapping(value="string/{id}/substring/{id}/replace", method = RequestMethod.GET)
	public String subStringReplacer(@PathVariable String string, @PathVariable String substring){
		return string.replace(string, substring);
	}
	
	@RequestMapping(value="string/{id}/uppercase",method = RequestMethod.GET)
	public String convertLowerToUpper(@PathVariable String string){
		return string.toUpperCase();
	}
	
	@RequestMapping(value="string/{id}/lowercase",method = RequestMethod.GET)
	public String convertUpperToLower(@PathVariable String string){
		return string.toLowerCase();
	}
	
	@RequestMapping(value="string/{id}/reverse",method = RequestMethod.GET)
	public String reverseString(@PathVariable String string){
		return new StringBuilder(string).reverse().toString();
	}
	
	@RequestMapping(value="string/{id}/length",method = RequestMethod.GET)
	public Integer lengthString(@PathVariable String string){
		return string.length();
	}
	
	@RequestMapping(value="string/{id}/bytes",method = RequestMethod.GET)
	public byte[] bytesString(@PathVariable String string){
		return string.getBytes();
	}
	
	@RequestMapping(value="string/{id}/hashcode",method = RequestMethod.GET)
	public Integer hashCodeString(@PathVariable String string){
		return string.hashCode();
	}
	
	@RequestMapping(value="string/{id}/canonical",method = RequestMethod.GET)
	public String canonicalString(@PathVariable String string){
		return string.intern();
	}
	
	@RequestMapping(value="string/{id}/chararray",method = RequestMethod.GET)
	public char[] charArrayString(@PathVariable String string){
		return string.toCharArray();
	}
	
	@RequestMapping(value="string/{id}/capitalize",method = RequestMethod.GET)
	public String capitalizeString(@PathVariable String string){
		return WordUtils.capitalize(string);
	}
	
	
	@RequestMapping(value="string/{id}/begin/{id}/end/{id}", method = RequestMethod.GET)
	public String getSubString(@PathVariable String string, @PathVariable("begin") Integer begin, @PathVariable Integer end){
		return string.substring(begin, end);
	}
	
	@RequestMapping(value="string/{id}/begin/{id}", method = RequestMethod.GET)
	public String getSubString(@PathVariable String string, @PathVariable("begin") Integer begin){
		return string.substring(begin);
	}
	
	@RequestMapping(value="string/{id}/prefix/{id}", method = RequestMethod.GET)
	public Boolean startsWith(@PathVariable String string, @PathVariable String prefix){
		return string.startsWith(prefix);
	}
	
	@RequestMapping(value="string/{id}/suffix/{id}", method = RequestMethod.GET)
	public Boolean endsWith(@PathVariable String string, @PathVariable String suffix){
		return string.endsWith(suffix);
	}
	
	@RequestMapping(value="string/{id}/regex/{regex}", method = RequestMethod.GET)
	public Boolean matchesStringRegex(@PathVariable("id") String id, @PathVariable("regex") String regex){
		return id.matches(regex);
	}
		
	
}
