package arrays;// https://www.youtube.com/watch?v=w_KEocd__20
// Kadane's algorithm | Brute Better Optimal
// Find the maximum sum from a contiguous subarray

// Jab tak +ive sum ban ra hai, badte raho kyuki atleast vo minimum 1 ka to contri kar he ra hoga
public class MaximumSubarraySum {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//                    0  1   2  3   4  5  6   7  8
        System.out.println(" max: " + findMaximumSubarraySum(arr));
    }

    private static int findMaximumSubarraySum(int[] arr) {
        int max = arr[0];
        int sum = 0;
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if(sum<=0 && (sum += arr[i])>0){
                startIndex = i;
            }
            sum += arr[i];
            if (sum < 0) {
                sum = 0;
                startIndex = i;
                endIndex = i;
            } else if (max < sum) {
                max = sum;
                endIndex = i;
            }
        }
        System.out.println(" startIndex:" + startIndex + ", value: " + arr[startIndex] + "\n endIndex: " + endIndex + ",value: " + arr[endIndex]);
        return max;
    }
}
