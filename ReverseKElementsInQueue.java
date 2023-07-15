/*
💡 **Question 6**

Given an integer k and a **[queue](https://www.geeksforgeeks.org/queue-data-structure/)** of integers, The task is to reverse the order of the first **k** elements of the queue, leaving the other elements in the same relative order.

Only following standard operations are allowed on queue.

- **enqueue(x) :** Add an item x to rear of queue
- **dequeue() :** Remove an item from front of queue
- **size() :** Returns number of elements in queue.
- **front() :** Finds front item.
*/

package Java_DSA.Stack.Assignment16;

import java.util.*;

public class ReverseKElementsInQueue {
    public static void main(String[] args) {
        int k = 3;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        
        reverseKElements(queue, k);
        
        // Print the modified queue
        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
    }
    
    public static void reverseKElements(Queue<Integer> queue, int k) {
        if (queue.isEmpty() || k <= 0 || k > queue.size()) {
            return;
        }
        
        Stack<Integer> stack = new Stack<>();
        
        // Push the first k elements onto the stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.remove());
        }
        
        // Enqueue the elements from the stack back into the queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        
        // Move the remaining elements after the reversed section
        for (int i = 0; i < queue.size() - k; i++) {
            queue.add(queue.remove());
        }
    }
}
