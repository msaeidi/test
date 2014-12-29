package mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class EmailSendingExample1 {
	private static final Logger log = LoggerFactory.getLogger(EmailSendingExample1.class);
	private static final ApplicationContext context = new ClassPathXmlApplicationContext("/mail/SpringEmail.xml");
	private static final JavaMailSenderImpl mailSender = (JavaMailSenderImpl) context.getBean("mailSender");

	public static void main( String[] args ) {

		String from = "saeidimo@gmail.com";
		String password = "missina2000";
		String to = "mohammadsaeedi@yahoo.com";
		String subject = "Testing email using only one extra file (xml)";
		String body = "Testing only \n\n Hello From Spring Email Sender...";
        
		try {
			mailSender.setUsername(from);
			mailSender.setPassword(password);
		
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setFrom(from);
			simpleMailMessage.setTo(to);
			simpleMailMessage.setSubject(subject);
			simpleMailMessage.setText(body);
        
			mailSender.send(simpleMailMessage);
			log.info("@@@$@@@email was sent successfully: " + simpleMailMessage.toString());
			log.debug("@@@$@@@email was sent successfully: " + simpleMailMessage.toString());
			log.error("@@@$@@@email was sent successfully: " + simpleMailMessage.toString());
			log.info("@@@$@@@email was sent successfully: " + simpleMailMessage.toString());
			System.out.print("email was sent successfully: " + simpleMailMessage.toString());
		} catch(Exception ex) {
			log.error("Message sending failed..", ex);
		}
	}
}
