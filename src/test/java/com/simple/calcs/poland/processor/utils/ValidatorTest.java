package com.simple.calcs.poland.processor.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidatorTest {
    @Test
    @DisplayName("isPrevDataForOperation should return true only when all prevData contains numbers")
    void testIsPrevDataForOperation_ShouldReturnTrue_OnlyWhenPrevDataIsNumbers() {
        String randomLeft = String.valueOf(Math.random());
        String randomRight = String.valueOf(Math.random());

        assertTrue(Validator.isPrevDataForOperation(Pair.of(randomLeft, randomRight)),
                "isPrevDataForOperation should return true for numbers");
        assertFalse(Validator.isPrevDataForOperation(Pair.of(null, StringUtils.SPACE)),
                "isPrevDataForOperation should return false for non-numbers");
    }
}