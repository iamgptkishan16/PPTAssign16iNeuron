/*
💡 **Question 3**

Given a stack with **push()**, **pop()**, and **empty()** operations, The task is to delete the **middle** element ****of it without using any additional data structure.

Input  : Stack[] = [1, 2, 3, 4, 5]

Output : Stack[] = [1, 2, 4, 5]

Input  : Stack[] = [1, 2, 3, 4, 5, 6]

Output : Stack[] = [1, 2, 4, 5, 6]

*/

package Java_DSA.Stack.Assignment16;
import java.util.Stack;

public class DeleteMiddleElementStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(3);
        stack.push(8);
        stack.push(1);
        stack.push(4);
        
        deleteMiddleElement(stack);
        
        // Print the modified stack
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
    
    public static void deleteMiddleElement(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        
        int middle = stack.size() / 2 + 1;
        
        deleteMiddleUtil(stack, middle);
    }
    
    private static void deleteMiddleUtil(Stack<Integer> stack, int middle) {
        if (middle == 1) {
            stack.pop();
            return;
        }
        
        int temp = stack.pop();
        
        deleteMiddleUtil(stack, middle - 1);
        
        stack.push(temp);
    }
}
