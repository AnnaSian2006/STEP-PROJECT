public class UseCase10PalindromeCheckerApp {

    public static boolean isPalindrome(String input) {

        
        input = input.toLowerCase().replaceAll("\\s+", "");

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

    public static void main(String[] args) {

        String input = "Madam In Eden Im Adam";

        if (isPalindrome(input)) {
            System.out.println("The given string \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("The given string \"" + input + "\" is NOT a Palindrome.");
        }
    }
}