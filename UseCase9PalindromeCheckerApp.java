public class UseCase9PalindromeCheckerApp {

    
    public static boolean isPalindrome(String input, int start, int end) {

        
        if (start >= end) {
            return true;
        }

        
        if (input.charAt(start) != input.charAt(end)) {
            return false;
        }

        
        return isPalindrome(input, start + 1, end - 1);
    }

    public static void main(String[] args) {

        String input = "level";

        
        input = input.toLowerCase();

        if (isPalindrome(input, 0, input.length() - 1)) {
            System.out.println("The given string \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("The given string \"" + input + "\" is NOT a Palindrome.");
        }
    }
}