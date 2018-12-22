package com.simple.calcs.poland.processor;

import org.apache.commons.lang3.tuple.Pair;

/**
 * {@link CalcProcessor} implementation for division
 */
public class DivideProcessor implements CalcProcessor {
    private double result;
    /**
     * Divides prevData
     * @param input last input from console
     * @param prevData pair of previous data. First data is older then second
     */
    @Override
    public void process(String input, Pair<String, String> prevData) {
        double left = Double.parseDouble(prevData.getLeft());
        double right = Double.parseDouble(prevData.getRight());
        result = left / right;
    }

    /**
     * Returns division result
     * @return division result
     */
    @Override
    public String getResult() {
        return String.valueOf(result);
    }
}
