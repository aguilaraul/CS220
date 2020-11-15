/**
 * KeywordTable.java
 * Author   Raul Aguilar
 * Date     November 13, 2020
 * CS 220 2148
 */
import java.util.HashMap;

public class KeywordTable {
    private HashMap<String, Integer> keywords = new HashMap<>();

    /**
     * Instantiate the table with reserved keywords and the integer
     * constants representing them
     */
    public void KeywordTable() {
        keywords.put("class", 0);
        keywords.put("method", 1);
        keywords.put("function", 2);
        keywords.put("constructor", 3);
        keywords.put("int", 4);
        keywords.put("boolean", 5);
        keywords.put("char", 6);
        keywords.put("void", 7);
        keywords.put("var", 8);
        keywords.put("static", 9);
        keywords.put("field", 10);
        keywords.put("let", 11);
        keywords.put("do", 12);
        keywords.put("if", 13);
        keywords.put("else", 14);
        keywords.put("while", 15);
        keywords.put("return", 16);
        keywords.put("true", 17);
        keywords.put("false", 18);
        keywords.put("null", 19);
        keywords.put("this", 20);
    }

    /**
     * Return boolean if the current token is a keyword in the table
     */
    public boolean contains(String token) {
        return keywords.containsKey(token);
    }

    /**
     * Returns the integer constant associated with the current token,
     * a keyword.
     */
    public int getKeyword(String keyword) {
        return keywords.get(keyword);
    }
}
