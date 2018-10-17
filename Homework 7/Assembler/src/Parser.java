/**
 * @author  Raul Aguilar
 * @class   CS 220 2525
 * @date    October 24, 2018
 */
import java.io.*;
import java.util.Scanner;

public class Parser {
    public static final char NO_COMMAND = 'N';
    public static final char A_COMMAND = 'A';
    public static final char C_COMMAND = 'C';
    public static final char L_COMMAND = 'L';

    private int lineNumber;
    private String rawLine;
    private String cleanLine;
    private char commandType;
    private String symbol;
    private String destMnemonic;
    private String compMnemonic;
    private String jumpMnemonic;

    /**
     * Opens input file and prepares to parse
     * If files can't be opened, ends program with error message
     * @param inFileName the name of the asm file
     */
    public void Parser(String inFileName) {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(inFileName));
            while( hasMoreCommands(br) ) {
                advance(br);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found. Ending program.");
            System.exit(0);
        }
    }

    /**
     * Returns boolean if more commands left, closes stream if not
     * @param br BufferedReader to stream-in file
     * @return True if more commands, else closes stream
     */
    public boolean hasMoreCommands(BufferedReader br) {
        String line;
        boolean hasMoreCommands = false;
        try {
            if( (line = br.readLine() ) != null ) {
                hasMoreCommands = true;
            } else {
                hasMoreCommands = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hasMoreCommands;
    }

    /**
     * Reads next line from file and pares it into rawLine
     * @param br BufferedReader to stream-in file
     */
    public void advance(BufferedReader br) {
        try {
            rawLine = br.readLine();
            System.out.println(rawLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads raw line from file and stripes line of whitespace and comments
     * @param rawLine String of a single line from file before cleaned
     * @return String of clean line without comments and whitespace
     */
    private static String cleanLine (String rawLine) {
        String clean;
        int commentLocation;

        // remove whitespace
        clean = rawLine.replaceAll(" ","");
        clean = clean.replaceAll("\t","");

        // remove comments
        commentLocation = clean.indexOf("//");
        if(commentLocation != -1) {
            clean = clean.substring(0,commentLocation);
        }

        return clean;
    }

    /**
     * Guesses which command type it is from cleaned line
     * @param clean String clean line without comments or whitespace
     * @return Char corresponding to guessed command type
     */
    private static char parseCommandType(String clean) {

        if( clean == null || clean.length() == 0) {
            return NO_COMMAND; //N
        }

        char first = clean.charAt(0);
        if (first == '(') {
            return L_COMMAND; // L
        } else if (first == '@') {
            return A_COMMAND; // A
        } else {
            return C_COMMAND; // C
        }
    }
}
