package com.nealford.functionalthinking.numberclassifier;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 完美数分类的命令式实现
 */
public class ImpNumberClassifierSimple {
    private int _number;
    private Map<Integer, Integer> _cache;

    public ImpNumberClassifierSimple(int targetNumber) {
        _number = targetNumber;
        _cache = new HashMap<>();
    }

    private boolean isFactor(int potential) {
        return _number % potential == 0;
    }

    private Set<Integer> getFactors() {
        Set<Integer> factors = new HashSet<>();
        factors.add(1);
        factors.add(_number);
        for (int i=2; i<_number; i++){
            if (isFactor(i)){
                factors.add(i);
            }
        }
        return factors;
    }

    /**
     * 真约数和
     * @return
     */
    private int aliquotSum() {
        if (_cache.get(_number) == null) {
            int sum = 0;
            for (int i : getFactors()){
                sum += i;
            }
            _cache.put(_number, sum - _number);
        }
        return _cache.get(_number);
    }

    /**
     * 是否完美数
     * @return
     */
    public boolean isPerfect() {
        return aliquotSum() == _number;
    }

    /**
     * 是否过剩数
     * @return
     */
    public boolean isAbundant() {
        return aliquotSum() > _number;
    }

    /**
     * 是否不足数
     * @return
     */
    public boolean isDeficient() {
        return aliquotSum() < _number;
    }

}
