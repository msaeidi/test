package livenation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.map.ObjectMapper;
//Dylan Campbell: LiveNation Screening 4

public class JSON {

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
		  TheJSONObject jsonObject = new TheJSONObject(customerID, customerEmail, customerCreditLimit, date);
		  ObjectMapper mapper = new ObjectMapper();
		  System.out.println(mapper.writeValueAsString(jsonObject));		  
	   	}

}
