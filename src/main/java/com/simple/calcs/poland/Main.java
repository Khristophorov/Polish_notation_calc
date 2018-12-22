package com.simple.calcs.poland;

import com.simple.calcs.poland.processor.CalcProcessor;
import com.simple.calcs.poland.processor.factory.ProcessorFactory;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.io.Console;
import java.io.PrintWriter;

public class Main {
    private static final char[] EXIT_SYMBOLS = {4, 'q'};

    public static void main(String[] args) {
        Console console = System.console();
        PrintWriter writer = console.writer();
        ProcessorFactory processorFactory = new ProcessorFactory(writer);
        Pair<String, String> prevData = Pair.of(null, null);

        String input = console.readLine();
        while (!exit(input)) {
            CalcProcessor processor = processorFactory.getProcessor(input, prevData);
            processor.process(input, prevData);
            writer.println(processor.getResult());
            prevData = processor.getPrevData(prevData);
            input = console.readLine();
        }
    }

    private static boolean exit(String inputString) {
        return inputString.length() == 1 &&
                ArrayUtils.contains(EXIT_SYMBOLS, inputString.charAt(0));
    }
}
