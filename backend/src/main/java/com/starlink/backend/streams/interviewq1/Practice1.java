package com.starlink.backend.streams.interviewq1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice1 {
    public static void main(String[] args) {
        ArrayList<Integer>first= new ArrayList<>();
        first.add(1);
        List<?>arl= new ArrayList<>(first);
//        arl.add(1); not allowed
        for(Integer ar: first){
            System.out.println(ar);
        }
        Stream.iterate(0,i->i+1)
                .filter(i->i%2==0)
                .limit(10)
                .forEach(s->System.out.println(s));
        Stream.iterate(0,i->i+1)
                .filter(i->i%2==0)
                .peek(s->System.out.println(s))
                .filter(i->i<20)
                .limit(10)
                .forEach(s->System.out.println(s));

        boolean result = Stream.<Integer>empty().allMatch(n -> n > 100);
        System.out.println(result);
         result = Stream.<Integer>empty().noneMatch(n -> n > 100);
        System.out.println(result);
        result = Stream.<Integer>empty().anyMatch(n -> n > 100);
        System.out.println(result);

        List<Integer> list = Arrays.asList(1, 3, 5, 4, 7, 9, 2);

// Approach A
        list.stream().filter(n -> n % 2 != 0).forEach(System.out::print);
        System.out.println();
// Approach B
        list.stream().takeWhile(n -> n % 2 != 0).forEach(System.out::print);
//        135 first encounter with even then stop

        // Goal: sum 100 cross karte hi ruk ja
        AtomicInteger sum = new AtomicInteger(0);
        List<Integer> results = Stream.of(10, 20, 30, 40, 50, 60)
                .takeWhile(n -> sum.addAndGet(n) <= 100)
                .collect(Collectors.toList());
// Result: [10, 20, 30, 40] — sum = 100 pe ruka
        System.out.println(result);


        Stream<Integer> s = list.stream()
                .filter(n -> n > 2)
                .peek(System.out::println) // ye kitchen ko "recipe" bata rahe hain
                .map(n -> n * 10)        // ye bhi recipe mein add ho rahi hai
                .peek(System.out::println); // ye bhi recipe hai

// ⚠️ Is line tak KUCH BHI execute nahi hua!
// Sirf ek "pipeline blueprint" bana hai.

        s.collect(Collectors.toList()); // 🔥 YE "Place Order" hai — ab kitchen chalu!

        List<Integer> lists = Arrays.asList(1, 2, 3);
        Stream<Integer> pipeline = lists.stream()
                .filter(n -> {
                    System.out.println("Filter chal raha: " + n);
                    return n > 1;
                });

        System.out.println("Pipeline ban gaya, terminal nahi lagaya abhi tak");
        System.out.println("---");

        pipeline.forEach(n -> System.out.println("Final: " + n));

    }


}
