/*
💡 **Question 5**

Given a number , write a program to reverse this number using stack.

**Examples:**

Input : 365
Output : 563

Input : 6899
Output : 9986

*/

package Java_DSA.Stack.Assignment16;

import java.util.*;

public class ReverseNumberUsingStack {
    public static void main(String[] args) {
        int number = 12345;
        int reversedNumber = reverseNumber(number);
        System.out.println("Reversed number: " + reversedNumber);
    }
    
    public static int reverseNumber(int number) {
        Stack<Integer> stack = new Stack<>();
        
        while (number != 0) {
            int digit = number % 10;
            stack.push(digit);
            number /= 10;
        }
        
        int reversedNumber = 0;
        int multiplier = 1;
        
        while (!stack.isEmpty()) {
            int digit = stack.pop();
            reversedNumber += digit * multiplier;
            multiplier *= 10;
        }
        
        return reversedNumber;
    }
}
