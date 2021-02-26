package com.johnnybuildsit.java_coding_problems.twoPointers;

public class TwoPointers {

    /*
    Given an array of sorted numbers and a target sum,
    find a pair in the array whose sum is equal to the given target.
     */
    public int[] pairWithTargetSum(int[] input, int target) {
        final int[] output = new int[2];
        int left = 0, right = input.length - 1;
        while (left < right) {
            int curSum = input[left] + input[right];
            if (curSum > target) {
                right--;
            } else if (curSum < target) {
                left++;
            } else {
                output[0] = left;
                output[1] = right;
                break;
            }
        }
        return output;
    }

    public int removeDuplicates(int[] input) {
        int nonDuplicateEnd = 1;
        for (int pointer = 1; pointer < input.length; pointer++) {
            if (input[nonDuplicateEnd] != input[pointer]) {
                input[nonDuplicateEnd] = input[pointer];
                nonDuplicateEnd++;
            }
        }
        return nonDuplicateEnd;
    }
}
