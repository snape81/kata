public class ProjectEulerNumberOne {

    /**
     * This kata is inspired to <a
     * href="http://projecteuler.net/problem=1">Project Euler's
     * Problem #1</a>.
     * <p/>
     * If we list all the natural numbers below 10 that are multiples
     * of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
     * <p/>
     * Find the sum of all the multiples of 3 or 5 below 1000.
     *
     * @return the sum of all the multiples of 3 or 5 below 1000
     */
    public static final int THREE = 3;
    public static final int FIVE = 5;

    public int getResult() {
        int sum = 0;
        int threemultiplier = 3;
        int fivemultiplier = 5;
        int iterator = 1;
        while (threemultiplier < 1000 || fivemultiplier < 1000) {

            threemultiplier = THREE * iterator;
            if (threemultiplier < 1000) {
                sum += threemultiplier;
            }
            fivemultiplier = FIVE * iterator;
            if (fivemultiplier < 1000 && fivemultiplier % THREE != 0) {
                sum += fivemultiplier;
            }
            iterator++;

        }

        return sum;

    }


}
