package com.holidaydrills.stream;

import java.util.LinkedList;
import java.util.List;

public class StreamExamples {


    public List<Integer> multiplyByTwo(List<Integer> input) {
        List<Integer> result = new LinkedList<>();
        for(Integer number : input) {
            result.add(number * 2);
        }
        return result;
    }
}
