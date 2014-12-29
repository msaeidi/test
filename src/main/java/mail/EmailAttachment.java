package mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailAttachment {
	private static final Logger log = LoggerFactory.getLogger(EmailSendingExample.class);
	private static final ApplicationContext context = new ClassPathXmlApplicationContext("/home/SpringEmail.xml");
	private static final JavaMailSenderImpl mailSender = (JavaMailSenderImpl) context.getBean("mailSender");

	public static void main( String[] args ) {

		String from = "saeidimo@gmail.com";
		String password = "missina2000";
		String to = "mohammadsaeedi@yahoo.com";
		String subject = "Testing email using only one extra file (xml)";
		String body = "Testing only \n\n Hello From Spring Email Sender... [%s] ... [%s]";
       
		try {
			mailSender.setUsername(from);
			mailSender.setPassword(password);
		
			MimeMessage message = mailSender.createMimeMessage();
			   
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
		 
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(String.format(body, "XXXX", "YYYY"));
		 
			FileSystemResource file = new FileSystemResource("C:/Users/Mo/keyCounts.txt");
			helper.addAttachment(file.getFilename(), file);
			mailSender.send(message);
			System.out.print("email was sent successfully: " + helper.toString());
		} catch (MessagingException e) {
			throw new MailParseException(e);
		} catch(Exception ex) {
			log.error("Message sending failed..", ex);
		}
		
	}
}
