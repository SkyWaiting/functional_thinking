package com.nealford.functionalthinking.numberclassifier;

import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

/**
 * 完美数分类的Java 8实现
 */
public class NumberClassifierByJava8 {

    public static IntStream factorsOf(int number) {
        return range(1, number+1).filter(potential -> number % potential == 0);
    }

    public static int aliquotSum(int number) {
        return factorsOf(number).sum() - number;
    }

    public static boolean isPerfect(final int number) {
        return aliquotSum(number) == number;
    }

    public static boolean isAbundant(final int number) {
        return aliquotSum(number) > number;
    }

    public static boolean isDeficient(final int number) {
        return aliquotSum(number) < number;
    }
}
