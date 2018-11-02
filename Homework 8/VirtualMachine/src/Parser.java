/**
 * @author Raul Aguilar
 * @date November 7, 2018
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Parser {

    private Scanner inputFile;
    private int lineNumber;
    private String rawLine, cleanLine;

    public void Parser(String fileName) {
        try {
            inputFile = new Scanner(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found. Ending program.");
            System.exit(0);
        }
    }

    public boolean hasMoreCommands() {
        if( inputFile.hasNextLine() ) {
            return true;
        } else {
            inputFile.close();
            return false;
        }
    }

    public void advance() {
        lineNumber++;
        rawLine = inputFile.nextLine();
        cleanLine();
    }

    private void cleanLine() {
        int commentLocation;

        if(rawLine == null) {
            cleanLine = "";
        } else {
            // remove whitespace
            cleanLine = rawLine.replaceAll(" ","");

            //remove comments
            commentLocation = rawLine.indexOf("//");
            if(commentLocation != -1) {
                cleanLine = rawLine.substring(0,commentLocation);
            }
        }
    }

    /**
     * Getter for rawLine
     * @return String
     */
    public String getRawLine() {
        return rawLine;
    }
    public String getCleanLine() {
        return cleanLine;
    }
}
