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
}
