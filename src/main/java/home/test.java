package home;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;
 
public class test {
	
	private static final String inputFile = "C:/Users/MO/KeyAndCounts.txt";

	public static void main(String[] args){
		 System.setProperty("file.encoding", "UTF-8");

		try {
			File file = new File(inputFile);
			byte inbytes[] = new byte[1024];
			FileInputStream fis = new FileInputStream(inputFile);
		    //FileInputStream fis = new FileInputStream(file);
			fis.read(inbytes);
			String in = new String(inbytes, "UTF8");
			byte[] bt = in.getBytes();
/*
			StringReader r = new StringReader (string);
			ByteArrayOutputStream buffer = new ByteArrayOutputStream (1024*2); // Twice as large as necessary

			char[] cbuf = new char[100];
			byte[] tempBuf;
			int len;
			while ((len = r.read(cbuf, 0, cbuf.length)) > 0) {
			    w.write(cbuf, 0, len);
			    w.flush();
			    if (buffer.size() >= 1024) {
			        tempBuf = buffer.toByteArray();
			        //... ready to process one chunk ...
			        buffer.reset();
			        if (tempBuf.length > 1024) {
			            buffer.write(tempBuf, 1024, tempBuf.length - 1024);
			        }
			    }
			}
			//... check if some data is left in buffer and process that, too ...
*/			
			String safe = new String (inbytes, "iso-8859-1");
			int pos = safe.indexOf('\u0000');
			byte[] data = safe.getBytes("iso-8859-1");
			String pause = "";
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

