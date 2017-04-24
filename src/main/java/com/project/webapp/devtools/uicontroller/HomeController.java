/**
 * 
 */
package com.project.webapp.devtools.uicontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Vamsi Ravi
 *
 */
@Controller
public class HomeController {
	    @RequestMapping("/home")
	    String home() {
	        return "home";
	    }
	}

