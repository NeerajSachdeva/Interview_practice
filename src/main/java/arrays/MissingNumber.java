package arrays;

import java.util.Arrays;

public class MissingNumber {

  public static void main(String[] args) {
    // int arr[] = {6, 1, 2, 8, 3, 4, 7, 10, 5};
    int arr[] = {1, 2, 3, 5};
    System.out.println(findSmallestMissingPositiveNumber(arr));
  }

  private static int findSmallestMissingPositiveNumber(int[] arr) {
    int missingNumber = 1;
    Arrays.sort(arr);
    for (int i = 0; i < arr.length; i++) {
      if (missingNumber == arr[i]) {
        ++missingNumber;
        continue;
      }
    }
    return missingNumber;
  }
}
