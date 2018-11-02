/**
 * @author  Raul Aguilar
 * @date    November 7, 2018
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Parser {

    private Scanner inputFile;

    /**
     * Opens input file and prepares to parse
     * If files can't be opened, ends program with error message
     * @param inFileName the name of the asm file
     */
    public void Parser(String inFileName) {
        try {
            inputFile = new Scanner(new FileReader(inFileName));
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found. Ending program.");
            System.exit(0);
        }
    }

    /**
     * Returns boolean if more commands left, closes stream if not
     * @return True if more commands, else closes stream
     */
    public boolean hasMoreCommands() {
        if( inputFile.hasNextLine() ) {
            return true;
        } else {
            inputFile.close();
            return false;
        }
    }

    /**
     * Reads next line from file and pares it into instance vars
     * Current instruction parts put into instance vars
     */
    public void advance() {

    }
}
