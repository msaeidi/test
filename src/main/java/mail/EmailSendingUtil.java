package mail;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
 
public class EmailSendingUtil
{
	private JavaMailSenderImpl mailSender;
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailSendingUtil.class);
 
	public void setMailSender(JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}
 
	public void sendEmailMessage(MailMessage mailMessage) {
		try {
			if(LOGGER.isDebugEnabled()) {
                LOGGER.debug("email message [{}]", mailMessage);
            }
            mailSender.setUsername(mailMessage.getFrom());
            mailSender.setPassword(mailMessage.getPassword());
           
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage(mailMessage);
            mailSender.send(simpleMailMessage);
            LOGGER.info("email was sent successfully: " + simpleMailMessage.toString());
         } catch(Exception e) {
        	 LOGGER.error(String.format("Message sending failed for [%s]", mailMessage), e);
       }
	}
}

