package com.johnnybuildsit.java_coding_problems.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    public int[] squareSortedArray(int[] input) {
        final int[] output = new int[input.length];
        int lastIndex = 0;
        int lowPointer = -1, highPointer = input.length;
        int pivot = minNonNegativeIndex(input);

        if (pivot == 0) {
            highPointer = 0;
        } else if (pivot > 0 && pivot < input.length - 1) {
            highPointer = pivot;
            lowPointer = pivot - 1;
        } else if (pivot == input.length - 1) {
            lowPointer = pivot;
        }

        while (lastIndex < input.length) {
            if (lowPointer >= 0 && highPointer <= input.length - 1) {
                int sq0 = (int) Math.pow(input[lowPointer], 2);
                int sq1 = (int) Math.pow(input[highPointer], 2);

                if (sq0 < sq1) {
                    output[lastIndex] = sq0;
                    lastIndex++;
                    output[lastIndex] = sq1;
                    lastIndex++;
                } else {
                    output[lastIndex] = sq1;
                    lastIndex++;
                    output[lastIndex] = sq0;
                    lastIndex++;
                }

                lowPointer--;
                highPointer++;
            } else if (lowPointer == -1) {
                output[lastIndex] = (int) Math.pow(input[highPointer], 2);
                lastIndex++;
                highPointer++;
            } else if (highPointer == input.length) {
                output[lastIndex] = (int) Math.pow(input[lowPointer], 2);
                lastIndex++;
                lowPointer--;
            }
        }

        return output;
    }

    public int minNonNegativeIndex(int[] input) {
        int nonNegativeIndex = 0;
        int prevElement = input[0];
        for (int i = 0; i < input.length; i++) {
            int curElement = input[i];
            if (curElement >= 0) {
                nonNegativeIndex = i;
                break;
            } else if (curElement > prevElement) {
                prevElement = curElement;
                nonNegativeIndex = i;
            }
        }
        return nonNegativeIndex;
    }

    public List<List<Integer>> tripletSumToZero(int[] input) {
        Arrays.sort(input);
        final ArrayList<List<Integer>> output = new ArrayList<>();
        final int targetSum = 0;
        for (int i = 0; i < input.length; i++) {
            int low = i + 1;
            int high = input.length - 1;
            final int curElement = input[i];
            while (low < high) {
                final int curLow = input[low];
                final int curHigh = input[high];
                final int curSum = input[i] + input[low] + input[high];
                if(curSum == targetSum) {
                    final List<Integer> curOutput = Arrays.asList(curElement, curLow, curHigh);
                    Collections.sort(curOutput);
                    output.add(curOutput);
                    low++;
                    high--;
                    while (input[low] == input[low - 1]) {
                        low++;
                    }
                    while (input[high] == input[high + 1]) {
                        high--;
                    }
                } else if (curSum < targetSum) {
                    low++;
                } else {
                    high--;
                }
            }

        }
        return output;
    }

    public int tripletSumCloseToTarget(int[] input, int targetSum) {
        int smallestDif = Integer.MAX_VALUE;
        int closestSum = 0;
        for(int curIndex = 0; curIndex < input.length - 2; curIndex++) {
            int left = curIndex + 1;
            int right = input.length - 1;
            while (left < right) {
                final int sum = input[curIndex] + input[left] + input[right];
                final int diff = Math.abs(targetSum - sum);
                if (diff < smallestDif) {
                    smallestDif = diff;
                    closestSum = sum;
                }

                if (sum < targetSum) {
                    left++;
                } else if (sum > targetSum) {
                    right--;
                }
            }
        }
        return closestSum;
    }
}
