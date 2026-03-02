package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Program to find the longest subarray which has some 0.............
 * https://www.youtube.com/watch?v=xmguZ6GbatA ....................... .. .. ...... ........... ...
 * T-> O(nLogN) S-> O(N)
 *
 */
public class LargestArraySumZero {

  public static void main(String[] args) {

    int[] arr = {1, -1, 3, 2, -2, -8, 1, 7, 10, 23};

    // int[] arr = {1, -1, 3};
    System.out.println(findLargestSum(arr));
  }

  private static int findLargestSum(int arr[]) {
    int maxArraysize = 0;
    int sum = 0;
    // Key is sum and value is index till which that sum is calculated
    Map<Integer, Integer> sumIndexMap = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      // "sum" me 0th index se value add honi shuru hui and then vo sum he last me zero bana, to matlab
      // ith position tak 1 array mili jiska sum zero hai.
      // bcoz i 0 se shuru hua to resultant size i+1 hoga
      if (sum == 0) {
        maxArraysize = i + 1;
      } else {
        if (sumIndexMap.get(sum) != null) {
          maxArraysize = Math.max(maxArraysize, i - sumIndexMap.get(sum));
        } else {
          sumIndexMap.put(sum, i);
        }
      }
    }
    return maxArraysize;
  }

}
