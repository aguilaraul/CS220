/**
 * @author  Raul Aguilar
 * @class   CS 220 2525
 * @date    October 24, 2018
 */
import java.util.HashMap;

public class SymbolTable {
    private static String INITIAL_VALID_CHARS;
    private static String ALL_VALID_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_.$:";

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

    /**
     * Adds new pair of symbol/address to hashmap
     * @param symbol name of symbol to add
     * @param address address associated with that symbol
     * @return true if pair is added, false if illegal name
     */
    public boolean addEntry(String symbol, int address) {
        boolean entryAdded = false;
        if(contains(symbol)) {
            entryAdded = false;
        }
        if (isValidSymbolName(symbol)) {
            symbolTable.put(symbol, address);
            entryAdded = true;
        }
        return entryAdded;
    }

    /**
     * Returns boolean of whether hashmap has symbol or not
     * @param symbol symbol to check
     * @return true if symbol exist, false if not
     */
    public boolean contains(String symbol) {
        if ( symbolTable.containsKey(symbol) ) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns address in hashmap of given symbol
     * PRECONDITION: symbol is in hashmap(check w/ contains() first)
     * @param symbol the symbol to obtain address of
     * @return address associated with symbol in hashmap
     */
    public int getAddress(String symbol) {
        return symbolTable.get(symbol);
    }

    private static boolean isValidSymbolName(String symbol) {
        boolean isValidName = false;
        for(char c : symbol.toCharArray()) {
            if(ALL_VALID_CHARS.indexOf(c) == -1) {
                System.out.println("Variable name is not valid.");
                isValidName = false;
            } else {
                isValidName = true;
            }
        }
        return isValidName;
    }
}
