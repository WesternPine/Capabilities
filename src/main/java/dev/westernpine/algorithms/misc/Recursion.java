package dev.westernpine.algorithms.misc;

import java.util.Random;

public class Recursion {

    // I personally am actually no stranger to recursion.
    // There are select times when it's better to run things in a loop,
    // and other select times when it's better to run things in recursion.
    // Take the following as an example:

    // Take for instance, calculating EMA (Exponential Moving Average)
    // A *true* ema utilizes previous EMA values to generate its next value.

    /*
     * Calculating EMA is first done by finding the SMA (Simple Moving Average)
     * Then using the SMA as the first value in calculating the EMA,
     * and those EMA values to continue generating a true EMA.
     */

    public static void main() {
        int[] values = generateValues(50);

        EMA ema = new EMA(values, 5);

        double calculatedSma = ema.calculateSma(0); // This is what some will use and call their ema. This uses looping.
        double calculatedEma = ema.calculateEma(0); // This function uses the sma as the base value to generate it's ema. It's a true EMA based on recursion.

        /*
         * If we implemented looping for the EMA, we would need to also start recording the
         * previous ema value, and rearrange all of this into a for loop that constantly needs executing.
         *
         * It's possible to make an ema in a loop,
         * but generally makes more sense to do it with recursion because it's easier to understand and debug.
         */

        boolean breakpointHere = true;
        assert breakpointHere = true;

    }

    // Great use for looping.
    public static int[] generateValues(int length) {
        int[] values = new int[length];
        Random random = new Random();
        for(int i = 0; i < length; i++)
            values[i] = random.nextInt(1000);
        return values;
    }

}

class EMA {

    private final int[] values;
    private final int length;

    public EMA(int[] values, int length) {
        this.values = values;
        this.length = length;
    }

    public double calculateEma(int positionsFromEnd) {
        return ema(positionsFromEnd, length);
    }

    // Great use for recursion.
    private double ema(int positionsFromEnd, int timesLeft) {

        // base case
        if(timesLeft < 1)
            return calculateSma(positionsFromEnd+1);

        double multi = multi();
        int value = values[values.length - (positionsFromEnd + 1)];
        return value * multi + ema(positionsFromEnd+1, timesLeft-1) * (1-multi);
    }

    // Great use for looping.
    public double calculateSma(int positionsFromEnd) {
        double value = 0.0;
        for(int i = 0; i < length; i++)
            value += values[(values.length - (positionsFromEnd + 1)) - i]; // Basically add all values for the past length, before the specified position.
        return value/length;
    }

    // A value unique to the length of the ema/sma.
    // Basically indicates how strong a move from one value to the next will be.
    private double multi() {
        return 2.0/(length+1);
    }

}
