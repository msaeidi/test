package mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	private int port = 587;

	private String host = "smtp.gmail.com";

	private String from = "saeidimo@gmail.com";
	
	private boolean debug = true;
	
	public void sendEmail(String to, String subject, String body) {
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		//TODO need work
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		//http://stackoverflow.com/questions/6610572/javax-mail-authenticationfailedexception-failed-to-connect-no-password-specifi
		props.put("mail.smtp.user", "saeidimo@gmail.com");
		//props.put("mail.smtp.password", "");
		//props.put("PassWord", "");
		//props.put("password", "");
		
	  //  props.put("mail.smtp.host", config.host);
	  //  props.put("mail.smtp.user", config.username);
	  //  props.put("mail.smtp.port", config.port);
	  //  props.put("mail.smtp.password", config.password);

	    Session session = Session.getDefaultInstance(props,
	    	    new Authenticator() {
	    	        protected PasswordAuthentication  getPasswordAuthentication() {
	    	        return new PasswordAuthentication(
	    	                    "saeidimo@gmail.com", "missina2000");
	    	                }
	    	    });
	 
//	    		auth="Container"
//	    	    type="javax.mail.Session"
//	    	    mail.smtp.host="mail.mycompany.com"
//	    	    mail.smtp.port="587"
//	    	    mail.smtp.auth="true"
//	    	    mail.smtp.user="jira@mycompany.com"
//	    	    password="mypassword"
//	    	    mail.smtp.starttls.enable="true"
//	    	    mail.smtp.socketFactory.class="javax.net.ssl.SSLSocketFactory"
//		Session session = Session.getInstance(props, null);
		session.setDebug(debug);
		MimeMessage message = new MimeMessage(session);
		try {
			//message.
			//InternetAddress from = new InternetAddress("sanz@eircom.net");
			//message.setFrom(from);
			message.setFrom(new InternetAddress(from));
			InternetAddress[] address = {new InternetAddress(to)};
			message.setRecipients(Message.RecipientType.TO, address);
			message.setSubject(subject);
			message.setSentDate(new Date());
			message.setText(body);
			Transport.send(message);
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
	}
}