/**
 * 
 */
package com.project.webapp.devtools.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class RegularExpression {

	@RequestMapping(value="regex/{regex}/string/{string}", method=RequestMethod.GET)
	public Boolean validateStringWithRegex(@PathVariable("regex") String regex, @PathVariable("string") String string){
		return string.matches(regex);
	}
	
	@RequestMapping(value="regex/{regex}/string/{string}/split", method=RequestMethod.GET)
	public String[] regexSplit(@PathVariable("regex") String regex, @PathVariable("string") String string){
		return string.split(regex);
	}
	
	@RequestMapping(value="regex/{regex}/string/{string}/split/{limit}", method=RequestMethod.GET)
	public String[] regexSplitWithLimit(@PathVariable("regex") String regex, @PathVariable("string") String string, @PathVariable("limit") Integer limit){
		return string.split(regex,limit);
	}
	/*


	@RequestMapping(value="regex/{regex}/string/{string}/match", method=RequestMethod.GET)
	public Boolean regexMatch(@PathVariable("regex") String regex, @PathVariable("string") String string){
		Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
		return matcher.matches();
	}
	
	@RequestMapping(value="regex/{regex}/string/{string}/replace", method=RequestMethod.GET)
	public String regexReplace(@PathVariable("regex") String regex, @PathVariable("string") String string){
		return string.replaceAll(regex, string);
	}
	
	@RequestMapping(value="regex/{regex}/string/{string}/split/{limit}", method=RequestMethod.GET)
	public String regexReplaceFirst(@PathVariable("regex") String regex, @PathVariable("string") String string){
		return string.replaceFirst(regex, string);
	}
	
*/		
	
}
