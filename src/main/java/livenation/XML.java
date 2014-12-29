package livenation;

import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//Dylan Campbell: LiveNation Screening 3

import org.exolab.castor.xml.Marshaller;

public class XML {

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
		  //Marshaller marshaller = new Marshaller(writer);// was wrong
		  Marshaller.marshal(xmlObject, writer);
		  System.out.println(writer.toString());		  
	   	}

}
