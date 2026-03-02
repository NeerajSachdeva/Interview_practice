package arrays;

public class CountOccurence {
    public static void main(String[] args) {
        System.out.println(countOccur("thisisamangoterrthisismangorightthis2this22", "this"));
    }

    public static int countOccur(String s1, String s2) {
        int ans = 0;
        int len2 = s2.length();

        while (s1.contains(s2)) {
            ans++;
            int tmpInd = s1.indexOf(s2);
            System.out.println("Now Index is:" + tmpInd);
            s1 = s1.substring(tmpInd + len2, s1.length());
            System.out.println("Now s1 is:" + s1);
        }
        return ans;

    }

    public static int countOccur_old(String s1, String s2) {
        int ans = 0;
        int len1 = s1.length();
        int len2 = s2.length();
        System.out.println("Lengths:" + len1 + " " + len2);

        while (s1.contains(s2)) {
            ans++;
            int tmpInd = s1.indexOf(s2);
            System.out.println("Now Index is:" + tmpInd);
            if ((tmpInd + len2) < len1) {
                s1 = s1.substring(tmpInd + len2, s1.length());
                len1 = s1.length();
                System.out.println("Now s1 is:" + s1);
            } else {
                break;
            }
        }
        return ans;

    }
}
