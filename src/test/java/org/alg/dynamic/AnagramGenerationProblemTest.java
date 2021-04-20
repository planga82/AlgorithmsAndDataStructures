package org.alg.dynamic;

import org.junit.Before;
import org.junit.Test;

public class AnagramGenerationProblemTest
{
    AnagramGenerationProblem agp = new AnagramGenerationProblem();

    @Before
    public void initialize(){
        agp.initialize();
    }

    @Test
    public void test1(){
        System.out.println("Anagrams:");
        System.out.println(agp.generate("abc".toCharArray()));
        System.out.println("Numproceses:");
        System.out.println(agp.getNumprocess());
    }

    @Test
    public void test2(){
        System.out.println("Anagrams:");
        System.out.println(agp.generate("abcdefgh".toCharArray()));
        System.out.println("Numproceses:");
        System.out.println(agp.getNumprocess());
    }

    @Test
    public void test3(){
        System.out.println("Anagrams:");
        System.out.println(agp.generateOptimized("abc".toCharArray()));
        System.out.println("Numproceses:");
        System.out.println(agp.getNumprocess());
    }

    @Test
    public void test4(){
        System.out.println("Anagrams:");
        System.out.println(agp.generateOptimized("abcdefgh".toCharArray()));
        System.out.println("Numproceses:");
        System.out.println(agp.getNumprocess());
    }




}
