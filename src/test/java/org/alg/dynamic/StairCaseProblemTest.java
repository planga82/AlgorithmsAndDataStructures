package org.alg.dynamic;

import org.alg.sort.BubbleSort;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StairCaseProblemTest
{
    StairCaseProblem scp = new StairCaseProblem();
    int[] steps = {1,2,3,4,5};

    @Before
    public void initialize(){
        scp.initialize();
    }

    @Test
    public void test1(){
        System.out.println("Result:");
        System.out.println(scp.posiblePaths(steps, 4));
        System.out.println("Num Steps:");
        System.out.println(scp.getNumprocess());
        System.out.println("Memory:");
        System.out.println(scp.getMemory());
    }

    @Test
    public void test2(){
        System.out.println("Result:");
        scp.posiblePaths(steps, 20);
        System.out.println("Num Steps:");
        System.out.println(scp.getNumprocess());
        System.out.println("Memory:");
        System.out.println(scp.getMemory());
    }

    @Test
    public void test3(){
        System.out.println("Result:");
        System.out.println(scp.posiblePathsOptimized(steps, 4));
        System.out.println("Num Steps:");
        System.out.println(scp.getNumprocess());
        System.out.println("Memory:");
        System.out.println(scp.getMemory());
    }

    @Test
    public void test4(){
        System.out.println("Result:");
        scp.posiblePathsOptimized(steps, 20);
        System.out.println("Num Steps:");
        System.out.println(scp.getNumprocess());
        System.out.println("Memory:");
        System.out.println(scp.getMemory());
    }

    @Test
    public void test5(){
        System.out.println("Result:");
        System.out.println(scp.posiblePathsDownTop(steps, 4));
        System.out.println("Num Steps:");
        System.out.println(scp.getNumprocess());
        System.out.println("Memory:");
        System.out.println(scp.getMemory());

    }

    @Test
    public void test6(){
        System.out.println("Result:");
        scp.posiblePathsDownTop(steps, 20);
        System.out.println("Num Steps:");
        System.out.println(scp.getNumprocess());
        System.out.println("Memory:");
        System.out.println(scp.getMemory());
    }




}
