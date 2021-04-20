package org.alg.dynamic;

    import org.alg.sort.QuickSort;

    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.LinkedList;
import java.util.List;

public class StairCaseProblem {

    private int numprocess = 0;
    private int memory = 0;

    public List<String> posiblePaths(int[] posibleSteps, int numSteps){
        List<String> ret = new LinkedList<>();
        for (int i = 0; i < posibleSteps.length; i++) {
            if(numSteps - posibleSteps[i] >= 0) {
                List<String> paths = posiblePaths(posibleSteps, numSteps - posibleSteps[i]);
                for (String path : paths) {
                    ret.add(posibleSteps[i] + "," + path);
                    numprocess++;
                }
            }
        }
        if(ret.size() == 0){
            ret.add("");
        }
        return ret;
    }

    private HashMap<Integer, List<String>> cache;
    public void initialize(){
        cache = new HashMap<>();
        numprocess = 0;
    }

    public List<String> posiblePathsOptimized(int[] posibleSteps, int numSteps){
        List<String> ret = new LinkedList<>();

        for (int i = 0; i < posibleSteps.length; i++) {
            if(numSteps - posibleSteps[i] >= 0) {
                int nexState = numSteps - posibleSteps[i];
                List<String> paths;
                if(cache.containsKey(nexState)){
                    paths = cache.get(nexState);
                }else{
                    paths = posiblePathsOptimized(posibleSteps, nexState);
                    cache.put(nexState, paths);
                }
                for (String path : paths) {
                    ret.add(posibleSteps[i] + "," + path);
                    numprocess++;
                }
            }
        }
        if(ret.size() == 0){
            ret.add("");
        }
        memory = cache.size();

        return ret;
    }

    public List<String> posiblePathsDownTop(int[] posibleSteps, int numSteps){
        new QuickSort().orderLastElemPivot(posibleSteps);
        int maxStep = posibleSteps[posibleSteps.length-1];
        List<String>[] tempValues = new List[maxStep];
        for (int i = 0; i < maxStep; i++) {
            List<String> x = new LinkedList<>();
            x.add("");
            tempValues[i] = x;
        }

        List<String> ret = new LinkedList<>();
        for (int actualSteps = 1; actualSteps <= numSteps; actualSteps++) {
            List<String> partialResult = new LinkedList<>();
            for (int i = 0; i < posibleSteps.length; i++) {
                if(posibleSteps[i] <= actualSteps){
                    List<String> prev = tempValues[tempValues.length - posibleSteps[i]];
                    for (String s: prev) {
                        partialResult.add(s + "," + posibleSteps[i]);
                        numprocess++;
                    }
                }
            }
            slide(partialResult, tempValues);
            if(actualSteps == numSteps) {
                ret.addAll(partialResult);
            }
        }
        memory = tempValues.length;
        return ret;
    }

    private void slide(List<String> newValue, List<String>[] tempValues){
        for (int i = 1; i < tempValues.length; i++) {
            tempValues[i-1] = tempValues[i];
        }
        tempValues[tempValues.length - 1] = newValue;
    }

    public int getNumprocess(){
        return numprocess;
    }
    public int getMemory(){
        return memory;
    }
}
