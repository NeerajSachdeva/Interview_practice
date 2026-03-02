package arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ListComparison {

    public static void main(String[] args) {
        List<String> l1 = Arrays.asList("a", "b", "c");
        List<String> l2 = Arrays.asList("c", "b", "a");
        System.out.println(Objects.equals(l1,l2));
//        CollectionUtils.isEqualCollection(l1,l2);


        System.out.println(Math.round(.05*12));
    }
}
