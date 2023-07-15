/*
💡 **Question 2**

Given a stack of integers, sort it in ascending order using another temporary stack.

**Examples:**
Input : [34, 3, 31, 98, 92, 23]
Output : [3, 23, 31, 34, 92, 98]

Input : [3, 5, 1, 4, 2, 8]
Output : [1, 2, 3, 4, 5, 8]

*/

package Java_DSA.Stack.Assignment16;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(3);
        stack.push(8);
        stack.push(1);
        stack.push(4);
        
        Stack<Integer> sortedStack = sort(stack);
        
        // Print the sorted stack
        while (!sortedStack.isEmpty()) {
            System.out.print(sortedStack.pop() + " ");
        }
    }
    
    public static Stack<Integer> sort(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            
            while (!tempStack.isEmpty() && tempStack.peek() > temp) {
                stack.push(tempStack.pop());
            }
            
            tempStack.push(temp);
        }
        
        return tempStack;
    }
}
