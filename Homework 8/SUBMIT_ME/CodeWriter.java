/*
    @author Raul Aguilar
    @date November 7, 2018
 */
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CodeWriter {
    PrintWriter outputFile = null;
    private int labelCounter = 1;

    /**
     * Prepares an asm file for writing
     * @param fileName name of the inputFile is used as the outputFile name
     */
    public void CodeWriter(String fileName) {
        try {
            outputFile = new PrintWriter(fileName);
        } catch (FileNotFoundException e) {
            System.err.println("Could not open output file " + fileName);
            System.err.println("Run program again, make sure you have write permissions, etc.");
            System.exit(0);
        }
    }

    void writeArithmetic(String command) {
        switch (command) {
            case "add": case "sub":
                writeAddSub(command);
                break;
        }
    }

    void writePushPop(char command, String segment, int index) {
        if (command == 'U' && segment.equals("constant")) {
            writePushConst(index);
        }
    }

    /**
     * Closes output file
     */
    public void close() {
        outputFile.close();
    }

    private void writeAddSub(String command) {
        outputFile.println("@SP");
        outputFile.println("AM = M - 1");
        outputFile.println("D = M");
        outputFile.println("A = A - 1");
        if(command.equals("add")) {
            outputFile.println("M = M + D");
        } else if (command.equals("sub")) {
            outputFile.println("M = M - D");
        }
    }



    private void writePushConst(int index) {
        if(index > 1) {
            outputFile.println("@"+index);
            outputFile.println("D = A");
            outputFile.println("@SP");
            outputFile.println("M = M + 1");
            outputFile.println("A = M - 1");
            outputFile.println("M = D");
        } else if (index == 1) {
            outputFile.println("@SP");
            outputFile.println("M = M + 1");
            outputFile.println("A = M - 1");
            outputFile.println("M = 1");
        } else {
            System.out.println("Index is a non-negative number");
        }
    }
}
