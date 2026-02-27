// Strategy Interface
interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}


// Stack-Based Strategy
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean checkPalindrome(String input) {

        input = input.toLowerCase();
        java.util.Stack<Character> stack = new java.util.Stack<>();

        // Push all characters to stack
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        // Compare with original string
        for (char ch : input.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}


// Deque-Based Strategy
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean checkPalindrome(String input) {

        input = input.toLowerCase();
        java.util.Deque<Character> deque = new java.util.ArrayDeque<>();

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
}


// Context Class
class PalindromeContext {

    private PalindromeStrategy strategy;

    // Constructor Injection
    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String input) {
        return strategy.checkPalindrome(input);
    }
}


// Main Application
public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "level";

        // Choose strategy dynamically
        PalindromeStrategy strategy = new StackStrategy();
        // Try changing to: new DequeStrategy();

        PalindromeContext context = new PalindromeContext(strategy);

        if (context.executeStrategy(input)) {
            System.out.println("The given string \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("The given string \"" + input + "\" is NOT a Palindrome.");
        }
    }
}