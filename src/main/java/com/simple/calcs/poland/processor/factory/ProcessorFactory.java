package com.simple.calcs.poland.processor.factory;

import com.simple.calcs.poland.processor.*;
import com.simple.calcs.poland.processor.utils.Validator;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.io.PrintWriter;

/**
 * Provides mechanism of creation needed CalcProcessors regarding input data.
 */
public class ProcessorFactory {
    private PrintWriter writer;

    /**
     * General constructor on {@link ProcessorFactory}
     *
     * @param writer writer for output data. Can be used for CalcProcessor creation
     */
    public ProcessorFactory(PrintWriter writer) {
        this.writer = writer;
    }

    /**
     * Generates {@link CalcProcessor} according input data.
     *
     * @param input input data for calculation
     * @return appropriate {@link CalcProcessor} for input data processing
     */
    public CalcProcessor getProcessor(String input, Pair<String, String> prevData) {
        if (NumberUtils.isParsable(input)) {
            return new NumberProcessor();
        }
        if (!Validator.isPrevDataForOperation(prevData)) {
            writer.printf("%s is not allowed here. " +
                    "Only numbers are allowed for operation. Please, input 2 numbers\n", input);
            return new SameValueCalcProcessor();
        }
        switch (input) {
            case "+":
                return new SumProcessor();
            case "-":
                return new SubtractProcessor();
            case "*":
                return new MultiplyProcessor();
            case "/":
                return new DivideProcessor();
            default:
                writer.printf("%s is not applicable data for calculator\n", input);
                return new SameValueCalcProcessor();
        }
    }
}
