package arrays;

public class MatrixZeros {
  public static void main(String[] args) {
    int arr[][] = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
    setZeroes(arr);
    System.out.println("The Final Matrix is ");
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void setZeroes(int[][] arr) {
    int rows = arr.length;
    int cols = arr[0].length;
    int col0 = 1;

    for (int i = 0; i < rows; i++) {
      if (arr[i][0] == 0) {
        col0 = 0;
      }
      for (int j = 0; j < cols; j++) {
        if (arr[i][j] == 0) {
          arr[i][0] = arr[0][j] = 0;
        }
      }
    }

    for (int i = rows - 1; i >= 0; i--) {
      for (int j = cols - 1; j >= 1; j--) {
        if (arr[i][0] == 0 || arr[0][j] == 0) {
          arr[i][j] = 0;
        }
      }
      if (col0 == 0) {
        arr[i][0] = 0;
      }
    }

  }
}
