package com.project.webapp.devtools.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 */

/**
 * @author Vamsi Ravi
 *
 */
@Controller
public class ViewController {

	@GetMapping("/home")
	public String home(){
		return "Welcome Home!!!";
	}
}
