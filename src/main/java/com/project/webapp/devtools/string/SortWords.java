/**
 * 
 */
package com.project.webapp.devtools.string;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class SortWords {

	@RequestMapping(value="sort/{id}/alphabet", method=RequestMethod.GET)
	public List<String> sortWords(@PathVariable String id){
		StringTokenizer stringTokenizer = new StringTokenizer(id);
		List<String> stringList = new ArrayList<String>();
		while(stringTokenizer.hasMoreElements()){
			stringList.add(stringTokenizer.nextElement().toString());
		}
		java.util.Collections.sort(stringList, Collator.getInstance());
		return stringList;
	}
		
}
