package com.johnnybuildsit.java_coding_problems.slidingWindows;

public class SlidingWindows {
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
}
