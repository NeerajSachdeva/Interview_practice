package arrays;

import java.util.ArrayList;
import java.util.List;


//@formatter:off
//
//    1
//   1 1
//  1 2 1
// 1 3 3 1
//1 4 6 4 1
//
//@formatter:on
public class PascalTriangle {
  public static void main(String[] args) {
    createPascalTriangle(5);
  }

  private static void createPascalTriangle(int rows) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> row = null;
    List<Integer> pre = null;

    for (int i = 0; i < rows; i++) {
      row = new ArrayList<>(i + 1);
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          row.add(1);
        } else {
          row.add(pre.get(j - 1) + pre.get(j));
        }
      }
      result.add(row);
      pre = row;
    }
    System.out.println(result);
  }
}

// 1
// 1 1
// 1 2 1
// 1 3 3 1
// 1 4 6 4 1
