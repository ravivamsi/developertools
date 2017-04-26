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
public class StringMorse {

	@RequestMapping(value="string/{id}/morse", method=RequestMethod.GET)
	public String stringToMorse(@PathVariable String id){
		
		
		StringBuilder morse = new StringBuilder();
		char[] charArray = id.toLowerCase().toCharArray();
		
		for(int i =0; i< charArray.length; i++){
			String temp = toMorse(charArray[i]);
			morse.append(temp);
			morse.append(" ");
		}
		return morse.toString();
	}
	
	public String toMorse(char character){
		
		String morseChar;
		
		switch (character){
		case 'a':
			morseChar = ".-";
			break;
		case 'b':
			morseChar = "-...";
			break;
		case 'c':
			morseChar = "-.-.";
			break;
		case 'd':
			morseChar = "-..";
			break;
		case 'e':
			morseChar = ".";
			break;
		case 'f':
			morseChar = "..-.";
			break;
		case 'g':
			morseChar = "--.";
			break;
		case 'h':
			morseChar = "....";
			break;
		case 'i':
			morseChar = "..";
			break;
		case 'j':
			morseChar = ".---";
			break;
		case 'k':
			morseChar = "-.-";
			break;
		case 'l':
			morseChar = ".-..";
			break;
		case 'm':
			morseChar = "--";
			break;
		case 'n':
			morseChar = "-.";
			break;
		case 'o':
			morseChar = "---";
			break;
		case 'p':
			morseChar = ".--.";
			break;
		case 'q':
			morseChar = "--.-";
			break;
		case 'r':
			morseChar = ".-.";
			break;
		case 's':
			morseChar = "...";
			break;
		case 't':
			morseChar = "-";
			break;
		case 'u':
			morseChar = "..-";
			break;
		case 'v':
			morseChar = "...-";
			break;
		case 'w':
			morseChar = ".--";
			break;
		case 'x':
			morseChar = "-..-";
			break;
		case 'y':
			morseChar = "-.--";
			break;
		case 'z':
			morseChar = "--..";
			break;
		case '0':
			morseChar = "-----";
			break;
		case '1':
			morseChar = ".----";
			break;
		case '2':
			morseChar = "..---";
			break;
		case '3':
			morseChar = "...--";
			break;
		case '4':
			morseChar = "....-";
			break;
		case '5':
			morseChar = ".....";
			break;
		case '6':
			morseChar = "-....";
			break;
		case '7':
			morseChar = "--...";
			break;
		case '8':
			morseChar = "---..";
			break;
		case '9':
			morseChar = "----.";
			break;
		case '.':
			morseChar = ".-.-";
			break;
		case ',':
			morseChar = "--..--";
			break;
		case '?':
			morseChar = "..--..";
			break;
		case '|':
			morseChar = " ";
			break;
		case '/':
			morseChar = " ";
			break;
		case ' ':
			morseChar = "/";
			break;
		default:
			morseChar = "#";
			break;			
		}
		
        return morseChar;
		
		
	}
}
