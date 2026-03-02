package sort;

public class InsertionSort {
    public static void main(String args[]) {
//        int arr[] = {13, 46, 24, 52, 20, 9};
        int arr[] = { 46, 52, 24, 20,13, 9};
        int n = arr.length;
        System.out.println("Before insertion sort:");
        printArray(arr, n);
        System.out.println();
        //insertion sort
        insertionSort(arr, n);

        System.out.println("After insertion sort:");
        printArray(arr, n);
        System.out.println();


    }

    private static void insertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                //swap
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }

    private static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
