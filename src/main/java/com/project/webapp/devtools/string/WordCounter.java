/**
 * 
 */
package com.project.webapp.devtools.string;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class WordCounter {

	@RequestMapping(value="string/{string}/count", method= RequestMethod.GET)
	public Integer countWords(@PathVariable("string") String string){
		return string.split(" ").length;
	}
	
	@RequestMapping(value="string/{string}/words", method=RequestMethod.GET)
	public Map<String, Integer> getWordCountMap(@PathVariable("string") String string){
		Map<String, Integer> wordCount = new TreeMap<String, Integer>();
		
		String[] stringList = string.split(" ");
		
		for(int i =0 ;i< stringList.length;i++){
			String word = stringList[i];
			
			if(!wordCount.containsKey(word))
	            wordCount.put(word, 1);
	        else
	            wordCount.put(word, wordCount.get(word) + 1);	
		}
		return wordCount;
	}
}
