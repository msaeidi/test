package livenation;
import java.io.Serializable;
import java.util.Date;
//Dylan Campbell: LiveNation Screening 3

public class TheXMLObject implements Serializable {

	private static final long serialVersionUID = 436164770465428955L;
	
	private long customerID; 
	private String customerEmail; 
	private float customerCreditLimit; 
	private Date date; 
	  
	public TheXMLObject(long customerID, String customerEmail, float customerCreditLimit, Date date) {
		this.customerID = customerID;
		this.customerEmail = customerEmail;
		this.customerCreditLimit = customerCreditLimit;
		this.date = date;
	  }
	  
	public long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public float getCustomerCreditLimit() {
		return customerCreditLimit;
	}

	public void setCustomerCreditLimit(float customerCreditLimit) {
		this.customerCreditLimit = customerCreditLimit;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
