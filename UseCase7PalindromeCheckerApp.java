import java.util.ArrayDeque;
import java.util.Deque;

public class UseCase7PalindromeCheckerApp {

    public static boolean isPalindrome(String input) {

        
        input = input.toLowerCase();

        
        Deque<Character> deque = new ArrayDeque<>();

       
        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }

        
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String input = "level";

        if (isPalindrome(input)) {
            System.out.println("The given string \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("The given string \"" + input + "\" is NOT a Palindrome.");
        }
    }
}