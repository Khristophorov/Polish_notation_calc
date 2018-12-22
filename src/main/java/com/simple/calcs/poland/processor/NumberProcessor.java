package com.simple.calcs.poland.processor;

import org.apache.commons.lang3.tuple.Pair;

/**
 * {@link CalcProcessor} implementation for numbers.
 * Numbers are using as parameters for arithmetical calculations
 */
public class NumberProcessor implements CalcProcessor {
    private String result;

    /**
     * {@link NumberProcessor} sorts numbers as operators for calculation
     * @param input last input from console
     * @param prevData pair of previous data. First data is older then second
     */
    @Override
    public void process(String input, Pair<String, String> prevData) {
        result = input;
    }

    /**
     * Returns the same value as input
     * @return input
     */
    @Override
    public String getResult() {
        return result;
    }
}
