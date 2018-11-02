/**
 * @author  Raul Aguilar
 * @date    November 7, 2018
 */

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class VirtualMachinePart1 {
    public static void main(String[] args) {

        String inputFileName, outputFileName;
        PrintWriter outputFile = null; //keep compiler happy

        //get input file name from command line or console input
        if(args.length == 1) {
            System.out.println("command line arg = " + args[0]);
            inputFileName = args[0];
        } else {
            Scanner keyboard = new Scanner(System.in);

            System.out.println("Please enter assembly file name you would like to assemble.");
            System.out.println("Don't forget the .vm extension: ");
            inputFileName = keyboard.nextLine();

            keyboard.close();
        }

        // TODO: finish driver as algorithm describes

        System.out.println("Finished assembling. Program exiting.");
        outputFile.close();
        System.exit(0);

    }
}
