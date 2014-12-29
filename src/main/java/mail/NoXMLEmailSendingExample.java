package mail;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class NoXMLEmailSendingExample {
	private static final Logger log = LoggerFactory.getLogger(NoXMLEmailSendingExample.class);

	public static void main( String[] args ) {

		String from = "saeidimo@gmail.com";
		String password = "missina2000";
		String to = "mohammadsaeedi@yahoo.com";
		String subject = "Testing email using only one extra file (xml)";
		String body = "Testing only \n\n %s From %s ...";

		try {
			JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
			javaMailSender.setHost("smtp.gmail.com");
			javaMailSender.setPort(587);
			Properties javaMailProperties = new Properties();
			javaMailProperties.put("mail.smtp.auth", true);
			javaMailProperties.put("mail.smtp.starttls.enable", true);
			javaMailSender.setJavaMailProperties(javaMailProperties);
			javaMailSender.setUsername(from);
			javaMailSender.setPassword(password);
			SimpleMailMessage simpleMessage = new SimpleMailMessage();
			simpleMessage.setFrom(from);
			simpleMessage.setTo(to);
			simpleMessage.setSubject(subject);
			simpleMessage.setText(String.format(body, "Helllllllllloooooo", "Spring Email Sender"));
	    
			javaMailSender.send(simpleMessage);
			log.info("@@@$@@@email was sent successfully: " + simpleMessage.toString());
			System.out.print("email was sent successfully: " + simpleMessage.toString());
		} catch(Exception ex) {
			log.error("Message sending failed..", ex);
		}
	}
}
