package com.nealford.functionalthinking.numberclassifier;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.lang.Math.sqrt;
/**
 * 优化了的完美数分类的命令式实现
 */
public class ImpNumberClassifierOptimized {
    private int _number;
    private Map<Integer, Integer> _cache;

    public ImpNumberClassifierOptimized(int targetNumber) {
        _number = targetNumber;
        _cache = new HashMap<>();
    }

    private boolean isFactor(int candidate) {
        return _number % candidate == 0;
    }

    private Set<Integer> getFactors() {
        Set<Integer> factors = new HashSet<>();
        factors.add(1);
        factors.add(_number);
        for (int i = 2; i <= sqrt(_number); i++){
            if (isFactor(i)){
                factors.add(i);
                factors.add(_number / i);
            }
        }
        return factors;
    }

    /**
     * 真约数和
     * @return
     */
    private int aliquotSum() {
        int sum = 0;
        for (int i : getFactors()){
            sum += i;
        }
        return sum - _number;
    }

    private int cachedAliquotSum() {
        if (_cache.containsKey(_number)){
            return _cache.get(_number);
        } else {
            int sum = aliquotSum();
            _cache.put(_number, sum);
            return sum;
        }
    }


    /**
     * 是否完美数
     * @return
     */
    public boolean isPerfect() {
        return cachedAliquotSum() == _number;
    }

    /**
     * 是否过剩数
     * @return
     */
    public boolean isAbundant() {
        return cachedAliquotSum() > _number;
    }

    /**
     * 是否不足数
     * @return
     */
    public boolean isDeficient() {
        return cachedAliquotSum() < _number;
    }
}
