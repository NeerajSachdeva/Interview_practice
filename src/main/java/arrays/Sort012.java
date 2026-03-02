package arrays;

// https://www.youtube.com/watch?v=oaVa-9wmpns&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=3
// Sort 0s 1s 2s in asc
// 1 approach is count the occurence of 0's 1's 2's in 1 pass and then replace array with those
// occurence from 0->2
// 2 approach is Dutch algo using low,mid,high which is what implemented below
public class Sort012 {

  public static void main(String[] args) {
    int arr[] = {0, 1, 1, 0, 0, 2, 2};
    System.out.println(sort(arr));
  }

  private static int[] sort(int[] arr) {
    int low = 0;
    int mid = 0;
    int high = arr.length - 1;

    while (mid <= high) {
      switch (arr[mid]) {
        case 0:
          swap(arr, low, mid);
          low++;
          mid++;
          break;
        case 1:
          mid++;
          break;
        case 2:
          swap(arr, mid, high);
          high--;

      }
    }
    return arr;
  }

  private static void swap(int[] arr, int src, int dest) {
    int temp = arr[src];
    arr[src] = arr[dest];
    arr[dest] = temp;
  }

}
