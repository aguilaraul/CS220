/**
 * @author  Raul Aguilar
 * @class   CS 220 2525
 * @date    October 24, 2018
 */
import java.util.HashMap;

public class Code {
    private HashMap<String, String> compCodes = new HashMap<String, String>();
    private HashMap<String, String> destCodes = new HashMap<String, String>();
    private HashMap<String, String> jumpCodes = new HashMap<String, String>();

    /**
     * Initializes hashmaps with binary codes for easy lookup
     */
    public void Code() {
        // Comp Codes
        compCodes.put("0","0101010");
        compCodes.put("1","0111111");
        compCodes.put("-1","0111010");
        compCodes.put("D","0001100");
        compCodes.put("A","0110000");
        compCodes.put("M","1110000");
        compCodes.put("!D","0001101");
        compCodes.put("!A","0110001");
        compCodes.put("!M","1110001");
        compCodes.put("-D","0001111");
        compCodes.put("-A","0110011");
        compCodes.put("D+1","0011111");
        compCodes.put("1+D","0011111");
        compCodes.put("A+1","0110111");
        compCodes.put("1+A","0110111");
        compCodes.put("M+1","1110111");
        compCodes.put("1+M","1110111");
        compCodes.put("D-1","0001110");
        compCodes.put("-1+D","0001110");
        compCodes.put("A-1","0110010");
        compCodes.put("-1+A","0110010");
        compCodes.put("M-1","1110010");
        compCodes.put("-1+M","1110010");
        compCodes.put("D+A","0000010");
        compCodes.put("D+M","1000010");
        compCodes.put("M+D","1000010");
        compCodes.put("A+D","0000010");
        compCodes.put("D-A","0010011");
        compCodes.put("D-M","1010011");
        compCodes.put("A-D","0000111");
        compCodes.put("M-D","1000111");
        compCodes.put("D&A","0000000");
        compCodes.put("D&M","1000000");
        compCodes.put("D|A","0010101");
        compCodes.put("D|M","1010101");

        // Dest codes
        destCodes.put(null,"000");
        destCodes.put("","000");
        destCodes.put("\"null\"","000");
        destCodes.put("M","001");
        destCodes.put("D","010");
        destCodes.put("MD","011");
        destCodes.put("DM","011");
        destCodes.put("A","100");
        destCodes.put("AM","101");
        destCodes.put("MA","101");
        destCodes.put("AD","110");
        destCodes.put("DA","110");
        destCodes.put("AMD","111");

        // Jump codes
        jumpCodes.put(null,"000");
        jumpCodes.put("","000");
        jumpCodes.put("\"null\"","000");
        jumpCodes.put("JGT","001");
        jumpCodes.put("JEQ","010");
        jumpCodes.put("JGE","011");
        jumpCodes.put("JLT","100");
        jumpCodes.put("JNE","101");
        jumpCodes.put("JLE","110");
        jumpCodes.put("JMP","111");
    }

    /**
     * Converts to string of bits for given mnemonic
     * @param mnemonic the key given
     * @return the converted bits for given key
     */
    public String getComp(String mnemonic) {
        return compCodes.get(mnemonic);
    }

    /**
     * Converts to string of bits for given mnemonic
     * @param mnemonic the key given
     * @return the converted bits for given key
     */
    public String getDest(String mnemonic) {
        return destCodes.get(mnemonic);
    }

    /**
     * Converts to string of bits for given mnemonic
     * @param mnemonic the key given
     * @return the converted bits for given key
     */
    public String getJump(String mnemonic) {
        return jumpCodes.get(mnemonic);
    }

    /**
     * Converts a decimal number to binary
     * @param decimal decimal number
     * @return binary representation of decimal number
     */
    public static StringBuilder decimalToBinary (int decimal) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<15;i++) {

            if(decimal % 2 == 0) {
                sb.append("0");
            } else {
                sb.append("1");
            }
            decimal /= 2;
        }
        return sb.reverse();
    }
}
