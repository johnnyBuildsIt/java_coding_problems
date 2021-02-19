package com.johnnybuildsit.java_coding_problems.stringsNumbersMath;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class CountingDuplicateCharacters {
    public Map<Character, Integer> countDuplicatesImperative(final String inString) {
        final Map<Character, Integer> dupCounts = new HashMap<>();

        for(int i = 0; i < inString.length(); i++){
            final char currChar = inString.charAt(i);

            if (dupCounts.containsKey(currChar)){
                dupCounts.put(currChar, dupCounts.get(currChar) + 1);
            } else {
                dupCounts.put(currChar, 1);
            }
        }

        return dupCounts;
    }

    public Map<Character, Long> countDuplicatesStream(final String inString) {
        final IntStream intStream = inString.chars();
        final Stream<Character> characterStream = intStream.mapToObj(c -> (char) c);
        final Map<Character, Long> dupCounts = characterStream.collect(groupingBy(c -> c, counting()));
        return dupCounts;
    }
}
