package com.simple.calcs.poland.processor.utils;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.tuple.Pair;

public class Validator {
    public static boolean isPrevDataForOperation(Pair<String, String> prevData) {
        boolean validRight = NumberUtils.isParsable(prevData.getRight());
        boolean validLeft = NumberUtils.isParsable(prevData.getLeft());
        return validLeft && validRight;
    }
}
