package arrays;



    // you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

    class Citibank {

        public static void main(String[] args) {
            int[] v  =new int[]{2,4,1,1,2};
            System.out.println(solution("BAABA", v));
        }
        public static int[] solution(String R, int[] V) {

            int[] result = new int[2];

            char[] charBanks = R.toCharArray();

            char transferFrom;

            int fundNeededA=0;
            int fundNeededB=0;

            int transferedByA= 0;
            int transferedByB=0;

            for(int i=0; i< charBanks.length; i++) {
                transferFrom = charBanks[i] == 'A'? 'B': 'A';

                if(transferFrom == 'A') {
                    if(fundNeededA <= V[i]) {
                        int temp = V[i] - fundNeededA;
                        fundNeededA += temp;
                        transferedByA += temp;
                    }
                    fundNeededA -= V[i];
                    fundNeededB +=V[i];
                } else {
                    if(fundNeededB <= V[i]){
                        int temp = V[i]- fundNeededB;
                        fundNeededB += temp;
                        transferedByB += temp;
                    }
                    fundNeededB -= V[i];
                    fundNeededA += V[i];
                }
            }

            System.out.println(("transferedByA" +  transferedByA));
            System.out.println("transferedByB"+ transferedByB);
            result[0]= transferedByA;
            result[1]= transferedByB;
            return result;
        }

        public static int[] solution2(String R, int[] V) {
            int[] result = new int[2];


            int fundNeededA=0;
            int fundNeededB=0;

            int transferedByA= 0;
            int transferedByB=0;

            for(int i=0; i< V.length; i++) {
                if((R.charAt(i) == 'A'? 'B': 'A') == 'A') {
                    if(fundNeededA <= V[i]) {
                        int temp = V[i] - fundNeededA;
                        fundNeededA += temp;
                        transferedByA += temp;
                    }
                    fundNeededA -= V[i];
                    fundNeededB +=V[i];
                } else {
                    if(fundNeededB <= V[i]){
                        int temp = V[i]- fundNeededB;
                        fundNeededB += temp;
                        transferedByB += temp;
                    }
                    fundNeededB -= V[i];
                    fundNeededA += V[i];
                }
            }

            System.out.println(("transferedByA" +  transferedByA));
            System.out.println("transferedByB"+ transferedByB);
            result[0]= transferedByA;
            result[1]= transferedByB;
            return result;
        }
}
