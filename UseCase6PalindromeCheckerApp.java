import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class UseCase6PalindromeCheckerApp {

    public static void main(String[] args) {

        
        String original = "level";

        
        Queue<Character> queue = new LinkedList<>();

        
        Stack<Character> stack = new Stack<>();

        
        for (int i = 0; i < original.length(); i++) {
            char ch = original.charAt(i);
            queue.add(ch);   
            stack.push(ch);  
        }

        boolean isPalindrome = true;

        
        for (int i = 0; i < original.length(); i++) {

            char fromQueue = queue.remove();  
            char fromStack = stack.pop();     

            if (fromQueue != fromStack) {
                isPalindrome = false;
                break;
            }
        }

        
        if (isPalindrome) {
            System.out.println("The given string \"" + original + "\" is a Palindrome.");
        } else {
            System.out.println("The given string \"" + original + "\" is NOT a Palindrome.");
        }
    }
}