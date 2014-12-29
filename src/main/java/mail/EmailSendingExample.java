package mail;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class EmailSendingExample {
	private static final Logger log = LoggerFactory.getLogger(EmailSendingExample.class);
	//private static final ApplicationContext context = new ClassPathXmlApplicationContext("/home/SpringEmail.xml");
	//private static final JavaMailSenderImpl mailSender = (JavaMailSenderImpl) context.getBean("mailSender");

	public static void main( String[] args ) {
		
		
		
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		javaMailSender.setHost("smtp.gmail.com");
		javaMailSender.setPort(587);
		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.auth", true);
		javaMailProperties.put("mail.smtp.starttls.enable", true);
		javaMailSender.setJavaMailProperties(javaMailProperties);
		javaMailSender.setUsername("saeidimo@gmail.com");
		javaMailSender.setPassword("missina2000");
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		simpleMessage.setFrom("saeidimo@gmail.com");
		simpleMessage.setTo("mohammadsaeedi@yahoo.com");
		simpleMessage.setSubject("Testing email using only one extra file (xml)");
		simpleMessage.setText(String.format("Last Testing \n\n %s From %s ...@@@@@@@@@@@@@@", "Hello", "Spring Email Sender"));
    
		javaMailSender.send(simpleMessage);
	
		
	/*	
		
		
		String from = "saeidimo@gmail.com";
		String password = "missina2000";
		String to = "mohammadsaeedi@yahoo.com";
		String subject = "Testing email using only one extra file (xml)";
		String body = "Testing only \n\n %s From %s ...";
        
		try {
			mailSender.setUsername(from);
			mailSender.setPassword(password);
		
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setFrom(from);
			simpleMailMessage.setTo(to);
			simpleMailMessage.setSubject(subject);
			simpleMailMessage.setText(String.format(body, "Hello", "Spring Email Sender"));
        
			mailSender.send(simpleMailMessage);
			log.info("@@@$@@@email was sent successfully: " + simpleMailMessage.toString());
			System.out.print("email was sent successfully: " + simpleMailMessage.toString());
		} catch(Exception ex) {
			log.error("Message sending failed..", ex);
		}
*/	
	}
}
