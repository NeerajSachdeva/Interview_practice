package arrays;

public class NextPermutation {
  public static void main(String[] args) {
    // int[] arr = {1, 4, 5, 3, 2};
    // int[] arr = {1, 3, 4, 5, 2}; // output->13524
    int[] arr = {1, 3, 5, 4, 2}; // output->14235
    System.out.println(findNextPermutation(arr));
  }

  private static int[] findNextPermutation(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return arr;
    }
    int i = arr.length - 2;
    while (i >= 0 && arr[i] >= arr[i + 1]) {
      i--;
    }
    if (i >= 0) {
      int j = arr.length - 1;
      while (arr[i] >= arr[j]) {
        j--;
      }
      swap(arr, i, j);
    }
    return reverse(arr, i + 1, arr.length - 1);
  }


  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private static int[] reverse(int[] arr, int i, int j) {
    while (i < j) {
      swap(arr, i++, j--);
    }
    return arr;
  }
}
