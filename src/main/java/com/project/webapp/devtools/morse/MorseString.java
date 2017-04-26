/**
 * 
 */
package com.project.webapp.devtools.morse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class MorseString {

	@RequestMapping(value="morse/{id}/string", method=RequestMethod.GET)
	public String morseToString(@PathVariable String id){
		
		StringBuilder stringBuilder = new StringBuilder();
		
		
		String[] stringWords = id.split("/");
		
		for(String word: stringWords){
			String[] wordAlphabets = word.split(" ");
			
			for(String alphabet: wordAlphabets){
				stringBuilder.append(convertMorseToString(alphabet));
			}
			
		}
		
		return stringBuilder.toString();
	}

	private char convertMorseToString(String alphabet) {
		char alpha;
		
		if(alphabet.equalsIgnoreCase(".-")){
			alpha='a';
		}else if(alphabet.equalsIgnoreCase("-...")){
			alpha='b';
		}else if(alphabet.equalsIgnoreCase("-.-.")){
			alpha='c';
		}else if(alphabet.equalsIgnoreCase("-..")){
			alpha='d';
		}else if(alphabet.equalsIgnoreCase(".")){
			alpha='e';
		}else if(alphabet.equalsIgnoreCase("..-.")){
			alpha='f';
		}else if(alphabet.equalsIgnoreCase("--.")){
			alpha='g';
		}else if(alphabet.equalsIgnoreCase("....")){
			alpha='h';
		}else if(alphabet.equalsIgnoreCase("..")){
			alpha='i';
		}else if(alphabet.equalsIgnoreCase(".---")){
			alpha='j';
		}else if(alphabet.equalsIgnoreCase("-.-")){
			alpha='k';
		}else if(alphabet.equalsIgnoreCase(".-..")){
			alpha='l';
		}else if(alphabet.equalsIgnoreCase("--")){
			alpha='m';
		}else if(alphabet.equalsIgnoreCase("-.")){
			alpha='n';
		}else if(alphabet.equalsIgnoreCase("---")){
			alpha='o';
		}else if(alphabet.equalsIgnoreCase(".--.")){
			alpha='p';
		}else if(alphabet.equalsIgnoreCase("--.-")){
			alpha='q';
		}else if(alphabet.equalsIgnoreCase(".-.")){
			alpha='r';
		}else if(alphabet.equalsIgnoreCase("...")){
			alpha='s';
		}else if(alphabet.equalsIgnoreCase("-")){
			alpha='t';
		}else if(alphabet.equalsIgnoreCase("..-")){
			alpha='u';
		}else if(alphabet.equalsIgnoreCase("...-")){
			alpha='v';
		}else if(alphabet.equalsIgnoreCase(".--")){
			alpha='w';
		}else if(alphabet.equalsIgnoreCase("-..-")){
			alpha='x';
		}else if(alphabet.equalsIgnoreCase("-.--")){
			alpha='y';
		}else if(alphabet.equalsIgnoreCase("--..")){
			alpha='z';
		}else if(alphabet.equalsIgnoreCase("-----")){
			alpha='0';
		}else if(alphabet.equalsIgnoreCase(".----")){
			alpha='1';
		}else if(alphabet.equalsIgnoreCase("..---")){
			alpha='2';
		}else if(alphabet.equalsIgnoreCase("...--")){
			alpha='3';
		}else if(alphabet.equalsIgnoreCase("....-")){
			alpha='4';
		}else if(alphabet.equalsIgnoreCase(".....")){
			alpha='5';
		}else if(alphabet.equalsIgnoreCase("-....")){
			alpha='6';
		}else if(alphabet.equalsIgnoreCase("--...")){
			alpha='7';
		}else if(alphabet.equalsIgnoreCase("---..")){
			alpha='8';
		}else if(alphabet.equalsIgnoreCase("----.")){
			alpha='9';
		}else if(alphabet.equalsIgnoreCase(".-.-")){
			alpha='.';
		}else if(alphabet.equalsIgnoreCase("--..--")){
			alpha=',';
		}else if(alphabet.equalsIgnoreCase("..--..")){
			alpha='?';
		}else if(alphabet.equalsIgnoreCase("|")){
			alpha=' ';
		}else if(alphabet.equalsIgnoreCase("/")){
			alpha=' ';
		}else if(alphabet.equalsIgnoreCase(" ")){
			alpha=' ';
		}else {
			alpha=' ';
		}
		return alpha;
	}
}
