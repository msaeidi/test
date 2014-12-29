package mail;

import java.io.Serializable;

import org.springframework.mail.SimpleMailMessage;

public class MailMessage extends SimpleMailMessage implements Serializable{
	
	private static final long serialVersionUID = 5198736540299307038L;

	private String password;

	public MailMessage(String password) {
		super();
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	
    @Override
    public String toString() {
        return String.format("message: to[%s], from[%s], with subject [%s] and text[%s] (cc: [%s])",
                this.getTo()[0], this.getFrom(), this.getSubject(), this.getText(), this.getCc()!=null ? this.getCc()[0] : "None");
    }
}
