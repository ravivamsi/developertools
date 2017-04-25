/**
 * 
 */
package com.project.webapp.devtools.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class SendEmail {
	
	@RequestMapping(value="send/email", method=RequestMethod.GET)
	public Boolean sendEmail(){
	    String to = "xxxxxxxx@xxxxx.xxx";  
	      String from = "xxxxxxxxxxxxx@xxxxx.xxx";  
	      String host="smtp.gmail.com"; 
	  String password = "xxxxxxxxxxxxx";
	      
	     //Get the session object  
	      Properties properties = System.getProperties();  
	      properties.setProperty("mail.smtp.host", host);  
	      properties.setProperty("mail.smtp.auth", "true");
	      properties.setProperty("mail.smtp.port", "587");
	      properties.setProperty("mail.smtp.starttls.enable", "true");
	      properties.setProperty("mail.smtp.starttls.required", "true");

	  
	      Session session = Session.getDefaultInstance(properties,  
	    		    new javax.mail.Authenticator() {  
	    		      protected PasswordAuthentication getPasswordAuthentication() {  
	    		    return new PasswordAuthentication(from,password);  
	    		      }  
	    		    });  
	     //compose the message  
	      try{  
	         MimeMessage message = new MimeMessage(session);  
	         message.setFrom(new InternetAddress(from));  
	         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
	         message.setSubject("Ping");  
	         message.setText("Hello, this is example of sending email  ");  
	  
	         // Send message  
	         Transport.send(message);  
	         System.out.println("message sent successfully....");  

	 		
	 		return true;
	 		
	      }catch (MessagingException mex) {mex.printStackTrace();
	      
	      return false;
	      }  
		
	}

	
}
