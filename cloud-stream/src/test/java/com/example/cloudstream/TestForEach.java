package com.example.cloudstream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestForEach {


    @Test
    public void test(){
        List<Integer> list= Arrays.asList(1,2,3,4,5);
        list.forEach(
                e -> {
                    System.out.println(e);
                    throw new RuntimeException("23");
                });
    }
}
