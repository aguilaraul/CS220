/*
    @author Raul Aguilar
    @date November 7, 2018
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Parser {
    public static final char NO_COMMAND = 'N';
    public static final char C_ARITHMETIC = 'A';
    public static final char C_PUSH = 'U';
    public static final char C_POP = 'P';
    public static final char C_LABEL = 'L';

    private Scanner inputFile;
    private String[] commands;
    private int lineNumber;
    private String rawLine, cleanLine;
    private char commandType;

    /**
     * Opens the input file and gets ready to parse it
     * @param fileName name of input file
     */
    public void Parser(String fileName) {
        try {
            inputFile = new Scanner(new FileReader(fileName));
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
        lineNumber++;
        rawLine = inputFile.nextLine();
        cleanLine();
        parseCommand();
        parseCommandType();
    }

    /**
     * Reads rawLine from file and cleans it of whitespace and comments
     */
    private void cleanLine() {
        int commentLocation;

        if(rawLine == null) {
            cleanLine = "";
        } else {
            //remove comments and whitespace
            commentLocation = rawLine.indexOf("//");
            if(commentLocation != -1) {
                // remove whitespace
                cleanLine = rawLine.replaceAll(" ","");
                cleanLine = cleanLine.replaceAll("\t","");
                // remove comments
                cleanLine = rawLine.substring(0,commentLocation);
            } else {
                cleanLine = rawLine;
            }
        }
    }

    private void parseCommand() {
        if(cleanLine != null) {
            commands = cleanLine.split(" ");
        }
    }

    private void parseCommandType() {
        if (cleanLine == null || cleanLine.length() == 0) {
            commandType = NO_COMMAND;
        } else if ( commands.length == 1 ) {
            commandType = C_ARITHMETIC;
        } else if ( commands[0].contains("push") ) {
            commandType = C_PUSH;
        } else if (commands[0].contains("pop") ) {
            commandType = C_POP;
        }
    }

    String arg1() {
        switch (commandType) {
            case NO_COMMAND:
                return "";
            case C_ARITHMETIC:
                return commands[0];
            default:
                return commands[1];
        }
    }

    int arg2() {
        return Integer.parseInt(commands[2]);
    }

    /**
     * Getter for lineNumber
     * @return Int
     */
    public int getLineNumber() {
        return lineNumber;
    }

    /**
     * Getter for command type
     * @return Char
     */
    public char getCommandType() {
        return commandType;
    }

    /**
     * Getter for rawLine
     * @return String
     */
    public String getRawLine() {
        return rawLine;
    }

    /**
     * Getter for cleanLine
     * @return String
     */
    public String getCleanLine() {
        return cleanLine;
    }
}
