import java.math.BigInteger;
import java.util.Date;

/**
 * Experimenting with calculating all combinatorial possibilities
 */
public class BruteForceExperiment {


    public static Double logOfBase(double base, double num) {
        return Math.log(num) / Math.log(base);
    }

    public static void main(String[] args) {

        Double Max = Math.pow(2, 50);

        System.out.println("Starting: " + new Date() + " counting to: " + Max.toString());
        Long bitLength = 1L;
        for(Long count = 1L; count < Max; count++) {
            if (Long.highestOneBit(count) > bitLength) {
                bitLength = Long.highestOneBit(count);
                System.out.println("count: " + count
                        + " bitLength: " + logOfBase(2, count ).intValue());
            }
        }
        System.out.println("Finished: " + new Date());
    }
}
