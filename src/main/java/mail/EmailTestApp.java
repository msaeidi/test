package mail;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class EmailTestApp {
	private static final ApplicationContext context = new ClassPathXmlApplicationContext("/home/SpringEmail.xml");
	private static final EmailSendingUtil emailSendingUtil = (EmailSendingUtil) context.getBean("emailSendingUtil");

	public static void main( String[] args ) {

		String from = "saeidimo@gmail.com";
		String password = "xxxxxxxxxxxxx";
		String to = "mohammadsaeedi@yahoo.com";
		String subject = "Testing email";
		String body = "Testing only \n\n Hello From Spring Email Sender....................";
        
		MailMessage mailMessage = new MailMessage(password);
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        //mailMessage.setCc("");
        mailMessage.setSubject(subject);
        mailMessage.setText(body);
		emailSendingUtil.sendEmailMessage(mailMessage);
	}
}
