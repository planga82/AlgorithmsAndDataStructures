package org.alg.parser;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class BracketsValidatorTest
{
    private BracketsValidator bc = new BracketsValidator();
    @Before
    public void initialize(){
        bc.addBrackets('(',')');
        bc.addBrackets('{','}');
        bc.addBrackets('[',']');
    }

    @Test
    public void test1(){
        String text = "(var x = {y: [1 ,2 ,3]})";
        assertTrue(bc.validate(text.toCharArray()));
    }

    @Test
    public void test2(){
        String text = "(var x = {y: [1 ,2 ,3]}";
        assertTrue(!bc.validate(text.toCharArray()));
    }

    @Test
    public void test3(){
        String text = "var x = {y: [1 ,2 ,3]})";
        assertTrue(!bc.validate(text.toCharArray()));
    }

    @Test
    public void test4(){
        String text = "(var x = {y: [1 ,2 ,3}])";
        assertTrue(!bc.validate(text.toCharArray()));
    }



}
