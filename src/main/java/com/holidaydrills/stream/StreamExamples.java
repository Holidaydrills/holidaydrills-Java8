package com.holidaydrills.stream;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamExamples {

    //Prints "Hello how are you? "
    public void iterateWithLoop() {
        List<String> input = List.of("Hello", "how", "are", "you?");
        for(String word : input) {
            System.out.print(word + " ");
        }
    }

    //Prints "Hello how are you? "
    public void useStream() {
        List<String> input = List.of("Hello", "how", "are", "you?");
        input.stream().forEach(word -> System.out.print(word + " "));
    }


    // Returns a list (2,4,6,8,14)
    public List<Integer> multiplyByTwo() {
        List<Integer> input = List.of(1,2,3,4,7);
        List<Integer> result = new LinkedList<>();
        for(Integer number : input) {
            result.add(number * 2);
        }
        return result;
    }

    // Returns a list (2,4,6,8,14)
    public List<Integer> multiplyByTwoWithStream() {
        List<Integer> input = List.of(1,2,3,4,7);
        List<Integer> result = input.stream().map(number -> number * 2).collect(Collectors.toList());
        return result;
    }

    public void processParallel() {
        List<Integer> input = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
        // Prints the numbers in a non predictable way as they're processed in parallel.
        // One possible output could be "7 12 18 11 20 6 19 15 17 14 9 16 3 10 2 8 1 5 4 13 "
        input.parallelStream().forEach(number -> System.out.print(number + " "));
    }

    public void collectInMap() {
        // Prepare list of data
        List<Book> books = List.of(
                new Book("9780062316097", "Sapiens - A Brief History of Humankind", "Yuval Noah Harari"),
                new Book("9780141033570", "Thinking, Fast and Slow", "Daniel Kahneman"),
                new Book("9780141983769", "Why We Sleep", "Matthew Walker"));

        // Stream the list and collect in a map
        Map<String, Book> UuidToPerson = books
                .stream()
                .collect(Collectors.toMap(Book::getIsbn, Function.identity()));

        // Print values of the map
        for(Map.Entry<String, Book> entry : UuidToPerson.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getTitle());
        }
    }


    public Map<String, List<Book>> groupBooksByAuthor() {
        List<Book> books = List.of(
                new Book("Yuval Noah Harari", "Sapiens - A Brief History of Humankind"),
                new Book("Yuval Noah Harari", "Homo Deus"),
                new Book("Yuval Noah Harari", "21 Lessons for the 21st Century"),
                new Book("Daniel Kahneman", "Thinking, Fast and Slow"),
                new Book("Daniel Kahneman", "Heuristics and Biases"),
                new Book("Matthew Walker", "Why We Sleep")
        );

        // The classification function is book.getAuthor().
        // The result of the classification function is used as key for the resulting map.
        Map<String, List<Book>> authorToBooks = books.stream().collect(Collectors.groupingBy(Book::getAuthor));

        return authorToBooks;
    }

    public double getSumOfBookPricesWithCollector() {
        List<Book> books = List.of(
                new Book("Sapiens - A Brief History of Humankind", 19.00),
                new Book("Thinking, Fast and Slow", 20.00),
                new Book("Why We Sleep", 21.00));

        double sumOfBookPrices = books.stream().collect(Collectors.summingDouble(Book::getPrice));

        // Will return 60.00
        return sumOfBookPrices;
    }

    public double getSumOfBookPricesPrices() {
        List<Book> books = List.of(
                new Book("Sapiens - A Brief History of Humankind", 19.00),
                new Book("Thinking, Fast and Slow", 20.00),
                new Book("Why We Sleep", 21.00));

        double sumOfBookPrices = books.stream().mapToDouble(Book::getPrice).sum();

        return sumOfBookPrices;
    }
}
