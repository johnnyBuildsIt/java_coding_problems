package com.johnnybuildsit.java_coding_problems.twoPointers;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class TwoPointersTest {
    @Nested
    class PairWithTargetSum {
        @Test
        void pairWithTargetSumTest() {
            final int[] input = {1, 2, 3, 4, 6};
            final int target = 6;
            final TwoPointers twoPointers = new TwoPointers();

            final int[] result = twoPointers.pairWithTargetSum(input, target);

            assertAll(
                    () -> assertThat(result[0]).isEqualTo(1),
                    () -> assertThat(result[1]).isEqualTo(3)
            );
        }

        @Test
        void pairWithTargetSumTest1() {
            final int[] input = {2, 5, 9, 11};
            final int target = 11;
            final TwoPointers twoPointers = new TwoPointers();

            final int[] result = twoPointers.pairWithTargetSum(input, target);

            assertAll(
                    () -> assertThat(result[0]).isEqualTo(0),
                    () -> assertThat(result[1]).isEqualTo(2)
            );
        }
    }

    @Nested
    class RemoveDuplicates {
        @Test
        void removeDuplicatesTest() {
            final int[] input = {2, 3, 3, 3, 6, 9, 9};
            final TwoPointers twoPointers = new TwoPointers();

            final int result = twoPointers.removeDuplicates(input);

            assertThat(result).isEqualTo(4);
        }

        @Test
        void removeDuplicatesTest1() {
            final int[] input = {2, 2, 2, 11};
            final TwoPointers twoPointers = new TwoPointers();

            final int result = twoPointers.removeDuplicates(input);

            assertThat(result).isEqualTo(2);
        }
    }

    @Nested
    class SquareSortedArray {
        @Test
        void squareSortedArrayTest() {
            final int[] input = {-2, -1, 0, 2, 3};
            final TwoPointers twoPointers = new TwoPointers();

            final int[] result = twoPointers.squareSortedArray(input);

            assertAll(
                    () -> assertThat(result[0]).isEqualTo(0),
                    () -> assertThat(result[1]).isEqualTo(1),
                    () -> assertThat(result[2]).isEqualTo(4),
                    () -> assertThat(result[3]).isEqualTo(4),
                    () -> assertThat(result[4]).isEqualTo(9)
            );
        }

        @Test
        void squareSortedArrayTest1() {
            final int[] input = {0, 2, 3};
            final TwoPointers twoPointers = new TwoPointers();

            final int[] result = twoPointers.squareSortedArray(input);

            assertAll(
                    () -> assertThat(result[0]).isEqualTo(0),
                    () -> assertThat(result[1]).isEqualTo(4),
                    () -> assertThat(result[2]).isEqualTo(9)
            );
        }

        @Test
        void squareSortedArrayTest2() {
            final int[] input = {-8, -2, -1};
            final TwoPointers twoPointers = new TwoPointers();

            final int[] result = twoPointers.squareSortedArray(input);

            assertAll(
                    () -> assertThat(result[0]).isEqualTo(1),
                    () -> assertThat(result[1]).isEqualTo(4),
                    () -> assertThat(result[2]).isEqualTo(64)
            );
        }
    }

    @Nested
    class MinNonNegativeIndex {
        @Test
        void minNonNegativeIndexTest() {
            final int[] input = {-2, -1, 0, 2, 3};
            final TwoPointers twoPointers = new TwoPointers();

            final int result = twoPointers.minNonNegativeIndex(input);

            assertThat(result).isEqualTo(2);
        }

        @Test
        void minNonNegativeIndexTest1() {
            final int[] input = {0, 2, 3};
            final TwoPointers twoPointers = new TwoPointers();

            final int result = twoPointers.minNonNegativeIndex(input);

            assertThat(result).isEqualTo(0);
        }

        @Test
        void minNonNegativeIndexTest2() {
            final int[] input = {-8, -2, -1};
            final TwoPointers twoPointers = new TwoPointers();

            final int result = twoPointers.minNonNegativeIndex(input);

            assertThat(result).isEqualTo(2);
        }
    }

    @Nested
    class TripletSumToZero {
        @Test
        void tripletSumToZeroTest() {
            final int[] input = {-3, 0, 1, 2, -1, 1, -2};
            final TwoPointers twoPointers = new TwoPointers();

            final List<List<Integer>> result = twoPointers.tripletSumToZero(input);

            assertAll(
                    () -> assertThat(result.get(0).get(0)).isEqualTo(-3),
                    () -> assertThat(result.get(0).get(1)).isEqualTo(1),
                    () -> assertThat(result.get(0).get(2)).isEqualTo(2),

                    () -> assertThat(result.get(1).get(0)).isEqualTo(-2),
                    () -> assertThat(result.get(1).get(1)).isEqualTo(0),
                    () -> assertThat(result.get(1).get(2)).isEqualTo(2),

                    () -> assertThat(result.get(2).get(0)).isEqualTo(-2),
                    () -> assertThat(result.get(2).get(1)).isEqualTo(1),
                    () -> assertThat(result.get(2).get(2)).isEqualTo(1),

                    () -> assertThat(result.get(3).get(0)).isEqualTo(-1),
                    () -> assertThat(result.get(3).get(1)).isEqualTo(0),
                    () -> assertThat(result.get(3).get(2)).isEqualTo(1)
            );
        }
    }

    @Nested
    class TripletSumCloseToTarget {
        @Test
        void tripletSumCloseToTargetTest() {
            final int[] input = {-2, 0, 1, 2};
            final int targetSum = 2;
            final TwoPointers twoPointers = new TwoPointers();

            final int result = twoPointers.tripletSumCloseToTarget(input, targetSum);

            assertThat(result).isEqualTo(1);
        }

        @Test
        void tripletSumCloseToTargetTest1() {
            final int[] input = {-3, -1, 1, 2};
            final int targetSum = 1;
            final TwoPointers twoPointers = new TwoPointers();

            final int result = twoPointers.tripletSumCloseToTarget(input, targetSum);

            assertThat(result).isEqualTo(0);
        }
    }
}