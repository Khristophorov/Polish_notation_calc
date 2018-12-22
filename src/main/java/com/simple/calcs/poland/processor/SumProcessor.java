package com.simple.calcs.poland.processor;

import org.apache.commons.lang3.tuple.Pair;

/**
 * {@link CalcProcessor} implementation for summation
 */
public class SumProcessor implements CalcProcessor {
    private double result;

    /**
     * Summarizes prevData
     * @param input last input from console
     * @param prevData pair of previous data. First data is older then second
     */
    @Override
    public void process(String input, Pair<String, String> prevData) {
        double left = Double.parseDouble(prevData.getLeft());
        double right = Double.parseDouble(prevData.getRight());
        result = left + right;
    }

    /**
     * Returns summation result
     * @return summation result
     */
    @Override
    public String getResult() {
        return String.valueOf(result);
    }
}
