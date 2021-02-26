package com.johnnybuildsit.java_coding_problems.slidingWindows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SlidingWindows {
    /*
    Given an array of positive numbers and a positive number ‘k’,
    find the maximum sum of any contiguous subarray of size ‘k’.
     */
    // time complexity O(input * windowSize)
    public int maxSumSubArraySizeKBruteForce(final int windowSize, final int[] input) {
        int maxSum = 0;

        for(int i = 0; i < input.length - windowSize; i++) {
            int curSum = 0;
            for(int j = i; j < i + windowSize; j++) {
                curSum += input[j];
            }
            if(curSum > maxSum) {
                maxSum = curSum;
            }
        }

        return maxSum;
    }

    // time complexity O(input)
    public int maxSumSubArraySizeKOptimized(final int windowSize, final int[] input) {
        int maxSum = 0;
        int curSum = 0;
        int windowStart = 0;

        for(int windowEnd = 0; windowEnd < input.length; windowEnd++) {
            curSum += input[windowEnd];

            if(windowEnd >= windowSize - 1) {//if windowSize = 3, want index 0,1,2
                maxSum = Math.max(curSum, maxSum);
                curSum -= input[windowStart];
                windowStart++;
            }
        }

        return maxSum;
    }

    /*
    Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
    Return 0 if no such subarray exists.
     */
    public int smallestSubArrayWithGivenSumBruteForce(final int targetSum, final int[] input) {
        int smallestWindow = Integer.MAX_VALUE;

        for(int i = 0; i < input.length; i++) {
            int curWindow = 0;
            int curSum = 0;

            for(int j = i; j < input.length; j++){
                curWindow += 1;
                curSum += input[j];
                if(curSum >= targetSum) {
                    if(curWindow < smallestWindow){
                        smallestWindow = curWindow;
                    }
                    break;
                }
            }
        }

        return smallestWindow;
    }

    public int smallestSubArrayWithGivenSumOptimized(final int targetSum, final int[] input) {
        int curSum = 0, windowStart = 0;
        int minLength = Integer.MAX_VALUE;
        for(int windowEnd = 0; windowEnd < input.length; windowEnd++){
            curSum += input[windowEnd];
            while(curSum >= targetSum){
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                curSum -= input[windowStart];
                windowStart++;
            }
        }
        return minLength;
    }

    /*
    Given a string, find the length of the longest substring in it
    with no more than K distinct characters.
     */
    public int longestSubstringWithDistinctChars(final String input, final int lettersAllowed) {
        int maxSubstringLen = 0;

        for(int i = 0; i < input.length(); i++) {
            final HashSet<Character> curChars = new HashSet<>();
            int curSubstringLen = 0;

            for(int j = i; j < input.length(); j++) {
                if(!curChars.contains(input.charAt(j)) && curChars.size() == lettersAllowed){
                    maxSubstringLen = Math.max(maxSubstringLen, curSubstringLen);
                    break;
                } else {
                    curChars.add(input.charAt(j));
                    curSubstringLen++;
                }
            }
        }
        return maxSubstringLen;
    }

    public int longestSubstringWithDistinctCharsOptimized(String input, int lettersAllowed) {
        final HashMap<Character, Integer> windowChars = new HashMap<>();
        int windowStart = 0, curWindowSize = 0;
        int maxWindowSizeSeen = 0;
        for(int windowEnd = 0; windowEnd < input.length(); windowEnd++){
            char curChar = input.charAt(windowEnd);
            windowChars.put(curChar, windowChars.getOrDefault(curChar, 0) + 1);
            curWindowSize++;
            while(windowChars.size() > lettersAllowed){
                char startChar = input.charAt(windowStart);
                int startCharCount = windowChars.get(startChar);
                if(startCharCount == 1){
                    windowChars.remove(startChar);
                } else {
                    windowChars.put(startChar, windowChars.get(startChar) - 1);
                }
                windowStart++;
                curWindowSize--;
            }
            maxWindowSizeSeen = Math.max(maxWindowSizeSeen, curWindowSize);
        }
        return maxWindowSizeSeen;
    }

    /*
    Given a string, find the length of the longest substring, which has no repeating characters
     */
    public int longestNoRepeatSubstring(String input) {
        int maxLen = 0, windowStart = 0;
        HashSet<Character> chars = new HashSet<>();
        for(int windowEnd = 0; windowEnd < input.length(); windowEnd++){
            Character curChar = input.charAt(windowEnd);
            if(chars.contains(curChar)){
                windowStart = windowEnd;
                chars = new HashSet<>();
                chars.add(curChar);
            }else{
                chars.add(curChar);
            }
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }
        return maxLen;
    }

    /*
    Given a string with lowercase letters only, if you are allowed to replace
    no more than ‘k’ letters with any letter, find the length of the longest
    having the same letters after replacement
     */
    // time complexity O(n)
    // space complexity O(# letters in alphabet) if ever letter is in input string
    public int longestSubstringWithSameLettersAfterReplacement(String input, int replacementsAllowed) {
        final HashMap<Character, Integer> charFrequencies = new HashMap<>();
        int maxInCurWindow = 0, maxOverall = 0;
        int windowStart = 0;
        // the window will go from the start to the finish of the array
        for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            char windowEndChar = input.charAt(windowEnd);
            // if windowEndChar is not in charFrequencies, zero will be returned
            // as its value and 1 will be added
            charFrequencies.put(windowEndChar, charFrequencies.getOrDefault(windowEndChar, 0) + 1);
            maxInCurWindow = Math.max(maxInCurWindow, charFrequencies.get(windowEndChar));
            // 1 is added to windowEnd - windowStart to give a size of at least 1
            if ((windowEnd - windowStart + 1) - maxInCurWindow > replacementsAllowed) {
                char windowStartChar = input.charAt(windowStart);
                charFrequencies.put(windowStartChar, charFrequencies.get(windowStartChar) + 1);
                windowStart++;
            }
            maxOverall = Math.max(maxOverall, windowEnd - windowStart + 1);
        }
        return maxOverall;
    }

    /*
    Given an array containing 0s and 1s, if you are allowed to replace
    no more than ‘k’ 0s with 1s, find the length of the longest contiguous subarray having all 1s
    time complexity - O(n)
    space complecity - O(1)
     */
    public int longestSubarrayWithOnesAfterReplacement(int[] input, int replacementsAllowed) {
        int frequencyOf1s = 0, windowStart = 0;
        int maxLenContinuous1s = 0;
        for (int windowEnd = 0; windowEnd < input.length; windowEnd++) {
            int windowEndNum = input[windowEnd];
            if (windowEndNum == 1) {
                frequencyOf1s++;
            }
            // subtracting frequency of 1s b/c those are replacements that did not have to be made
            if ((windowEnd - windowStart + 1) - frequencyOf1s > replacementsAllowed) {
                if (input[windowStart] == 1) {
                    frequencyOf1s--;
                }
                windowStart++;
            }
            maxLenContinuous1s = Math.max(maxLenContinuous1s, windowEnd - windowStart + 1);
        }
        return maxLenContinuous1s;
    }

    /*
    Given a string and a pattern, find out if the string contains any permutation of the pattern
     */
    public boolean permutationInString(String input, String pattern) {
        HashMap<Character, Integer> permutationLetters = permutationToMap(pattern);
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            final char curChar = input.charAt(windowEnd);
            if (!permutationLetters.containsKey(curChar)) {
                windowStart = windowEnd + 1;
                permutationLetters = permutationToMap(pattern);
            } else {
                if (permutationLetters.get(curChar) == 0) {
                    windowStart++;
                    permutationLetters = permutationToMap(pattern);
                    permutationLetters.put(curChar, permutationLetters.get(curChar) - 1);
                } else {
                    permutationLetters.put(curChar, permutationLetters.get(curChar) - 1);
                    if (permutationLetters.get(curChar) == 0 && windowEnd - windowStart + 1 == permutationLetters.size()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public HashMap<Character, Integer> permutationToMap(String pattern) {
        final HashMap<Character, Integer> outMap = new HashMap<Character, Integer>();
        pattern
            .chars()
            .mapToObj(c -> (char) c)
            .forEach(c -> outMap.put(c, outMap.getOrDefault(c, 0) + 1));
        return outMap;
    }

    /*
    Given a string and a pattern, find all anagrams of the pattern in the given string.
    Write a function to return a list of starting indices of the anagrams of the pattern in the given string.
     */
    public List<Integer> stringAnagrams(String input, String pattern) {
        final List<Integer> resultIndices = new ArrayList<Integer>();
        HashMap<Character, Integer> chars = permutationToMap(pattern);
        int curStartIndex = 0, windowStart = 0;
        for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            char curChar = input.charAt(windowEnd);
            if (!chars.containsKey(curChar)) {
                chars = permutationToMap(pattern);
                windowStart = windowEnd + 1;
            } else {
                if (chars.get(curChar) == 0) {
                    chars = permutationToMap(pattern);
                    windowStart = windowEnd;
                }
                chars.put(curChar, chars.get(curChar) - 1);
                int windowSize = windowEnd - windowStart + 1;
                if (windowSize == 1) {
                    curStartIndex = windowStart;
                } else if (windowSize == chars.size()) {
                    resultIndices.add(curStartIndex);
                    chars = permutationToMap(pattern);
                    windowStart++;
                    windowEnd = windowStart;
                    curChar = input.charAt(windowEnd);
                    chars.put(curChar, chars.get(curChar) - 1);
                    curStartIndex = windowStart;
                }
            }
        }
        return resultIndices;
    }

    public String smallestWindowContainingSubstring(String input, String pattern) {
        return "";
    }
}
