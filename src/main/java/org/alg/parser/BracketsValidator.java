package org.alg.parser;

import org.structures.stacks.StackArrayInt;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class BracketsValidator {
    private HashMap<Character, Character> brackets = new HashMap<>();
    private HashSet<Character> openBrackets = new HashSet<>();
    private HashSet<Character> closeBrackets = new HashSet<>();
    private Stack<Character> stack = new Stack();

    public void addBrackets(char open, char close){
        brackets.put(close, open);
        openBrackets.add(open);
        closeBrackets.add(close);
    }

    public boolean validate(char[] chain){
        for (int i = 0; i < chain.length; i++) {
            if(openBrackets.contains(chain[i])){
                stack.add(chain[i]);
            }else if(closeBrackets.contains(chain[i])){
                if(stack.empty()){
                    return false;
                }
                Character top = stack.pop();
                if(!top.equals(brackets.get(chain[i]))){
                    return false;
                }
            }
        }
        if (!stack.empty()){
            return false;
        }else{
            return true;
        }
    }
}
