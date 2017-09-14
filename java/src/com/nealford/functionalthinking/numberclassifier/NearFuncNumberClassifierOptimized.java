package com.nealford.functionalthinking.numberclassifier;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.sqrt;

/**
 * 优化了的稍微向函数式靠拢的完美数分类实现
 */
public class NearFuncNumberClassifierOptimized {

    public static boolean isFactor(final int candidate, final int number) {
        return number % candidate == 0;
    }

    public static Set<Integer> factors(final int number) {
        Set<Integer> factors = new HashSet<>();
        factors.add(1);
        factors.add(number);
        for (int i = 2; i <= sqrt(number); i++){
            if (isFactor(i, number)){
                factors.add(i);
                factors.add(number / i);
            }
        }
        return factors;
    }

    public static int sum(final Collection<Integer> factors) {
        int sum = 0;
        for (int n : factors){
            sum += n;
        }
        return sum;
    }

    public static boolean isPerfect(final int number) {
        return sum(factors(number)) - number == number;
    }

    public static boolean isAbundant(final int number) {
        return sum(factors(number)) - number > number;
    }

    public static boolean isDeficient(final int number) {
        return sum(factors(number)) -number < number;
    }
}
