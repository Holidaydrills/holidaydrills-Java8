package com.holidaydrills.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

class StreamExamplesTest {

    StreamExamples cut = new StreamExamples();

    @Test
    public void iterateOverLoop() {
        cut.iterateWithLoop();
    }
    @Test
    public void useStream() {
        cut.useStream();
    }

    @Test
    public void processParallel() {
        cut.processParallel();
    }

    @Test
    public void collectInMap() { cut.collectInMap();}

    @Test
    public void multiplyByTwo() {
        List<Integer> result = cut.multiplyByTwo();

        List<Integer> expected = List.of(2,4,6,8,14);
        assertEquals(expected, result);

    }

    @Test
    public void multiplyByTwoWithStream() {
        List<Integer> result = cut.multiplyByTwoWithStream();

        List<Integer> expected = List.of(2,4,6,8,14);
        assertEquals(expected, result);
    }

    @Test
    public void getSumOfBookPricesWithCollector() {
        double result = cut.getSumOfBookPricesWithCollector();

        double expected = 60.00;
        assertEquals(expected, result);
    }

    @Test void getSumOfBookPricesPrices() {
        double result = cut.getSumOfBookPricesPrices();

        double expected = 60.00;
        assertEquals(expected, result);

    }


    @Test void groupBooksByAuthor() {
        Map<String, List<Book>> result = cut.groupBooksByAuthor();

        Map<String, List<Book>> expected = Map.of(
                "Yuval Noah Harari", List.of(
                        new Book("Yuval Noah Harari", "Sapiens - A Brief History of Humankind"),
                        new Book("Yuval Noah Harari", "Homo Deus"),
                        new Book("Yuval Noah Harari", "21 Lessons for the 21st Century")),
                "Daniel Kahneman", List.of(
                        new Book("Daniel Kahneman", "Thinking, Fast and Slow"),
                        new Book("Daniel Kahneman", "Heuristics and Biases")
                ),
                "Matthew Walker", List.of(
                        new Book("Matthew Walker", "Why We Sleep")
                ));
        List<Book> books = List.of(
                new Book("Yuval Noah Harari", "Sapiens - A Brief History of Humankind"),
                new Book("Yuval Noah Harari", "Homo Deus"),
                new Book("Yuval Noah Harari", "21 Lessons for the 21st Century")
        );

        for(Map.Entry entry : result.entrySet()) {
            assertEquals(expected.get(entry.getKey()), entry.getValue());
        }
    }

}