package livenation;
import java.io.Serializable;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.exolab.castor.xml.Marshaller;
//Dylan Campbell: LiveNation Screening 3

public class NewXML implements Serializable {

	private static final long serialVersionUID = 4695088942313869243L;

	public static void main(String[] args) throws Exception {
		  long customerID = 345; 
		  String customerEmail = "customer345@company.com"; 
		  float customerCreditLimit = 235.50f; 
		  SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy");      
		  Date date;
		  try {
			date = sdf.parse("JAN 03,2009");
		  } catch (ParseException e) {
			e.printStackTrace();
			date = null;
		  }
		  TheXMLObject xmlObject = new TheXMLObject(customerID, customerEmail, customerCreditLimit, date);
		  StringWriter writer = new StringWriter();
		  Marshaller.marshal(xmlObject, writer);
		  System.out.println(writer.toString());		  
   	}
}
