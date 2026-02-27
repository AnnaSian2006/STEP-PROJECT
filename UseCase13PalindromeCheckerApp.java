import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class UseCase13PalindromeCheckerApp {

    
    public static boolean twoPointerCheck(String input) {
        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    
    public static boolean stackCheck(String input) {
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : input.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static boolean dequeCheck(String input) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String input = "levellevellevellevellevel"; // longer string for better timing
        input = input.toLowerCase();

        
        long startTime1 = System.nanoTime();
        boolean result1 = twoPointerCheck(input);
        long endTime1 = System.nanoTime();

        
        long startTime2 = System.nanoTime();
        boolean result2 = stackCheck(input);
        long endTime2 = System.nanoTime();

        
        long startTime3 = System.nanoTime();
        boolean result3 = dequeCheck(input);
        long endTime3 = System.nanoTime();

        System.out.println("Palindrome Check Results:");
        System.out.println("---------------------------------");
        System.out.println("Two Pointer Result: " + result1 +
                " | Time: " + (endTime1 - startTime1) + " ns");

        System.out.println("Stack Result: " + result2 +
                " | Time: " + (endTime2 - startTime2) + " ns");

        System.out.println("Deque Result: " + result3 +
                " | Time: " + (endTime3 - startTime3) + " ns");
    }
}