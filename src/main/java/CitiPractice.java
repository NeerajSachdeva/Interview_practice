
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CitiPractice {

    public static int solution(int[] a) {

        List<Integer> list = Arrays.stream(a).boxed().sorted().collect(Collectors.toList());

        int result=0;

        for (int i = 0 ; i < list.size(); i++) {
            if(list.contains(result)) {
                ++result;
            }
        }

    return result;
    }

    public static void main(String[] args) {

        System.out.println(solution(new int[]{2,5,0,7,1}));
    }
}
