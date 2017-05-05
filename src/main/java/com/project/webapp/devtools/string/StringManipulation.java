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

	@RequestMapping(value="string/{string}/substring/{substring}/check", method = RequestMethod.GET)
	public boolean subStringChecker(@PathVariable("string") String string, @PathVariable("substring") String substring){
		
		if(string.contains(substring)){
			return true;
		}else{
			return false;
		}
	}
	
	@RequestMapping(value="string/{string}/substring/{substring}/replace", method = RequestMethod.GET)
	public String subStringReplacer(@PathVariable("string") String string, @PathVariable("substring") String substring){
		return string.replace(string, substring);
	}
	
	@RequestMapping(value="string/{id}/uppercase",method = RequestMethod.GET)
	public String convertLowerToUpper(@PathVariable String id){
		return id.toUpperCase();
	}
	
	@RequestMapping(value="string/{id}/lowercase",method = RequestMethod.GET)
	public String convertUpperToLower(@PathVariable String id){
		return id.toLowerCase();
	}
	
	@RequestMapping(value="string/{id}/reverse",method = RequestMethod.GET)
	public String reverseString(@PathVariable String id){
		return new StringBuilder(id).reverse().toString();
	}
	
	@RequestMapping(value="string/{id}/length",method = RequestMethod.GET)
	public Integer lengthString(@PathVariable String id){
		return id.length();
	}
	
	@RequestMapping(value="string/{id}/bytes",method = RequestMethod.GET)
	public byte[] bytesString(@PathVariable String id){
		return id.getBytes();
	}
	
	@RequestMapping(value="string/{id}/hashcode",method = RequestMethod.GET)
	public Integer hashCodeString(@PathVariable String id){
		return id.hashCode();
	}
	
	@RequestMapping(value="string/{id}/canonical",method = RequestMethod.GET)
	public String canonicalString(@PathVariable String id){
		return id.intern();
	}
	
	@RequestMapping(value="string/{id}/chararray",method = RequestMethod.GET)
	public char[] charArrayString(@PathVariable String id){
		return id.toCharArray();
	}
	
	@RequestMapping(value="string/{string}/capitalize",method = RequestMethod.GET)
	public String capitalizeString(@PathVariable("string") String string){
		return WordUtils.capitalize(string);
	}
	
	
	@RequestMapping(value="string/{string}/begin/{begin}/end/{end}", method = RequestMethod.GET)
	public String getSubString(@PathVariable("string") String string, @PathVariable("begin") Integer begin, @PathVariable("end") Integer end){
		return string.substring(begin, end);
	}
	
	@RequestMapping(value="string/{string}/begin/{begin}", method = RequestMethod.GET)
	public String getSubString(@PathVariable("string") String string, @PathVariable("begin") Integer begin){
		return string.substring(begin);
	}
	
	@RequestMapping(value="string/{string}/prefix/{prefix}", method = RequestMethod.GET)
	public Boolean startsWith(@PathVariable("string") String string, @PathVariable("prefix") String prefix){
		return string.startsWith(prefix);
	}
	
	@RequestMapping(value="string/{string}/suffix/{suffix}", method = RequestMethod.GET)
	public Boolean endsWith(@PathVariable("string") String string, @PathVariable("suffix") String suffix){
		return string.endsWith(suffix);
	}
	
	@RequestMapping(value="string/{id}/regex/{regex}", method = RequestMethod.GET)
	public Boolean matchesStringRegex(@PathVariable("id") String id, @PathVariable("regex") String regex){
		return id.matches(regex);
	}
		
	
}
