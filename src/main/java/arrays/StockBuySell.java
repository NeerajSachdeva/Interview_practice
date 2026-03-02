package arrays;

public class StockBuySell {

    public static void main(String[] args) {
        int[] input = {7, 2, 5, 3, 6, 1};

        int min = Integer.MAX_VALUE;
        int profit = 0;

//        int minIndex=-1;
//        int maxIndex=-1;
        for (int i = 0; i < input.length; i++) {
            if(min > input[i]) {
             min =input[i];
//             minIndex=i;
            }
            if(input[i] - min > profit) {
                profit=input[i]-min;
//                maxIndex=i;
            }
        }
        System.out.println(profit);
    }
}
