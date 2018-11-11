/*
    @author Raul Aguilar
    @date November 7, 2018
 */
import java.util.Scanner;

public class VirtualMachine {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Parser parser = new Parser();
        CodeWriter codeWriter = new CodeWriter();
        String inputFileName, outputFileName;


        //Open file from command line or console
        if(args.length == 1) {
            System.out.println("command line arg = " + args[0]);
            inputFileName = args[0];
        } else {
            System.out.println("Please enter assembly file name you would like to assemble.");
            System.out.println("Don't forget the .vm extension: ");
            inputFileName = keyboard.nextLine();
            keyboard.close();
        }
        outputFileName = inputFileName.substring(0,inputFileName.lastIndexOf('.')) + ".asm";
        codeWriter.CodeWriter(outputFileName);

        System.out.println( outputFileName ); //debug
        //Driver
        parser.Parser( inputFileName );
        while( parser.hasMoreCommands() ) {
            parser.advance();
            //debug
            System.out.println( parser.getCleanLine() );
            System.out.println( parser.getCommandType() );
            System.out.println( parser.arg1() );
            if (parser.getCommandType() == Parser.C_PUSH || parser.getCommandType() == Parser.C_POP) {
                System.out.println( parser.arg2() );
            }
            System.out.println("======");
            //end debug

            //Write to file
            if(parser.getCommandType() == Parser.C_ARITHMETIC) {
                codeWriter.writeArithmetic(parser.arg1());
            } else if (parser.getCommandType() == Parser.C_PUSH || parser.getCommandType() == Parser.C_POP) {
                codeWriter.writePushPop(parser.getCommandType(), parser.arg1(), parser.arg2());
            }
        }

        codeWriter.close();
        System.out.println("Finished assembling. Program exiting.");
    }
}
