package com.simple.calcs.poland.processor.factory;

import com.simple.calcs.poland.processor.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertSame;

class ProcessorFactoryTest {
    private ProcessorFactory processorFactory;
    private Pair<String, String> prevData;

    @BeforeEach
    void init() {
        processorFactory = new ProcessorFactory(new PrintWriter(System.out));
    }

    @Test
    @DisplayName("ProcessorFactory should return NumberProcessor instance for numbers")
    void testGetProcessor_WhenDigits_ThenReturnNumberProcessor() {
        String randomNumber = String.valueOf(Math.random());

        CalcProcessor calcProcessor = processorFactory.getProcessor(randomNumber, prevData);

        assertSame(calcProcessor.getClass(), NumberProcessor.class,
                "NumberProcessor instance should be returned for numbers");
    }

    @Test
    @DisplayName("ProcessorFactory should return SumProcessor instance for +")
    void testGetProcessor_WhenPlus_thenReturnSumProcessor() {
        String plus = "+";
        Pair<String, String> prevData = createRandomPrevData();

        CalcProcessor calcProcessor = processorFactory.getProcessor(plus, prevData);

        assertSame(calcProcessor.getClass(), SumProcessor.class,
                "SumProcessor instance should be returned for plus");
    }

    @Test
    @DisplayName("ProcessorFactory should return SubtractProcessor instance for -")
    void testGetProcessor_WhenMinus_thenReturnSubtractProcessor() {
        String minus = "-";
        Pair<String, String> prevData = createRandomPrevData();

        CalcProcessor calcProcessor = processorFactory.getProcessor(minus, prevData);

        assertSame(calcProcessor.getClass(), SubtractProcessor.class,
                "SubtractProcessor instance should be returned for minus");
    }

    @Test
    @DisplayName("ProcessorFactory should return MultiplyProcessor instance for *")
    void testGetProcessor_WhenStar_thenReturnMultiplyProcessor() {
        String star = "*";
        Pair<String, String> prevData = createRandomPrevData();

        CalcProcessor calcProcessor = processorFactory.getProcessor(star, prevData);

        assertSame(calcProcessor.getClass(), MultiplyProcessor.class,
                "MultiplyProcessor instance should be returned for star");
    }

    @Test
    @DisplayName("ProcessorFactory should return DivideProcessor instance for /")
    void testGetProcessor_WhenSlash_thenReturnDivideProcessor() {
        String slash = "/";
        Pair<String, String> prevData = createRandomPrevData();

        CalcProcessor calcProcessor = processorFactory.getProcessor(slash, prevData);

        assertSame(calcProcessor.getClass(), DivideProcessor.class,
                "DivideProcessor instance should be returned for slash");
    }

    @Test
    @DisplayName(
            "ProcessorFactory should return SameValueCalcProcessor instance for operators and non-numbers prevData")
    void testGetProcessor_WhenNonNumbersInPrevData_ThenReturnSameValueCalcProcessor() {
        String operator = "+";
        prevData = Pair.of(StringUtils.SPACE, null);

        CalcProcessor calcProcessor = processorFactory.getProcessor(operator, prevData);

        assertSame(calcProcessor.getClass(), SameValueCalcProcessor.class,
                "SameValueCalcProcessor instance should be returned for non-number prevData and operator");
    }

    @Test
    @DisplayName(
            "ProcessorFactory should return SameValueCalcProcessor instance when operator does not exists")
    void testGetProcessor_WhenOperatorDoesNotExists_ThenReturnSameValueCalcProcessor() {
        String operator = StringUtils.SPACE;
        prevData = createRandomPrevData();

        CalcProcessor calcProcessor = processorFactory.getProcessor(operator, prevData);

        assertSame(calcProcessor.getClass(), SameValueCalcProcessor.class,
                "SameValueCalcProcessor instance should be returned when operator does not exists");
    }

    private Pair<String, String> createRandomPrevData() {
        String leftRandom = String.valueOf(Math.random());
        String rightRandom = String.valueOf(Math.random());
        return Pair.of(leftRandom, rightRandom);
    }
}