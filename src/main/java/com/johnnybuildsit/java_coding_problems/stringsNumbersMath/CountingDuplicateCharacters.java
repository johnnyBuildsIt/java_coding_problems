package com.johnnybuildsit.java_coding_problems.stringsNumbersMath;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class CountingDuplicateCharacters {
    public Map<Character, Integer> countDuplicatesImperative(String inString) {
        Map<Character, Integer> dupCounts = new HashMap<>();

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

    public Map<Character, Integer> countDuplicatesStream(String inString) {
        return null;
    }
}
