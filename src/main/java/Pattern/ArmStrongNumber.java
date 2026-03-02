package Pattern;

/**
 * https://www.geeksforgeeks.org/program-for-armstrong-numbers/
 *
 * e.g. 153 is an Armstrong number.
 *      1*1*1 + 5*5*5 + 3*3*3 = 153
 *
 *      1253 is not a Armstrong Number
 *      1*1*1*1 + 2*2*2*2 + 5*5*5*5 + 3*3*3*3 = 723
 */
public class ArmStrongNumber {

    public static void main(String[] args) {
        System.out.println(isArmStrong(153));
        System.out.println(isArmStrong2(153));
        System.out.println(isArmStrong(1200));
        System.out.println(isArmStrong2(1200));
        System.out.println(isArmStrong(1634));
        System.out.println(isArmStrong2(1634));
    }

    private static boolean isArmStrong(int input) {
        int power = order(input);

        int sum=0;
        int temp=input;
        for(int i=0;i<power;i++) {
            //pick last digit
            int remainder = temp % 10;
            sum += Math.pow(remainder, power);
            temp = temp/10;
        }

        return sum==input;
    }

    private static int order(int input) {
        int n = 0;
        while(input != 0) {
        input = input/10;
        ++n;
        }
        return n;
    }

    //Approach2
    private static boolean isArmStrong2(int input) {
        int temp=input;
        int power =String.valueOf(input).toCharArray().length;
        int sum=0;
        while(temp != 0) {
            //pick last digit
            int remainder = temp % 10;
            sum += Math.pow(remainder, power);
            temp = temp/10;
        }

        return sum==input;
    }

}
