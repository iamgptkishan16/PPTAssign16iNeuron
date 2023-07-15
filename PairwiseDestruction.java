/*
💡 **Question 7**

Given a sequence of n strings, the task is to check if any two similar words come together and then destroy each other then print the number of words left in the sequence after this pairwise destruction.

**Examples:**

Input : ab aa aa bcd ab

Output : 3

*As aa, aa destroys each other so,*

*ab bcd ab is the new sequence.*

Input :  tom jerry jerry tom

Output : 0

*As first both jerry will destroy each other.*

*Then sequence will be tom, tom they will also destroy*

*each other. So, the final sequence doesn’t contain any*

*word.*

*/

package Java_DSA.Stack.Assignment16;

import java.util.*;

public class PairwiseDestruction {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("hello");
        words.add("world");
        words.add("world");
        words.add("destroy");
        words.add("hello");
        
        int remainingWords = countRemainingWords(words);
        System.out.println("Number of words left after pairwise destruction: " + remainingWords);
    }
    
    public static int countRemainingWords(List<String> words) {
        Stack<String> stack = new Stack<>();
        
        for (String word : words) {
            if (!stack.isEmpty() && stack.peek().equals(word)) {
                stack.pop(); // Destroy the similar word
            } else {
                stack.push(word); // Push the word onto the stack
            }
        }
        
        return stack.size();
    }
}
