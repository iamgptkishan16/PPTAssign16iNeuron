/*
💡 **Question 8**

Given an array of integers, the task is to find the maximum absolute difference between the nearest left and the right smaller element of every element in the array.

**Note:** If there is no smaller element on right side or left side of any element then we take zero as the smaller element. For example for the leftmost element, the nearest smaller element on the left side is considered as 0. Similarly, for rightmost elements, the smaller element on the right side is considered as 0.

**Examples:**
Input : arr[] = {2, 1, 8}
Output : 1
Left smaller  LS[] {0, 0, 1}
Right smaller RS[] {1, 0, 0}
Maximum Diff of abs(LS[i] - RS[i]) = 1

Input  : arr[] = {2, 4, 8, 7, 7, 9, 3}
Output : 4
Left smaller   LS[] = {0, 2, 4, 4, 4, 7, 2}
Right smaller  RS[] = {0, 3, 7, 3, 3, 3, 0}
Maximum Diff of abs(LS[i] - RS[i]) = 7 - 3 = 4

Input : arr[] = {5, 1, 9, 2, 5, 1, 7}
Output : 1

*/

package Java_DSA.Stack.Assignment16;

import java.util.*;

public class MaxAbsoluteDifference {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 5, 6, 3};
        
        int maxDifference = findMaxAbsoluteDifference(arr);
        System.out.println("Maximum absolute difference: " + maxDifference);
    }
    
    public static int findMaxAbsoluteDifference(int[] arr) {
        int n = arr.length;
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];
        
        // Find the nearest left smaller element for each element in the array
        findNearestLeftSmaller(arr, leftSmaller);
        
        // Find the nearest right smaller element for each element in the array
        findNearestRightSmaller(arr, rightSmaller);
        
        int maxDifference = Integer.MIN_VALUE;
        
        // Calculate the maximum absolute difference
        for (int i = 0; i < n; i++) {
            int difference = Math.abs(leftSmaller[i] - rightSmaller[i]);
            maxDifference = Math.max(maxDifference, difference);
        }
        
        return maxDifference;
    }
    
    private static void findNearestLeftSmaller(int[] arr, int[] leftSmaller) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                leftSmaller[i] = Integer.MIN_VALUE;
            } else {
                leftSmaller[i] = stack.peek();
            }
            
            stack.push(arr[i]);
        }
    }
    
    private static void findNearestRightSmaller(int[] arr, int[] rightSmaller) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                rightSmaller[i] = Integer.MIN_VALUE;
            } else {
                rightSmaller[i] = stack.peek();
            }
            
            stack.push(arr[i]);
        }
    }
}
