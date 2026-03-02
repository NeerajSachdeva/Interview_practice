package computations;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class OddEvenNumber {
    public static void main(String[] args) {

        long millis = System.currentTimeMillis();

        LocalDateTime dateTime = Instant.ofEpochMilli(millis)
                                        .atZone(ZoneId.systemDefault())
                                        .toLocalDateTime();


        System.out.println(isOdd(6));
        System.out.println(isOdd(5));
    }

    private static boolean isOdd(int x) {
        return (x & 1) != 0;
    }
}
