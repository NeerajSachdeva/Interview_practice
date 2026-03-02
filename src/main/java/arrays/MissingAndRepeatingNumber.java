package arrays;

public class MissingAndRepeatingNumber {

  public static void main(String[] args) {
    int arr[] = {1, 2, 3, 3};
    findSmallestMissingPositiveNumber(arr);
  }

  // T-> O(N) + O(N)
  // S-> O(N+1)
  private static void findSmallestMissingPositiveNumber(int[] arr) {
    int temp[] = new int[arr.length + 1];

    for (int i = 0; i < arr.length; i++) {
      temp[arr[i]] = temp[arr[i]] + 1;
    }

    for (int i = 0; i < temp.length; i++) {
      if (temp[i] == 0 && i != 0) {
        System.out.println("Missing Number is " + i);
      } else if (temp[i] > 1) {
        System.out.println("Repeating Number is " + i);
      }
    }

  }

}
