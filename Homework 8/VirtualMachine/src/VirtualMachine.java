/**
 * @author Raul Aguilar
 * @date November 7, 2018
 */
import java.util.Scanner;

public class VirtualMachine {
    public static void main(String[] args) {
        String inputFileName;

        Scanner keyboard = new Scanner(System.in);
        Parser p = new Parser();

        System.out.println("Please enter assembly file name you would like to assemble.");
        System.out.println("Don't forget the .vm extension: ");
        inputFileName = keyboard.nextLine();
        keyboard.close();

        p.Parser(inputFileName);
        while( p.hasMoreCommands() ) {
            p.advance();
            System.out.println( p.getCleanLine() );
        }

        System.out.println("Finished assembling. Program exiting.");
    }
}
