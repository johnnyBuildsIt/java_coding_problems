package com.johnnybuildsit.java_coding_problems.twoPointers;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
}