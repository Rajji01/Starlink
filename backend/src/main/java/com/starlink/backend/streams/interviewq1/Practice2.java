package com.starlink.backend.streams.interviewq1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Practice2 {
    public static void main(String[] args) {
        List<List<String>> menu = Arrays.asList(
                Arrays.asList("Pizza", "Burger", "Pasta"),
                Arrays.asList("Dosa", "Idli", "Vada"),
                Arrays.asList("Biryani", "Naan")
        );

// map — nested stream of streams
        Stream<Stream<String>> wrong = menu.stream()
                .map(list -> list.stream());  // ❌ nested

// flatMap — flat stream
        Stream<String> correct = menu.stream()
                .flatMap(list -> list.stream());  // ✅ flat
    }
}
