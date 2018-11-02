/**
 * @author  Raul Aguilar
 * @date    November 7, 2018
 */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class CodeWriter {
    PrintWriter outputFile = null; //keep compiler happy
    String outputFileName;

    /**
     * Opens the output file and gets ready to write into it
     * @param inFileName Input file name to name output file
     */
    public void CodeWriter(String inFileName) {
        outputFileName = inFileName.substring(0,inFileName.lastIndexOf('.')) + ".asm";
        try {
            outputFile = new PrintWriter(new FileOutputStream(outputFileName));
        } catch (FileNotFoundException ex) {
            System.err.println("Could not open output file " + outputFileName);
            System.err.println("Run program again, make sure you have write permissions, etc.");
            System.exit(0);
        }
    }

}
