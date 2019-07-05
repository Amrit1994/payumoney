package com.toi.util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*; 

import com.toi.model.Youtube;
 
public class SendMail{
    boolean a;
    String to;
    String mainMsg="";
 public void data(final String from,final String password,String to,String sub,String msg,Youtube yt) {  
	//Get the session object 
			mainMsg = msg;
            msg="<html><body><div><p><b><u>You have a new video link.</u></b></p>" +
            		"<p><b>Name</b>:"+yt.getName()+"</p>" +
            		"<p><b>Email</b>:"+yt.getEmail()+"</p>" +
            		"<p><b>Mobile</b>:"+yt.getMobile()+"</p>" +
            		"<p><b>Date of Birth</b>:"+yt.getDob()+"</p>" +
            		"<p><b>Address</b>:"+yt.getAddress()+"</p>" +
            		"<p><b>State</b>:"+yt.getState()+"</p>" +
            		"<p><b>City</b>:"+yt.getCity()+"</p>" +
            		"<p><b>Pincode</b>:"+yt.getPincode()+"</p>" +
            		"<p><b>Video Link</b>:"+yt.getVideolink()+"</p>" +
            		"<br/><br/><p>thanks and regards,</p>" +
            		"<a href='https://www.talentofindia.co.in'><img src='https://www.talentofindia.co.in/images/logo1.png' height='100px' width='150px'></img></a></div></body></html>`";
	 		
			Properties props = new Properties(); 
			//props.put("mail.smtp.host", "mail.starpublicity.org"); 
			//props.put("mail.smtp.socketFactory.port", "2525"); 
			    //props.put("mail.smtp.socketFactory.class", 
			    //"javax.net.ssl.SSLSocketFactory"); 
			//props.put("mail.smtp.auth", "true"); 
			//props.put("mail.smtp.port", "2525"); 
			 props.put("mail.smtp.host", "smtp.gmail.com");    
	         props.put("mail.smtp.socketFactory.port", "465");    
	         props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");    
	         props.put("mail.smtp.auth", "true");    
	         props.put("mail.smtp.port", "465");    
			Session session = Session.getDefaultInstance(props, 
			new javax.mail.Authenticator() { 
			protected PasswordAuthentication getPasswordAuthentication() { 
			return new PasswordAuthentication(from,password); 
			} 
			}); 

			//compose message 
			
			try { 
				MimeMessage message = new MimeMessage(session); 
				message.setFrom(new InternetAddress(from)); 
			  	//InternetAddress[] address = {new InternetAddress(to)};
			  	//working correctly 		  message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			  	message.setRecipients(Message.RecipientType.TO, InternetAddress.parseHeader(to,false));
			  	// message.setRecipients(Message.RecipientType.TO, address);
			  	message.setSubject(sub); 
			  	// This mail has 2 part, the BODY and the embedded image
		         MimeMultipart multipart = new MimeMultipart("related");
		         // first part (the html)
		         BodyPart messageBodyPart = new MimeBodyPart();
		         String htmlText = msg;
		         messageBodyPart.setContent(htmlText, "text/html");
		         // add it
		         multipart.addBodyPart(messageBodyPart);
		         // put everything together
		         message.setContent(multipart);
			     //message.setText(msg);  
			     //send message 
			     Transport.send(message); 
			     System.out.println("mail sent successfully to the contact person"); 
			} catch (MessagingException e) {System.out.println(e);}	
 } 
 
