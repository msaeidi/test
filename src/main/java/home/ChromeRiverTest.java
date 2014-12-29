package home;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ChromeRiverTest {
	
	//Read the following file: https://staging.chromeriver.com/eval/file.txt
	private static final String inputFileUrl = "https://staging.chromeriver.com/eval/file.txt";

	//create a new file
	private static final String outputFile = "C:/Users/MO/outputFile.txt";

	private static final int maxCharsPerLine = 50;

	public static void main(String[] args) {

		try{
			//Define the reader:
			URL url = new URL(inputFileUrl);
            InputStream inputStream = url.openStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            //Define the writer
			File file = new File(outputFile);
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			

			String inputLine = null;
			//initialize the outputLine & number of characters of the output line
			String outputLine = ""; int lineChars = 0;

			while ((inputLine = bufferedReader.readLine()) != null) {
				if(inputLine.length() != 0 && !inputLine.trim().equals("")) {
					String[] words = inputLine.split(" ");
					for (String word: words){
						lineChars += word.length();
						if(lineChars > maxCharsPerLine){
							//Each line in the file should not have more than 50 characters
							bufferedWriter.write(outputLine);
							//initialize the outputLine & number of characters of the output line
							outputLine = ""; lineChars = 0;
							bufferedWriter.newLine();
						}
						outputLine += (outputLine.equals("") ? "" : " ") + word;
					}
				}
				bufferedWriter.write(outputLine);
				//initialize the outputLine & number of characters of the output line
				outputLine = ""; lineChars = 0;
				bufferedWriter.newLine();
			}
			bufferedReader.close();
			bufferedWriter.close();
		} catch (MalformedURLException me) {
			System.out.println(me.getMessage());
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		} catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	/*
	 * Please modify the outputFile folder to your appropriate and run the main application:
	 * 
	 * The generated output:
 
California's climate varies from Mediterranean to
subarctic. Much of the state has a Mediterranean climate, with cool,
rainy winters and dry summers. The cool California Current
offshore often creates summer fog near the coast. Farther inland,
one encounters colder winters and hotter summers.
Northern parts of the state average higher annual rainfall
than the south. California's mountain ranges influence the
climate as well: some of the rainiest parts of the state are
west-facing mountain slopes. Northwestern California has a temperate
climate, and the Central Valley has a Mediterranean climate but with
greater temperature extremes than the coast. The high mountains,
including the Sierra Nevada, have an alpine climate with snow in
winter and mild to moderate heat in summer.

The east sides of California’s mountains produce a rain
shadow, creating expansive deserts. The higher elevation deserts
of eastern California see hot summers and cold winters, while
the low deserts east of the southern California mountains
experience hot summers and nearly frost less mild winters. Death
Valley, a desert with large expanses below sea level, is considered
the hottest location in North America; the highest
temperature in the Western Hemisphere, 134 °F (57 °C), was recorded
there on July 10, 1913. The lowest temperature in California was
−45 °F in 1937 in Boca.

	 */
}
