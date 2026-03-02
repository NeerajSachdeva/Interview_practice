package Pattern;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("2002"));
        System.out.println(isPalindrome("2003"));
        System.out.println(isPalindrome(2002));
    }

    private static boolean isPalindrome(String input) {
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }


    private static boolean isPalindrome(int input) {
        int reverse = 0;
        int temp = input;
        while (temp != 0) {
            reverse = (reverse * 10) + (temp % 10);
            temp = temp / 10;
        }
        return (reverse == input);
    }
}
