package com.google.zxing.oned.rss;

import com.google.zxing.NotFoundException;
import com.google.zxing.oned.OneDReader;

public abstract class AbstractRSSReader extends OneDReader {
    private static final int MAX_AVG_VARIANCE = 51;
    private static final float MAX_FINDER_PATTERN_RATIO = 0.89285713f;
    private static final int MAX_INDIVIDUAL_VARIANCE = 102;
    private static final float MIN_FINDER_PATTERN_RATIO = 0.7916667f;
    private final int[] dataCharacterCounters = new int[8];
    private final int[] decodeFinderCounters = new int[4];
    private final int[] evenCounts = new int[(this.dataCharacterCounters.length / 2)];
    private final float[] evenRoundingErrors = new float[4];
    private final int[] oddCounts = new int[(this.dataCharacterCounters.length / 2)];
    private final float[] oddRoundingErrors = new float[4];

    protected AbstractRSSReader() {
    }

    protected int[] getDecodeFinderCounters() {
        return this.decodeFinderCounters;
    }

    protected int[] getDataCharacterCounters() {
        return this.dataCharacterCounters;
    }

    protected float[] getOddRoundingErrors() {
        return this.oddRoundingErrors;
    }

    protected float[] getEvenRoundingErrors() {
        return this.evenRoundingErrors;
    }

    protected int[] getOddCounts() {
        return this.oddCounts;
    }

    protected int[] getEvenCounts() {
        return this.evenCounts;
    }

    protected static int parseFinderValue(int[] counters, int[][] finderPatterns) throws NotFoundException {
        for (int value = 0; value < finderPatterns.length; value++) {
            if (OneDReader.patternMatchVariance(counters, finderPatterns[value], 102) < 51) {
                return value;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    protected static int count(int[] array) {
        int count = 0;
        for (int a : array) {
            count += a;
        }
        return count;
    }

    protected static void increment(int[] array, float[] errors) {
        int index = 0;
        float biggestError = errors[0];
        for (int i = 1; i < array.length; i++) {
            if (errors[i] > biggestError) {
                biggestError = errors[i];
                index = i;
            }
        }
        array[index] = array[index] + 1;
    }

    protected static void decrement(int[] array, float[] errors) {
        int index = 0;
        float biggestError = errors[0];
        for (int i = 1; i < array.length; i++) {
            if (errors[i] < biggestError) {
                biggestError = errors[i];
                index = i;
            }
        }
        array[index] = array[index] - 1;
    }

    protected static boolean isFinderPattern(int[] counters) {
        int firstTwoSum = counters[0] + counters[1];
        float ratio = ((float) firstTwoSum) / ((float) ((counters[2] + firstTwoSum) + counters[3]));
        if (ratio < MIN_FINDER_PATTERN_RATIO || ratio > MAX_FINDER_PATTERN_RATIO) {
            return false;
        }
        int minCounter = Integer.MAX_VALUE;
        int maxCounter = Integer.MIN_VALUE;
        for (int counter : counters) {
            if (counter > maxCounter) {
                maxCounter = counter;
            }
            if (counter < minCounter) {
                minCounter = counter;
            }
        }
        if (maxCounter < minCounter * 10) {
            return true;
        }
        return false;
    }
}
