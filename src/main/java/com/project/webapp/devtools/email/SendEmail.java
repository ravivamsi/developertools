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
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.webapp.devtools.util.ConstantValues;

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

	@RequestMapping(value="send/email/{to}/{from}/{subject}/{text}", method=RequestMethod.GET)
	public String sendEmailWithParametersMailGun(@PathVariable("to") String to, @PathVariable("from") String from,@PathVariable("subject") String subject,@PathVariable("text") String text){
		
		
		Client client = ClientBuilder.newClient();
		
		client.register(HttpAuthenticationFeature.basic(
	            "api",
	            ConstantValues.API_KEY_EMAIL_VALIDATOR
	        ));
		
//		WebResource webResource = client.resource("https://api.mailgun.net/v3/sandbox08e8cef4bab242e8be222b41f9dbcd00.mailgun.org/messages");
//	    MultivaluedMapImpl formData = new MultivaluedMapImpl();
//	    formData.add("from", "Mailgun Sandbox <postmaster@sandbox08e8cef4bab242e8be222b41f9dbcd00.mailgun.org>");
//	    formData.add("to", "Vamsi Ravi <ivamsiravi@gmail.com>");
//	    formData.add("subject", "Hello Vamsi Ravi");
//	    formData.add("text", "Congratulations Vamsi Ravi, you just sent an email with Mailgun!  You are truly awesome!");
//	    return webResource.type(MediaType.APPLICATION_FORM_URLENCODED).
//	                                        post(String.class, formData);
		return to+from+subject+text;
	}
	// You can see a record of this email in your logs: https://mailgun.com/app/logs .

	// You can send up to 300 emails/day from this sandbox server.
	// Next, you should add your own domain so you can send 10,000 emails/month for free.
	
}
