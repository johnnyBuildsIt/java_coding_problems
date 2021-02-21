package com.johnnybuildsit.java_coding_problems.slidingWindows;

import java.util.HashMap;
import java.util.HashSet;

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

    // can be made more concise with a for loop as the outer loop
    public int smallestSubArrayWithGivenSumOptimized(final int targetSum, final int[] input) {
        int curSum = input[0];
        int curWindow = 1;
        int smallestWindow = Integer.MAX_VALUE;
        int windowStart = 0, windowEnd = 0;

        while(windowEnd < input.length) {
            // increase window
            while(curSum < targetSum) {
                windowEnd++;
                curWindow++;
                if(windowEnd < input.length){
                    curSum += input[windowEnd];
                } else {
                    break;
                }
            }

            smallestWindow = Math.min(curWindow, smallestWindow);
            // decrease window
            while(curSum >= targetSum){
                curSum -= input[windowStart];
                windowStart++;
                curWindow--;

                if (curSum == targetSum) {
                    smallestWindow = Math.min(curWindow, smallestWindow);
                }
            }
        }
        return smallestWindow;
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
        int maxSubstringLen = 0;
        int windowStart = 0;
        final HashMap<Character, Integer> curChars = new HashMap<>();

        for(int windowEnd = 0; windowEnd < input.length(); windowEnd++){
            if (!curChars.containsKey(input.charAt(windowEnd))){
                curChars.put(input.charAt(windowEnd), 1);
            } else {
                curChars.put(input.charAt(windowStart), curChars.get(input.charAt(windowStart)) + 1);
            }

            if (curChars.size() <= lettersAllowed) {
                maxSubstringLen = Math.max(maxSubstringLen, (windowEnd + 1) - windowStart);
            }

            while (curChars.size() > lettersAllowed) {
                if (curChars.get(input.charAt(windowStart)) == 1) {
                    curChars.remove(input.charAt(windowStart));
                } else {
                    curChars.put(input.charAt(windowStart), curChars.get(input.charAt(windowStart)) - 1);
                }
                windowStart++;
            }
        }

        return maxSubstringLen;
    }

    /*
    Given a string, find the length of the longest substring, which has no repeating characters
     */
    public int longestNoRepeatSubstring(String input) {
        int maxLength = 0;
        int windowStart = 0;
        final HashMap<Character, Integer> charIndexes = new HashMap<>();
        for(int windowEnd = 0; windowEnd < input.length(); windowEnd++){
            final char curChar = input.charAt(windowEnd);
            if (charIndexes.containsKey(curChar)){
                windowStart = Math.max(windowStart, charIndexes.get(curChar) + 1);// +1 b/c if start is at same index of curChar, need it to move forward 1
            }
            charIndexes.put(curChar, windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);// +1 b/c if start and end are same, want string len of 1
        }
        return maxLength;
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
}
