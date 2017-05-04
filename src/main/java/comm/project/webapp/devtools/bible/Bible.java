/**
 * 
 */
package comm.project.webapp.devtools.bible;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.project.webapp.devtools.model.BibleModel;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class Bible {
	
	@RequestMapping(value="bible/book/{book}/chapter/{chapter}", method=RequestMethod.GET)
	public JSONObject getBookChapter(@PathVariable("book") String book, @PathVariable("chapter") String chapter) throws UnirestException, ParseException{
		
		HttpResponse<String> response = Unirest.get("https://ajith-holy-bible.p.mashape.com/GetChapter?Book="+book+"&chapter="+chapter)
				.header("X-Mashape-Key", "58Lkq0o1JKmshke2gVhQnQByXO3zp18P2mwjsnaIhmQWmKAsr3")
				.asString();
		
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(response.getBody());
		return json;
		
	}
	
	@RequestMapping(value="oldtestment/books", method=RequestMethod.GET)
	public Map<Integer, String> getOldTestmentBooks(){
		Map<Integer,String> oldTestmentMap = oldTestMent();
		
		return oldTestmentMap;
	}
	
	@RequestMapping(value="newtestment/books", method=RequestMethod.GET)
	public Map<Integer, String> getNewTestmentBooks(){
		Map<Integer,String> newTestmentMap = newTestMent();
		
		return newTestmentMap;
	}
	
	 public static Map<Integer, String> oldTestMent()
	    {
	        Map<Integer,String> oldTestmentMap = new HashMap<Integer,String>();
	        oldTestmentMap.put(1, "Genesis");
	        oldTestmentMap.put(2, "Exodus");
	        oldTestmentMap.put(3, "Leviticus");
	        oldTestmentMap.put(4, "Numbers");
	        oldTestmentMap.put(5, "Deuteronomy");
	        oldTestmentMap.put(6, "Joshua");
	        oldTestmentMap.put(7, "Judges");
	        oldTestmentMap.put(8, "Ruth");
	        oldTestmentMap.put(9, "Samuel - I");
	        oldTestmentMap.put(10, "Samuel - II");
	        oldTestmentMap.put(11, "Kings - I");
	        oldTestmentMap.put(12, "Kings - II");
	        oldTestmentMap.put(13, "Chronicles - I");
	        oldTestmentMap.put(14, "Chronicles - II");
	        oldTestmentMap.put(15, "Ezra");
	        oldTestmentMap.put(16, "Nehemiah");
	        oldTestmentMap.put(17, "Esther");
	        oldTestmentMap.put(18, "Job");
	        oldTestmentMap.put(19, "Psalms");
	        oldTestmentMap.put(20, "Proverbs");
	        oldTestmentMap.put(21, "Ecclesiastes");
	        oldTestmentMap.put(22, "Song of Solomon");
	        oldTestmentMap.put(23, "Isaiah");
	        oldTestmentMap.put(24, "Jeremiah");
	        oldTestmentMap.put(25, "Lamentations");
	        oldTestmentMap.put(26, "Ezekiel");
	        oldTestmentMap.put(27, "Daniel");
	        oldTestmentMap.put(28, "Hosea");
	        oldTestmentMap.put(29, "Joel");
	        oldTestmentMap.put(30, "Amos");
	        oldTestmentMap.put(31, "Obadiah");
	        oldTestmentMap.put(32, "Jonah");
	        oldTestmentMap.put(33, "Micah");
	        oldTestmentMap.put(34, "Nahum");
	        oldTestmentMap.put(35, "Habakkuk");
	        oldTestmentMap.put(36, "Zephaniah");
	        oldTestmentMap.put(37, "Haggai");
	        oldTestmentMap.put(38, "Zechariah");
	        oldTestmentMap.put(39, "Malachi");
	        
	        return oldTestmentMap;
	    }

	 
	 public static Map<Integer, String> newTestMent()
	    {
	        Map<Integer,String> newTestmentMap = new HashMap<Integer,String>();
	        
	        newTestmentMap.put(1, "Matthew");
	        newTestmentMap.put(2, "Mark");
	        newTestmentMap.put(3, "Luke");
	        newTestmentMap.put(4, "John");
	        newTestmentMap.put(5, "Acts (of the Apostles)");
	        newTestmentMap.put(6, "Romans");
	        newTestmentMap.put(7, "Corinthians - I");
	        newTestmentMap.put(8, "Corinthians - II");
	        newTestmentMap.put(9, "Galatians");
	        newTestmentMap.put(10, "Ephesians");
	        newTestmentMap.put(11, "Philippians");
	        newTestmentMap.put(12, "Colossians");
	        newTestmentMap.put(13, "Thessalonians - I");
	        newTestmentMap.put(14, "Thessalonians - II");
	        newTestmentMap.put(15, "Timothy - I");
	        newTestmentMap.put(16, "Timothy - II");
	        newTestmentMap.put(17, "Titus");
	        newTestmentMap.put(18, "Philemon");
	        newTestmentMap.put(19, "Hebrews");
	        newTestmentMap.put(20, "James");
	        newTestmentMap.put(21, "Peter - I");
	        newTestmentMap.put(22, "Peter - II");
	        newTestmentMap.put(23, "John - I");
	        newTestmentMap.put(24, "John - II");
	        newTestmentMap.put(25, "John - III");
	        newTestmentMap.put(26, "Jude");
	        newTestmentMap.put(27, "Revelation");
	        return newTestmentMap;
	    }

}
