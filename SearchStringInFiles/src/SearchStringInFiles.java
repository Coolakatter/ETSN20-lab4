import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchStringInFiles {
    public static void main(String[] args) {
    	
        if (args.length != 2) {
            System.out.println("Usage: java FileSearch <pattern> <file>");
            return;
        }

        String pattern = args[0];
        String fileName = args[1];

        searchFile(pattern, fileName);
    }

    private static void searchFile(String pattern, String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            int lineNumber = 0;
            boolean foundOnce = false;
            
            System.out.println("Search word: " + pattern + "\n" + "In file: " + fileName);   
            
            while (line != null) { 
                lineNumber++;
                
                if (line.toLowerCase().contains(pattern.toLowerCase())) {
                	if(!foundOnce) {
                		System.out.println("Word found in line: ");
                	}
                	foundOnce = true;
                    System.out.println(lineNumber + ": " + line);
                }
                
                line = br.readLine();
            }
            
            if(!foundOnce) {
            	System.out.println("Word not found in file.");
            }
        } catch (IOException e) {
            System.err.println("Can't find file " + e.getMessage());
        }
    }
}

