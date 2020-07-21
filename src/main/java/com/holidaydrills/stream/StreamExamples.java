package com.holidaydrills.stream;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExamples {

    public void iterateWithLoop() {
        List<String> input = List.of("Hello", "how", "are", "you?");
        for(String word : input) {
            System.out.println(word);
        }
    }

    public void useStream() {
        List<String> input = List.of("Hello", "how", "are", "you?");
        input.stream().forEach(word -> System.out.println(word));
    }


    public List<Integer> multiplyByTwo(List<Integer> input) {
        List<Integer> result = new LinkedList<>();
        for(Integer number : input) {
            result.add(number * 2);
        }
        return result;
    }

    public List<Integer> multiplyByTwoWithStream(List<Integer> input) {
        List<Integer> result = input.stream().map(number -> number * 2).collect(Collectors.toList());
        return result;
    }
}
