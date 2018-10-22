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

    private Scanner inputFile;
    private int lineNumber;
    private String rawLine;

    private String cleanLine;
    private char commandType;
    private String symbol;
    private String destMnemonic;
    private String compMnemonic;
    private String jumpMnemonic;

    Code c = new Code();

    /**
     * Opens input file and prepares to parse
     * If files can't be opened, ends program with error message
     * @param inFileName the name of the asm file
     */
    public void Parser(String inFileName, PrintWriter outputFile) {
        try {
            inputFile = new Scanner(new FileReader(inFileName));
            while( hasMoreCommands(inputFile) ) {
                advance();
                cleanLine = cleanLine(rawLine);
                commandType = parseCommandType(cleanLine);
                parse(commandType, outputFile);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found. Ending program.");
            System.exit(0);
        }
    }

    /**
     * Returns boolean if more commands left, closes stream if not
     * @param inputFile BufferedReader to stream-in file
     * @return True if more commands, else closes stream
     */
    public boolean hasMoreCommands(Scanner inputFile) {
        if( inputFile.hasNextLine() ) {
            lineNumber++;
            return true;
        } else {
            inputFile.close();
            return false;
        }
    }

    /**
     * Reads next line from file and pares it into instance var
     */
    public void advance() {
        rawLine = inputFile.nextLine();
    }

    /**
     * Reads raw line from file and stripes line of whitespace and comments
     * @param rawLine String of a single line from file before cleaned
     * @return String of clean line without comments and whitespace
     */
    private String cleanLine (String rawLine) {
        String clean;
        int commentLocation;

        if(rawLine == null) {
            return clean = "";
        }

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
    private char parseCommandType(String clean) {

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

    /**
     * Helper method parses line depending on instuction type
     * Appropriate parts of instruction filled
     * @param commandType
     */
    private void parse(char commandType, PrintWriter outputFile) {
        if(commandType == L_COMMAND || commandType == A_COMMAND) {
            parseSymbol(cleanLine, commandType);
            System.out.println(symbol);
            outputFile.write(symbol);
        } else if (commandType == C_COMMAND) {
            parseComp(cleanLine);
            parseDest(cleanLine);
            parseJump(cleanLine);
            System.out.println("111" + compMnemonic + destMnemonic + jumpMnemonic);
            outputFile.write("111" + compMnemonic + destMnemonic + jumpMnemonic);
        }
    }

    /**
     * Parses symbol from A- or L-commands
     * symbol has appropriate value from instruction
     * @param cleanLine cleaned line to parse symbol from
     * @param commandType command type to determine which command to perform
     */
    private void parseSymbol(String cleanLine, char commandType) {
        if(commandType == L_COMMAND) {
            int begin = cleanLine.indexOf('(');
            int end = cleanLine.indexOf(')');
            symbol = cleanLine.substring(begin+1,end);
        }
        if(commandType == A_COMMAND) {
            symbol = cleanLine.substring(1);
            try {
                int decimal = Integer.parseInt(symbol);
                symbol = "0"+ c.decimalToBinary(decimal);
            } catch (NumberFormatException e) {

            }
        }
    }

    /**
     * Helper method parses line to get dest part
     * destMnemonic set to appropriate value from instruction
     * @param cleanLine clean String to parse destMnemonic
     */
    private void parseDest(String cleanLine) {
        c.Code();
        int equals = cleanLine.indexOf('=');
        if (equals != -1) {
            destMnemonic = cleanLine.substring(0, equals);
            destMnemonic = c.getDest(destMnemonic);
        } else {
            destMnemonic = null;
            destMnemonic = c.getDest(destMnemonic);
        }
    }

    /**
     * Helper method parses line to get comp part
     * compMnemonic set to appropriate value from instruction
     * @param cleanLine clean String to parse compMnemonic
     */
    private void parseComp(String cleanLine) {
        c.Code();
        int equals = cleanLine.indexOf('=');
        if (equals != -1) {
            compMnemonic = cleanLine.substring(equals+1);
            compMnemonic = c.getComp(compMnemonic);
        } else {
            int semicolon = cleanLine.indexOf(';');
            compMnemonic = cleanLine.substring(0,semicolon);
            compMnemonic = c.getComp(compMnemonic);
        }
    }

    /**
     * Helper method parses line to get jump part
     * jumpMnemonic set to appropriate value from instruction
     * @param cleanLine clean String to parse jumpMnemonic from
     */
    private void parseJump(String cleanLine) {
        c.Code();
        int semicolon = cleanLine.indexOf(';');
        if (semicolon != -1) {
            jumpMnemonic = cleanLine.substring(semicolon+1);
            jumpMnemonic = c.getJump(jumpMnemonic);
        } else {
            jumpMnemonic = null;
            jumpMnemonic = c.getJump(jumpMnemonic);
        }
    }

    /**
     * getter for command type
     * @return char for command type (N/A/C/L)
     */
    public char getCommandType() {
        return commandType;
    }

    /**
     * getter for symbol name
     * @return string from symbol name
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * getter for dest part of C-instruction
     * @return mnemonic for dest part
     */
    public String getDest() {
        return destMnemonic;
    }

    /**
     * getter for comp part of C-instruction
     * @return mnemonic for comp part
     */
    public String getComp() {
        return compMnemonic;
    }

    /**
     * getter for jump part of C-instruction
     * @return mnemonic for jump part
     */
    public String getJump() {
        return jumpMnemonic;
    }

    /**
     * getter for rawLine from file
     * @return String of current original line from file
     */
    public String getRawLine() {
        return rawLine;
    }

    /**
     * getter for cleanLine from file
     * @return String of current clean instruction from file
     */
    public String getCleanLine() {
        return cleanLine;
    }

    /**
     * getter for lineNumber
     * @return line number currently being processed from file
     */
    public int getLineNumber() {
        return lineNumber;
    }
}
