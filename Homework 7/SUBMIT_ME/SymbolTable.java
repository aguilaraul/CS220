/**
 * @author  Raul Aguilar
 * @class   CS 220 2525
 * @date    October 24, 2018
 */
import java.util.HashMap;

public class SymbolTable {
    private static String ALL_VALID_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"abcdefghijklmnopqrstuvwxyz"
            +"0123456789"+"_.$:";

    private HashMap<String, Integer> symbolTable = new HashMap<>();

    /**
     * Initializes hashmap with predefined symbols
     */
    public void SymbolTable() {
        for (int i = 0; i < 16;i++) {
            symbolTable.put("R"+i,i);
        }
        symbolTable.put("SP",0);
        symbolTable.put("LCL",1);
        symbolTable.put("ARG",2);
        symbolTable.put("THIS",3);
        symbolTable.put("THAT",4);
        symbolTable.put("SCREEN",16384);
        symbolTable.put("KBD",24576);
    }
}
