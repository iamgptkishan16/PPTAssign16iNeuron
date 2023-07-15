/*
💡 **Question 4**

Given a Queue consisting of first **n** natural numbers (in random order). The task is to check whether the given Queue elements can be arranged in increasing order in another Queue using a stack. The operation allowed are:

1. Push and pop elements from the stack
2. Pop (Or Dequeue) from the given Queue.
3. Push (Or Enqueue) in the another Queue.

**Examples :**

Input : Queue[] = { 5, 1, 2, 3, 4 } 

Output : Yes 

Pop the first element of the given Queue 

i.e 5. Push 5 into the stack. 

Now, pop all the elements of the given Queue and push them to second Queue. 

Now, pop element 5 in the stack and push it to the second Queue.   

Input : Queue[] = { 5, 1, 2, 6, 3, 4 } 

Output : No 

Push 5 to stack. 

Pop 1, 2 from given Queue and push it to another Queue. 

Pop 6 from given Queue and push to stack. 

Pop 3, 4 from given Queue and push to second Queue. 

Now, from using any of above operation, we cannot push 5 into the second Queue because it is below the 6 in the stack.

*/

package Java_DSA.Stack.Assignment16;

import java.util.*;

public class ArrangeQueueInIncreasingOrder {
    public static void main(String[] args) {
        Queue<Integer> originalQueue = new LinkedList<>();
        originalQueue.add(3);
        originalQueue.add(1);
        originalQueue.add(2);
        originalQueue.add(4);
        
        boolean canArrange = checkArrangement(originalQueue);
        System.out.println("Can the Queue elements be arranged in increasing order? " + canArrange);
    }
    
    public static boolean checkArrangement(Queue<Integer> originalQueue) {
        Stack<Integer> stack = new Stack<>();
        int expected = 1;
        
        while (!originalQueue.isEmpty()) {
            if (originalQueue.peek() == expected) {
                originalQueue.remove();
                expected++;
            } else if (!stack.isEmpty() && stack.peek() < originalQueue.peek()) {
                return false;
            } else {
                stack.push(originalQueue.remove());
            }
        }
        
        while (!stack.isEmpty()) {
            if (stack.peek() == expected) {
                stack.pop();
                expected++;
            } else {
                return false;
            }
        }
        
        return originalQueue.isEmpty() && stack.isEmpty();
    }
}
