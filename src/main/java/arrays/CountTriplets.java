package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://www.youtube.com/watch?v=onLoX6Nhvmg
// Find all unique triplet whose sum is 0
// or, find all triplets where sum of first two indexes are equal is 3rd index number.
public class CountTriplets {
  public static void main(String[] args) {
    int[] arr = {-1, 0, 1, 2, -1, -4};
    // output = {-1,-1,2}, {-1,0,1}

    System.out.println(approach1(arr));
    System.out.println(approach2(arr));
  }


  // T-> O(N2) & S->O(M)
  private static List<List<Integer>> approach2(int[] arr) {
    Arrays.sort(arr);
    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < arr.length - 2; i++) {
      if (i == 0 || arr[i] != arr[i - 1]) {
        int low = i + 1;
        int high = arr.length - 1;
        int sum = 0 - arr[i];

        while (low < high) {
          if (arr[low] + arr[high] == sum) {
            result.add(Arrays.asList(arr[i], arr[low], arr[high]));

            while (low < high && arr[low] == arr[low + 1]) {
              low++;
            }
            low++;

            while (low < high && arr[high] == arr[high - 1]) {
              high--;
            }
            high--;
          } else if (arr[low] + arr[high] < sum) {
            low++;
          } else {
            high--;
          }
        }
      }

    }
    return result;
  }

  private static Set<List<Integer>> approach1(int[] arr) {
    // T-> O(n3logm) n3 for loops and log m for Set insertion
    // S-> O(m) where m is number of unique triplet inserted in set.
    Set<List<Integer>> result = new HashSet<>();
    for (int i = 0; i < arr.length - 2; i++) {
      for (int j = i + 1; j < arr.length - 1; j++) {
        for (int k = j + 1; k < arr.length; k++) {
          if (arr[i] + arr[j] + arr[k] == 0) {
            List<Integer> s = new ArrayList<>();
            s.add(arr[i]);
            s.add(arr[j]);
            s.add(arr[k]);
            Collections.sort(s);
            result.add(s);
          }
        }
      }

    }
    return result;
  }
}
