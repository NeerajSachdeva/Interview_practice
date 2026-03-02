package arrays;

public class BuySellStock {
  int a = 0;

  public static void main(String[] args) {
    int a[] = {7, 3, 5, 5, 6, 1};
    maxProfit(a);
  }

  private static void maxProfit(int[] a) {
    int min = a[0];
    int profit = 0;

    for (int i = 0; i < a.length; i++) {
      if (min > a[i]) {
        min = a[i];
      }
      profit = (a[i] - min) > profit ? (a[i] - min) : profit;
    }
    System.out.println(min);
    System.out.println(profit);

  }

}
