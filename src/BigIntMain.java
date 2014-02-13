import java.math.BigInteger;
import java.util.Date;

/**
 * Experimenting with calculating all combinatorial possibilities
 */
public class BigIntMain {

    public static void main(String[] args) {

        BigInteger num = new BigInteger("1");
        BigInteger Thousand = new BigInteger("1000");

        BigInteger max = new BigInteger("2").pow(50);

        System.out.println(new Date());
        int bitLength = 1;
        for(; num.compareTo(max) < 0; num = num.add(BigInteger.ONE) ) {
            num = num.add(BigInteger.ONE);
            Long value = num.longValue();
            if (num.bitLength() > bitLength) {
                bitLength = num.bitLength();
                System.out.println("value: " + value + " bitCount: " + num.bitCount() + " bitLength: " + num.bitLength());
            }
        }
        System.out.println(new Date());
    }
}
