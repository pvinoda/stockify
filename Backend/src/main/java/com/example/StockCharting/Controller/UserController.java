package com.example.StockCharting.Controller;

import java.util.Optional;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.StockCharting.Entity.User1;
import com.example.StockCharting.*;
import com.example.StockCharting.Repository.UserRepository;
import com.example.StockCharting.*;

@RestController
@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
public class UserController {
	@Autowired
	UserRepository userrepo;
	
	@CrossOrigin(origins ="http://localhost:4200")

	@RequestMapping(value = "/setuserapi",method=RequestMethod.POST)
	
	public User1 Stringreactuserapi(@RequestBody User1 user) throws AddressException, MessagingException {	
	
		User1 usrsaved = userrepo.save(user);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Responded", "UserController");
		headers.add("Access-Control-Allow-Origin", "*");
		sendemail(user.getId());
		
		return user;
	}
	public void sendemail(Long userid) throws AddressException, MessagingException {

	      User1 user = userrepo.getById(userid);	




			final String username = "mwaanytnheu@gmail.com";
			final String password = "Manthu@1217";
			

			Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.port", "587");
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.starttls.enable", "true"); //TLS
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.port", "465");
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.starttls.enable", "true");
			prop.put("mail.smtp.starttls.required", "true");
			prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
			prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

			Session session = Session.getInstance(prop,
					new javax.mail.Authenticator() {
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
					return new javax.mail.PasswordAuthentication(username, password);
				}
			});

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("mwaanytnheu@gmail.com"));
				//message.setRecipients(
					//	Message.RecipientType.TO,
					//	InternetAddress.parse("sftrainerram@gmail.com")
					//	);
				message.setRecipients(
						Message.RecipientType.TO,
						InternetAddress.parse(user.getEmail())
						);
				message.setSubject("User confirmation email");
				//     message.setText("Dear Mail Crawler,"
				//           + "\n\n Please do not spam my email!");
				message.setContent(
						"<h1><a href =\"http://127.0.0.1:8080/confirmuser/"+userid+"/\"> Click to confirm </a></h1>",
						"text/html");
				
				Transport.send(message);

				System.out.println("Done");

			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}

		@RequestMapping(value="/confirmuser/{userid}", method=RequestMethod.GET)
		public String welcomepage(@PathVariable Long userid) {
			Optional<User1> userlist =   userrepo.findById(userid);
			if(userlist.isEmpty()) {
				return "no users saved";
			}
			//do a null check for home work
			User1 usr = new User1();
			usr = userrepo.getById(userid);
			usr.setConfirmed(true);
			userrepo.save(usr);
			return "User confirmed " +usr.getUsername();
		}

}