 public void mailToContactPerson(final String from,final String password,String to,String sub,String msg) {  
		//Get the session object 
				mainMsg = msg;
	            msg="<html><body><div><p>Thank You for Contacting  us, we will upload your video as soon as possible." +
	            		"</p><br/><p>thanks and regards,</p><p>Talent of India</p>" +
	            		"<a href='https://www.talentofindia.co.in'><img src='https://www.talentofindia.co.in/images/logo1.png' height='100px' width='150px'></img></a>"+
	        			"</div></body></html>";
		 		
				Properties props = new Properties(); 
				 props.put("mail.smtp.host", "smtp.gmail.com");    
		         props.put("mail.smtp.socketFactory.port", "465");    
		         props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");    
		         props.put("mail.smtp.auth", "true");    
		         props.put("mail.smtp.port", "465");  

				Session session = Session.getDefaultInstance(props, 
				new javax.mail.Authenticator() { 
				protected PasswordAuthentication getPasswordAuthentication() { 
				return new PasswordAuthentication(from,password); 
				} 
				}); 

				//compose message 
				
				try { 
					MimeMessage message = new MimeMessage(session); 
					message.setFrom(new InternetAddress(from)); 
				  	//InternetAddress[] address = {new InternetAddress(to)};
				  	//working correctly 		  message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
				  	message.setRecipients(Message.RecipientType.TO, InternetAddress.parseHeader(to,false));
				  	// message.setRecipients(Message.RecipientType.TO, address);
				  	message.setSubject(sub); 
				  	// This mail has 2 part, the BODY and the embedded image
			         MimeMultipart multipart = new MimeMultipart("related");
			         // first part (the html)
			         BodyPart messageBodyPart = new MimeBodyPart();
			         String htmlText = msg;
			         messageBodyPart.setContent(htmlText, "text/html");
			         // add it
			         multipart.addBodyPart(messageBodyPart);
			         // put everything together
			         message.setContent(multipart);
				     //message.setText(msg);  
				     //send message 
				     Transport.send(message); 
				     System.out.println("mail sent successfully to the admin"); 
				} catch (MessagingException e) {System.out.println(e);}	
	 } 
 
 
 public void mailToContactWebsiteForm(final String from,final String password,String to,String sub,String msg) {  
		//Get the session object 
				mainMsg = msg;
	            msg="<html><body><div><p>Thank You for Contacting  us, we will get back to you as soon as possible." +
	            		"</p><br/><p>thanks and regards,</p><p>Talent of India</p>" +
	            		"<a href='https://www.talentofindia.co.in'><img src='https://www.talentofindia.co.in/images/logo1.png' height='100px' width='150px'></img></a>"+
	        			"</div></body></html>";
		 		
				Properties props = new Properties(); 
				props.put("mail.smtp.host", "mail.starpublicity.org"); 
				props.put("mail.smtp.socketFactory.port", "2525"); 
				//props.put("mail.smtp.socketFactory.class", 
				//"javax.net.ssl.SSLSocketFactory"); 
				props.put("mail.smtp.auth", "true"); 
				props.put("mail.smtp.port", "2525"); 
				
				 props.put("mail.smtp.host", "smtp.gmail.com");    
		         props.put("mail.smtp.socketFactory.port", "465");    
		         props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");    
		         props.put("mail.smtp.auth", "true");    
		         props.put("mail.smtp.port", "465");  

				Session session = Session.getDefaultInstance(props, 
				new javax.mail.Authenticator() { 
				protected PasswordAuthentication getPasswordAuthentication() { 
				return new PasswordAuthentication(from,password); 
				} 
				}); 

				//compose message 
				
				try { 
					MimeMessage message = new MimeMessage(session); 
					message.setFrom(new InternetAddress(from)); 
				  	//InternetAddress[] address = {new InternetAddress(to)};
				  	//working correctly 		  message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
				  	message.setRecipients(Message.RecipientType.TO, InternetAddress.parseHeader(to,false));
				  	// message.setRecipients(Message.RecipientType.TO, address);
				  	message.setSubject(sub); 
				  	// This mail has 2 part, the BODY and the embedded image
			         MimeMultipart multipart = new MimeMultipart("related");
			         // first part (the html)
			         BodyPart messageBodyPart = new MimeBodyPart();
			         String htmlText = msg;
			         messageBodyPart.setContent(htmlText, "text/html");
			         // add it
			         multipart.addBodyPart(messageBodyPart);
			         // put everything together
			         message.setContent(multipart);
				     //message.setText(msg);  
				     //send message 
				     Transport.send(message); 
				     System.out.println("mail sent successfully to the admin"); 
				} catch (MessagingException e) {System.out.println(e);}	
	 }
 
 
 public void mailToContactAdmin(final String from,final String password,String to,String sub,String name,String email,String subj,String msg,String mobile) {  
		//Get the session object 
				mainMsg = msg;
				msg="<html><body><div><p><b><u>You have a new message from Talent of India.</u></b></p>" +
	            		"<p><b>Name</b>:"+name+"</p>" +
	            		"<p><b>Email</b>:"+email+"</p>" +
	            		"<p><b>Mobile</b>:"+mobile+"</p>" +
	            		"<p><b>Subject</b>:"+subj+"</p>" +
	            		"<p><b>Message</b>:"+msg+"</p>" +
	            	    "<br/><br/><p>thanks and regards,</p>" +
	            		"<a href='https://www.talentofindia.co.in'><img src='https://www.talentofindia.co.in/images/logo1.png' height='100px' width='150px'></img></a></div></body></html>`";
		 			
				Properties props = new Properties(); 
				props.put("mail.smtp.host", "mail.starpublicity.org"); 
				props.put("mail.smtp.socketFactory.port", "2525"); 
				//props.put("mail.smtp.socketFactory.class", 
				//"javax.net.ssl.SSLSocketFactory"); 
				props.put("mail.smtp.auth", "true"); 
				props.put("mail.smtp.port", "2525"); 
				
				// props.put("mail.smtp.host", "smtp.gmail.com");    
		        // props.put("mail.smtp.socketFactory.port", "465");    
		        // props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");    
		        // props.put("mail.smtp.auth", "true");    
		        // props.put("mail.smtp.port", "465");  

				Session session = Session.getDefaultInstance(props, 
				new javax.mail.Authenticator() { 
				protected PasswordAuthentication getPasswordAuthentication() { 
				return new PasswordAuthentication(from,password); 
				} 
				}); 

				//compose message 
				
				try { 
					MimeMessage message = new MimeMessage(session); 
					message.setFrom(new InternetAddress(from)); 
				  	//InternetAddress[] address = {new InternetAddress(to)};
				  	//working correctly 		  message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
				  	message.setRecipients(Message.RecipientType.TO, InternetAddress.parseHeader(to,false));
				  	// message.setRecipients(Message.RecipientType.TO, address);
				  	message.setSubject(sub); 
				  	// This mail has 2 part, the BODY and the embedded image
			         MimeMultipart multipart = new MimeMultipart("related");
			         // first part (the html)
			         BodyPart messageBodyPart = new MimeBodyPart();
			         String htmlText = msg;
			         messageBodyPart.setContent(htmlText, "text/html");
			         // add it
			         multipart.addBodyPart(messageBodyPart);
			         // put everything together
			         message.setContent(multipart);
				     //message.setText(msg);  
				     //send message 
				     Transport.send(message); 
				     System.out.println("mail sent successfully to the admin"); 
				} catch (MessagingException e) {System.out.println(e);}	
	 }
 
}  