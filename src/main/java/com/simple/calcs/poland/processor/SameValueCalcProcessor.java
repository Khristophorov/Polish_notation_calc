package com.simple.calcs.poland.processor;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Stub implementation of {@link CalcProcessor} for cases when no changes needed
 */
public class SameValueCalcProcessor implements CalcProcessor {
    /**
     * Just do nothing
     * @param input last input from console
     * @param prevData pair of previous data. First data is older then second
     */
    @Override
    public void process(String input, Pair<String, String> prevData) {
        return;
    }

    /**
     * {@link SameValueCalcProcessor} shouldn't provide any results
     * @return null
     */
    @Override
    public String getResult() {
        return StringUtils.EMPTY;
    }

    /**
     * Returns the same prevData
     * @param oldPrevData prevData before processing
     * @return same prevData
     */
    @Override
    public Pair<String, String> getPrevData(Pair<String, String> oldPrevData) {
        return oldPrevData;
    }
}
