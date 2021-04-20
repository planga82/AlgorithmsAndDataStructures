package org.alg.dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AnagramGenerationProblem {

    private int numprocess = 0;
    private HashMap<String, List<String>> cache;

    public List<String> generate(char[] chain){

        List<String> ret = new LinkedList<>();
        if(chain.length == 1){
           ret.add(String.valueOf(chain));
            numprocess++;
           return ret;
        }

        for (int i = 0; i < chain.length; i++) {
            char actual = chain[i];

            char[] others = new char[chain.length -1];
            int k = 0;
            for (int j = 0; j < chain.length; j++) {
                if(j != i){
                    others[k] = chain[j];
                    k++;
                }
            }

            List<String> subanagrams = generate(others);
            for (String subanagram: subanagrams) {
                ret.add(actual + subanagram);
                numprocess++;
            }
        }
        return ret;
    }

    public List<String> generateOptimized(char[] chain){

        List<String> ret = new LinkedList<>();
        if(chain.length == 1){
            ret.add(String.valueOf(chain));
            numprocess++;
            return ret;
        }

        for (int i = 0; i < chain.length; i++) {
            char actual = chain[i];

            char[] others = new char[chain.length -1];
            int k = 0;
            for (int j = 0; j < chain.length; j++) {
                if(j != i){
                    others[k] = chain[j];
                    k++;
                }
            }

            List<String> subanagrams;
            String othersKey = String.valueOf(others);
            if(cache.containsKey(othersKey)){
                subanagrams = cache.get(othersKey);
            }else{
                subanagrams = generateOptimized(others);
                cache.put(othersKey, subanagrams);
            }

            for (String subanagram: subanagrams) {
                ret.add(actual + subanagram);
                numprocess++;
            }
        }
        return ret;
    }

    public int getNumprocess(){
        return numprocess;
    }

    public void initialize(){
        numprocess = 0;
        cache = new HashMap<>();
    }
}
