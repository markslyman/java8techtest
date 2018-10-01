package demo;

import java.util.Random;


public final class ComparatorWithRandomSleep {

    /**
     * Get values to compare as input and compare them as a int numbers
     * Random time needs to compare.
     *
     * @param compareThisValue
     * @param compareValueToThis
     * @return 0 if both values are equal, 0 if compareThisValue is greater, < 0 if compareValueToThis is greater
     */
    public int compare(int compareThisValue, SpecialNumberEntity compareValueToThis) {
        Random random = new Random();
        int mSeconds = (random.nextInt(6) + 5) * 1000; //milliseconds
        int compareIntValueToThis = Integer.parseInt(compareValueToThis.getNumber());
        try {
            Thread.sleep(mSeconds);
        } catch (InterruptedException e) {
            //error
        }
        return compareThisValue - compareIntValueToThis;
    }
}
