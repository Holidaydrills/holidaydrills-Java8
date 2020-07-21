package com.holidaydrills.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StreamExamplesTest {

    StreamExamples cut = new StreamExamples();

    @Test
    public void multiplyByTwo() {
        List<Integer> input = List.of(1,2,3,4,7);

        List<Integer> result = cut.multiplyByTwo(input);

        List<Integer> expected = List.of(2,4,6,8,14);
        assertEquals(expected, result);

    }

}