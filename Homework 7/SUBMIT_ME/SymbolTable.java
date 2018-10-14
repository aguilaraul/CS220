import java.util.HashMap;

public class SymbolTable {
    private static final String INITIAL_VALID_CHARS = ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");

    HashMap<String, Integer> symbolTable = new HashMap<String, Integer>();

    public SymbolTable(){
        for(int i = 0; i < 16; i++) {
            symbolTable.put("R"+i,i);
        }
    }


    public static void main(String[] args) {
        system.out.println(symbolTable);
    }
}