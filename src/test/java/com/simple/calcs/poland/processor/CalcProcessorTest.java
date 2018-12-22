package com.simple.calcs.poland.processor;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalcProcessorTest {
    private static final String TEST_RESULT = "54";

    @Test
    @DisplayName(
            "getPrevData should return Pair which should contain right value from oldPrevData and calculation result")
    void testGetPrevData_Should_ReturnRightValueFromOldPrevDataAndResult() {
        CalcProcessor calcProcessor = new TestCalcProcessorImpl();
        Pair<String, String> oldPrevData = Pair.of("25", "45");
        Pair<String, String> validPrevData = Pair.of(oldPrevData.getRight(), TEST_RESULT);

        Pair<String, String> newPrevData = calcProcessor.getPrevData(oldPrevData);

        assertEquals(validPrevData, newPrevData, "Right value and result should be returned");
    }

    private static class TestCalcProcessorImpl implements CalcProcessor {
        @Override
        public void process(String input, Pair<String, String> prevData) {
            throw new UnsupportedOperationException("This method should not bee called in this test");
        }

        @Override
        public String getResult() {
            return TEST_RESULT;
        }
    }
}