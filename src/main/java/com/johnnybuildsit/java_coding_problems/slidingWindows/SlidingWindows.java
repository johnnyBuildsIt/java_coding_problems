package com.johnnybuildsit.java_coding_problems.slidingWindows;

public class SlidingWindows {
    /*
    Given an array of positive numbers and a positive number ‘k’,
    find the maximum sum of any contiguous subarray of size ‘k’.
     */
    // time complexity O(input * windowSize)
    public int maxSumSubArraySizeKBruteForce(int windowSize, int[] input) {
        int maxSum = 0;
        for(int i = 0; i < input.length - windowSize; i++){
            int curSum = 0;
            for(int j = i; j < i + windowSize; j++){
                curSum += input[j];
            }
            if(curSum > maxSum){
                maxSum = curSum;
            }
        }
        return maxSum;
    }

    // time complexity O(input)
    public int maxSumSubArraySizeKOptimized(int windowSize, int[] input) {
        int maxSum = 0;
        int curSum = 0;
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < input.length; windowEnd++){
            curSum += input[windowEnd];
            if(windowEnd >= windowSize - 1){//if windowSize = 3, want index 0,1,2
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
    public int smallestSubArrayWithGivenSumBruteForce(int targetSum, int[] input) {
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
    public int smallestSubArrayWithGivenSumOptimized(int targetSum, int[] input) {
        int curSum = input[0];
        int curWindow = 1;
        int smallestWindow = Integer.MAX_VALUE;
        int windowStart = 0, windowEnd = 0;

        while(windowEnd < input.length){
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
                if (curSum == targetSum){
                    smallestWindow = Math.min(curWindow, smallestWindow);
                }
            }
        }
        return smallestWindow;
    }
}
