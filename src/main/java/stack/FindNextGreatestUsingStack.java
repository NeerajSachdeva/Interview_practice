package stack;

import java.util.Stack;

/**
 * Problem Statement: Given a circular integer array A, return the next greater element for every element in A.
 * The next greater element for an element x is the first element greater than x that we come across while traversing the array in a clockwise manner.
 * If it doesn’t exist, return -1 for this element.
 * Example:
 * Input:  N = 6, A[] = {5,7,1,7,6,0}
 * Output: 7,-1,7,-1,7,5
 * <p>
 * Input: N = 11, A[] = {3,10,4,2,1,2,6,1,7,2,9}
 * Output: 10,-1,6,6,2,6,7,7,9,9,10
 *
 * Input: 5, 7, 1, 2, 6, 0
 * Output: 7 -1 2 6 7 5

 https://www.youtube.com/watch?v=Du881K7Jtk8&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=76
 */
public class FindNextGreatestUsingStack {

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int nge[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i % n]) {
                st.pop();
            }

            //since nge cannot be more than input array size so we should not even try to add at a index which is > input array size,
            // since we are running on 2*array length, that needs to be prevented, which is why i<n is important
            if (i < n) {
                nge[i] = !st.isEmpty() ? st.peek() : -1;
            }

            st.push(nums[i % n]);
        }
        return nge;
    }

    public static void main(String args[]) {
//        int arr[] = {5, 7, 1, 2, 6, 0};
//        int arr[] = {3,10,4,2,1,2,6,1,7,2,9};
        int arr[] = {4,12,5,3,1,2,5,3,1,2,4,6};

        int arr2[] = nextGreaterElements(arr);
        System.out.println("The next greater elements are ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
