import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchStringInFiles {
    public static void main(String[] args) {
    	
        if (args.length != 2) {
            System.out.println("Usage: java FileSearch <pattern> <file>");
            return;
        }

        String string = args[0];
        String fileName = args[1];

        searchFile(string, fileName);
    }

    private static void searchFile(String string, String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            int lineNumber = 0;
            
            System.out.println("Search word: " + string + "\n" + "In file: " + fileName);
            System.out.println("Word found in line: ");
            
            while (line != null) { 
                lineNumber++;
                
                if (line.contains(string)) {
                    System.out.println(lineNumber + ": " + line);
                }
                
                line = br.readLine();
            }
        } catch (IOException e) {
            System.err.println("Can't find file " + e.getMessage());
        }
    }
}

