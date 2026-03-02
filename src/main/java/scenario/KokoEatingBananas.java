package scenario;

/**
 * Problem
 * <p>
 * Given:
 * <p>
 * piles[i] = number of bananas in each pile
 * <p>
 * h = hours available
 * <p>
 * Koko can eat k bananas per hour FROM ONE PILE ONLY.
 * <p>
 * Goal: Find the minimum integer k such that Koko can finish all bananas within h hours.
 */

/**
 * minSpeed = 1
 * maxSpeed = max(piles) = m
 *
 * range size = m
 * number of steps = O(log m)
 *
 * range size = m
 * number of steps = O(log m)
 *
 * for (int pile : piles)
 *     hours += ceil(pile / speed)   --> O(n)
 *
 *  O(n * log m)
 *
 *  If an interviewer asks why O(n log m) instead of O(n log n), you can explain:
 *
 * “We are not binary searching piles; we are binary searching the possible eating speed from 1 to max(pile), so the log factor is log(maxPile), not log(n).”
 */
public class KokoEatingBananas {

    /**
     * Finds the minimum eating speed required for Koko
     * to finish all banana piles within h hours.
     *
     * @param piles array representing banana piles
     * @param h     total hours available
     * @return minimum eating speed k
     */
    public static int minEatingSpeed(int[] piles, int h) {

//        left  → minPossibleSpeed
//        right → maxPossibleSpeed
//        mid   → candidateSpeed

        int left = 1;
        int right = 0;

        // find max pile
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int result = right;

        while (left <= right) {
//            When asked “why mid = left + (right-left)/2?” you can say:
//“It’s equivalent to (left + right)/2 but prevents integer overflow when left and right are large. e.g. left = 2_000_000_000, right = 2_000_000_001”
            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                result = mid;
                right = mid - 1; // try smaller speed
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    /**
     * Checks whether Koko can finish all piles with given speed.
     *
     * @param piles banana piles
     * @param h     hours available
     * @param speed eating speed
     * @return true if possible within h hours
     */
    private static boolean canFinish(int[] piles, int h, int speed) {
        long hours = 0;

        for (int pile : piles) {
//            hours += (pile + speed - 1) / speed; // ceil division
            hours += (int)Math.ceil((float)pile  / speed);
        }

        return hours <= h;
    }

    /**
     * Main method to test the program.
     */
    public static void main(String[] args) {

        int[] piles = {3, 6, 7, 11}; //27
        int h = 8;

        int result = minEatingSpeed(piles, h);

        System.out.println("Minimum eating speed: " + result);
    }
}