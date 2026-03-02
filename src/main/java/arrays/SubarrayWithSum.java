package arrays;// Subarray with given sum
/*
 * https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1# Given an
 * unsorted array A of size N that contains only non-negative integers, find a continuous sub-array
 * which adds to a given number S.
 *
 * In case of multiple subarrays, return the subarray which comes first on moving from left to
 * right.
 *
 * Explanation: https://www.youtube.com/watch?v=Ofl4KgFhLsM
 *
 * Example 1:
 *
 * Input: N = 5, S = 12 A[] = {1,2,3,7,5} Output: 2 4 Explanation: The sum of elements from 2nd
 * position to 4th position is 12.
 *
 * If nothing found return -1.
 */

import java.util.ArrayList;

public class SubarrayWithSum {

  public static void main(String[] args) {
    int n[] = {2, 2, 3, 7, 5};
    System.out.println(subarraySum(n, 5, 12));
  }

  // Function to find a continuous sub-array which adds up to a given number.
  static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
    int i = 0;
    int j = 0;
    long sum = 0;
    ArrayList<Integer> result = new ArrayList<>();
    while (j < n) {
      sum += arr[j++];
      while (sum > s) {
        sum -= arr[i++];
      }
      if (sum == s) {
        result.add(i + 1);
        result.add(j);
        return result;
      }

    }
    result.add(-1);
    return result;
  }
}
