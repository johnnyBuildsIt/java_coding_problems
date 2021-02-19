package com.johnnybuildsit.java_coding_problems.slidingWindows;

public class SlidingWindows {
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

    public int smallestSubArrayWithGivenSum(int targetSum, int[] input) {
        return 0;
    }
}
