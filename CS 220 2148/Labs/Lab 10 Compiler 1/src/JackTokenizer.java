/**
 * JackTokenizer.java
 * Author   Raul Aguilar
 * Date     November 14, 2020
 * CS 220 2148 Lab 10 JackTokenizer
 * JackTokenizer: Removes all comments and white space from the input
 * stream and breaks it into Jack-language tokens, as specified by the
 * Jack grammar.
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class JackTokenizer {
    private static String VALID_SYMBOLS = "{}()[].,;+-*/&|<>=~";
    private static String VALID_IDENTIFIER = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_.$:";
    
    private PrintWriter outputFile = null;
    private Scanner inputFile;
    private KeywordTable keywords = new KeywordTable();
    private ArrayList<String> tokens = new ArrayList<>();
    private String cleanLine, token, symbol, stringConst;
    private int lineNumber, keyword, intConst;
    private TokenType tokenType;

    /**
     * Opens the input .jack file and gets ready to tokenize it
     * @param fileName Name of the jack file
     */
    public JackTokenizer(String fileName) {
        try {
            inputFile = new Scanner(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.err.println("File could not be found. Exiting program...");
            System.exit(0);
        }
    }

    /**
     * Checks if the .jack file has more line to read
     */
    public boolean hasMoreLines() {
        if(inputFile.hasNextLine()) {
            return true;
        } else {
            inputFile.close();
            return false;
        }
    }

    /**
     * Increments the line number by one. Intakes a sinle line from the
     * file. First attempts to clean any single line comments, if there
     * are none, then returns the line back. Then attempts to clean any
     * syntax for multiline comments, otherwise returns back the line.
     * After the line is clean of comments or whitespaces. Then 
     * tokenize the clean line.
     */
    public void parseNextLine() {
        lineNumber++;
        String rawLine = inputFile.nextLine();
        cleanLine = cleanMultiLineComments(cleanSingleLineComments(rawLine));
        parseTokens(cleanLine);
    }

    /**
     * Scans the line for "//" single line comments. Returns the line
     * from the beginning up to the comment index. If there are no
     * comments, returns the line back trimmed. However, there could
     * still be multiline comments present.
     * @param line The raw line taken from the file
     * @return Line of jack code without single line comments
     */
    private String cleanSingleLineComments(String line) {
        int commentIndex = line.indexOf("//");
        if(commentIndex >= 0) {
            return line.substring(0, commentIndex).trim();
        }
        return line.trim();
    }

    /**
     * Cleans the line of multiline commments by scanning for "/*",
     * "*", or "*"/". If the start of a multiline comment is present in
     * the line, then return the line from beginning up to index of"\*"
     * If the line starts with "*", then line is in multiline comment
     * and return empty line.
     * If the end of a multiline comment is present, return everything
     * after the index of occurance.
     * Otherwise if no multiline comment is in line, then return the
     * line as is.
     * @param line Line taken after being cleaned of single line
     * comments
     * @return A clean line of multiline comments.
     */
    private String cleanMultiLineComments(String line) {
        int start = line.indexOf("/*");
        int end = line.indexOf("*/");
        if(start >= 0) {
            return line.substring(0, start);
        }
        if(line.startsWith("*")) {
            return "";
        }
        if(end >= 0) {
            return line.substring(end+2);
        }
        return line;
    }

    /**
     * Recursively parse the line into tokens split up by symbols.
     * Adds each token into an ArrayList containing all the tokens
     * parsed from the file so far.
     * @param line Current line from jack file being parsed into tokens
     */
    private void parseTokens(String line) {
        boolean foundSymbol = false;
        int symbolIndex = 0;

        if(line.length() == 1) {
            tokens.add(line.trim());
        }
        if(line.length() > 1) {
            for(int i = 0; i < line.length(); i++) {
                if(VALID_SYMBOLS.contains(""+line.charAt(i))) {
                    // current character is a symbol
                    symbolIndex = i;
                    foundSymbol = true;
                    break;
                }
            }

            if(foundSymbol) {
                if(symbolIndex != 0) {
                    // add everything before the symbol if it doesn't
                    // have quotation marks
                    // Split the line first
                    if(line.charAt(0) != '"') {
                        tokens.addAll(Arrays.asList(line.substring(0, symbolIndex).trim().split(" ")));
                    } else {
                        tokens.add(line.substring(0, symbolIndex).trim());
                    }
                }
                // Add the symbol
                tokens.add(line.charAt(symbolIndex)+"".trim());
                // Continue parsing after the symbol
                parseTokens(line.substring(symbolIndex+1).trim());
            } else {
                // If no symbol is found in line, add the line
                tokens.add(line);
            }
        }
    }

    public void advance() {
        parseNextLine();
    }

    /**
     * Open the output XML file for writing
     * @param fileName Name of the xml output file
     */
    public void xmlWriter(String fileName) {
        try {
            outputFile = new PrintWriter(new FileOutputStream(fileName));
        } catch(FileNotFoundException e) {
            System.err.println("Could not open output file " + fileName);
            System.err.println("Run program again, make sure to have write permissions, etc.");
            System.err.println("Program exiting...");
            System.exit(0);
        }
    }

    /**
     * Writes all of the tokens parsed from the input .jack file into
     * xml tags to the output xml file 
     */
    public void writeToXML() {
        outputFile.println("<tokens>");
        for(String t:tokens) {
            token = t;
            tokenType = tokenType(token);
            writeTokenTag(tokenType, token);
        }
        outputFile.println("</tokens>");
        outputFile.close();
    }

    private TokenType tokenType(String token) {
        try {
            intConst = Integer.parseInt(token);
            return TokenType.INT_CONST;
        } catch (NumberFormatException notAnInteger) {
            keywords.KeywordTable();
            if(token.charAt(0) == '"') {
                stringConst = token.substring(1, token.length()-1);
                return TokenType.STRING_CONST;
            } else if(VALID_SYMBOLS.contains(token)) {
                switch(token) {
                    case "<":
                        symbol = "&lt;";
                        return TokenType.SYMBOL;
                    case ">":
                        symbol = "&gt;";
                        return TokenType.SYMBOL;
                    case "\"":
                        symbol = "&quot;";
                        return TokenType.SYMBOL;
                    case "'":
                        symbol = "&apos;";
                        return TokenType.SYMBOL;
                    case "&":
                        symbol = "&amp;";
                        return TokenType.SYMBOL;
                    default:
                        symbol = token;
                        return TokenType.SYMBOL;
                }
            } else if(keywords.contains(token)) {
                keyword = keywords.getKeyword(token);
                return TokenType.KEYWORD;
            } else {
                return TokenType.IDENTIFIER;
            }
        }
    }

    private void writeTokenTag(TokenType tokenType, String token) {
        if(tokenType == TokenType.STRING_CONST) {
            outputFile.print("<stringConstant> ");
            outputFile.print(getStringConst());
            outputFile.println(" </stringConstant>");
        } else if(tokenType == TokenType.INT_CONST) {
            outputFile.print("<integerConstant> ");
            outputFile.print(getIntConst());
            outputFile.println(" </integerConstant>");
        } else if(tokenType == TokenType.SYMBOL) {
            outputFile.print("<symbol> ");
            outputFile.print(getSymbol());
            outputFile.println(" </symbol>");
        } else {
            outputFile.print("<"+tokenType.name().toLowerCase()+"> ");
            outputFile.print(token);
            outputFile.println(" </"+tokenType.name().toLowerCase()+">");
        }
    }

    /** Getters **/

    public int getKeyword() {
        return keyword;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getIntConst() {
        return intConst;
    }

    public String getStringConst() {
        return stringConst;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    /** Main **/
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String inputFileName;

        // Get input file name
        System.out.println("Enter the .jack file name to compile:");
        inputFileName = keyboard.nextLine();
        keyboard.close();

        // Open jack file to read and tokenize
        JackTokenizer jackTokenizer = new JackTokenizer(inputFileName);
        while(jackTokenizer.hasMoreLines()) {
            jackTokenizer.advance();
        }
        // After tokenizing, write to xml file
        jackTokenizer.xmlWriter(inputFileName.substring(0, inputFileName.lastIndexOf('.'))+"T.xml");
        jackTokenizer.writeToXML();

        System.out.println("Done compiling. Program exiting...");
    }
}
