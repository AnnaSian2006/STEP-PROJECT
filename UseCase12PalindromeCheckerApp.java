
interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}



class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean checkPalindrome(String input) {

        input = input.toLowerCase();
        java.util.Stack<Character> stack = new java.util.Stack<>();

       
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



class PalindromeContext {

    private PalindromeStrategy strategy;

    
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



public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "level";

        
        PalindromeStrategy strategy = new StackStrategy();
        

        PalindromeContext context = new PalindromeContext(strategy);

        if (context.executeStrategy(input)) {
            System.out.println("The given string \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("The given string \"" + input + "\" is NOT a Palindrome.");
        }
    }
}
