package mail;


public class EmailTest {
	
	public static void main(String[] args) {
		testEmail();
	}
	  
	private static void testEmail() {
		String to = "mo.saeidi@icloud.com";
		String subject = "Test message";
		String body = "This is a test email";
		 
		(new Mail()).sendEmail(to, subject, body);
	}
} 
