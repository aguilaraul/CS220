/**
 * @author  Raul Aguilar
 * @class   CS 220 2525
 * @date    October 26, 2018
 */
//TODO: don't forget to document each method in all classes!
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class Assembler {

    // ALGORITHM:
    // get input file name
    // create output file name and stream

    // create symbol table
    // do first pass to build symbol table (no output yet!)
    // do second pass to output translated ASM to HACK code

    // print out "done" message to user
    // close output file stream
    public static void main(String[] args) {

        String inputFileName, outputFileName;
        PrintWriter outputFile = null; //keep compiler happy
        SymbolTable symbolTable = new SymbolTable();

        int romAddress = 0, ramAddress = 16;

        //get input file name from command line or console input
        if(args.length == 1) {
            System.out.println("command line arg = " + args[0]);
            inputFileName = args[0];
        }
        else {
            Scanner keyboard = new Scanner(System.in);

            System.out.println("Please enter assembly file name you would like to assemble.");
            System.out.println("Don't forget the .asm extension: ");
            inputFileName = keyboard.nextLine();

            keyboard.close();
        }

        outputFileName = inputFileName.substring(0,inputFileName.lastIndexOf('.')) + ".hack";

        try {
            outputFile = new PrintWriter(new FileOutputStream(outputFileName));
        } catch (FileNotFoundException ex) {
            System.err.println("Could not open output file " + outputFileName);
            System.err.println("Run program again, make sure you have write permissions, etc.");
            System.exit(0);
        }

        // TODO: finish driver as algorithm describes

        firstPass(inputFileName, symbolTable, romAddress, ramAddress);

        secondPass(inputFileName, symbolTable, outputFile, romAddress, ramAddress);

        System.out.println("Finished assembling. Program exiting.");
        outputFile.close();
        System.exit(0);
    }

    // TODO: march through the source code without generating any code
    //for each label declaration (LABEL) that appears in the source code,
    // add the pair <LABEL, n> to the symbol table
    // n = romAddress which you should keep track of as you go through each line
    //HINT: when should rom address increase? What kind of commands?
    private static SymbolTable firstPass(String inputFileName, SymbolTable symbolTable, int romAddress, int ramAddress) {
        Parser p = new Parser();
        symbolTable.SymbolTable();
        p.Parser(inputFileName);
        while( p.hasMoreCommands() ) {
            p.advance();

            //System.out.println( "Line number: " + p.getLineNumber() ); //debug

            if(p.getCommandType() == Parser.L_COMMAND) {
                symbolTable.addEntry(p.getSymbol(), romAddress);
            }
            if(p.getCommandType() == Parser.A_COMMAND) {
                romAddress++;
            }
            if(p.getCommandType() == Parser.C_COMMAND) {
                romAddress++;
            }
        }

        return symbolTable;
    }

    // TODO: march again through the source code and process each line:
    // if the line is a c-instruction, simple (translate)
    // if the line is @xxx where xxx is a number, simple (translate)
    // if the line is @xxx and xxx is a symbol, look it up in the symbol
    //	table and proceed as follows:
    // If the symbol is found, replace it with its numeric value and
    //	and complete the commands translation
    // If the symbol is not found, then it must represent a new variable:
    // add the pair <xxx, n> to the symbol table, where n is the next
    //	available RAM address, and complete the commands translation
    // HINT: when should rom address increase?  What should ram address start
    // at? When should it increase?  What do you do with L commands and No commands?
    private static void secondPass(String inputFileName, SymbolTable symbolTable, PrintWriter outputFile, int romAddress,
                                   int ramAddress) {
        Parser p = new Parser();
        p.Parser(inputFileName);
        while (p.hasMoreCommands()) {
            p.advance();

            //System.out.println("Line number: " + p.getLineNumber()); //debug

            if (p.getCommandType() == Parser.C_COMMAND) {
                String instruction = "111" + p.getComp() + p.getDest() + p.getJump() + '\n';
                outputFile.write(instruction);
                romAddress++;
            }
            if (p.getCommandType() == Parser.A_COMMAND) {
                try {
                    int decimal = Integer.parseInt(p.getSymbol());
                    String dec = "0"+ Code.decimalToBinary(decimal) + '\n';
                    outputFile.write(dec);
                    romAddress++;
                } catch (NumberFormatException e) {
                    if( symbolTable.contains(p.getSymbol()) ) {
                        String dec = "0"+ Code.decimalToBinary(symbolTable.getAddress( p.getSymbol() )) + '\n';
                        outputFile.write(dec);
                    } else {
                        symbolTable.addEntry(p.getSymbol(), ramAddress);
                    }
                    romAddress++;
                }
            }
        }
    }
}