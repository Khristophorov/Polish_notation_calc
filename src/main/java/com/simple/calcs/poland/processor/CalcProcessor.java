package com.simple.calcs.poland.processor;

import org.apache.commons.lang3.tuple.Pair;

/**
 * General interface for data processing
 */
public interface CalcProcessor {
    /**
     * Prepares needed calculation for data.
     * @param input last input from console
     * @param prevData pair of previous data. First data is older then second
     */
    void process(String input, Pair<String, String> prevData);

    /**
     * Returns the result of operation.
     * @return string representation of result operation
     */
    String getResult();

    /**
     * Returns new prevData after processing
     * @param oldPrevData prevData before processing
     * @return updated prevData after processing
     */
    default Pair<String, String> getPrevData(Pair<String, String> oldPrevData) {
        return Pair.of(oldPrevData.getRight(), getResult());
    }
}
