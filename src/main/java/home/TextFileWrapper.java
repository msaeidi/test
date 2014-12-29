package home;
import java.io.*;
import java.net.URL;
import java.util.StringTokenizer;

public class TextFileWrapper {

	private static final String urlText = "https://staging.chromeriver.com/eval/file.txt";
	private static final int maxChars = 50;

	public static void main(String args[]){
		TextFileWrapper tfw = new TextFileWrapper();
		tfw.convert(urlText, "./output.txt");
	}


	public void convert(String urlInput, String fileOutput){
		try{
			File file = new File(fileOutput);
			URL url = new URL(urlInput);
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String line = null;
			int lineChars = 0;
			String limitedLine = "";
			String word = "";
			while ((line = reader.readLine()) != null)
			{
				if(line.length() == 0) {
					writer.write(limitedLine);
					limitedLine = "";
					lineChars = 0;
					writer.newLine();
					writer.newLine();
					continue;
				}
				StringTokenizer stringTokenizer = new StringTokenizer(line);
				while (stringTokenizer.hasMoreTokens()){
					word = stringTokenizer.nextToken();
					lineChars += word.length();
					if(lineChars > maxChars){
						writer.write(limitedLine);
						limitedLine = "";
						lineChars = 0;
						writer.newLine();
					}
					limitedLine = limitedLine + " " + word;
				}
			}
			reader.close();
			writer.close();
		}
		catch(Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}