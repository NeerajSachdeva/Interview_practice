package basic;

import java.time.LocalDate;
import java.util.HashMap;

public class MapDeepCopy {

//    public static void main(String a[]){
//        HashMap<Integer, Employee> employeeMap = new HashMap<>();
//
//        employeeMap.put(1, new Employee(1l, "Alex", LocalDate.of(1990, 01, 01)));
//        employeeMap.put(2, new Employee(2l, "Bob", LocalDate.of(1990, 02, 01)));
//
////Deep clone
//        Gson gson = new Gson();
//        String jsonString = gson.toJson(employeeMap);
//
//        Type type = new TypeToken<HashMap<Integer, Employee>>(){}.getType();
//        HashMap<Integer, Employee> clonedMap = gson.fromJson(jsonString, type);
//
//        System.out.println(clonedMap);
//
////--------------------------------------
//
//        System.out.println("\nChanges DO NOT reflect in other map \n");
//
////Change a value is clonedMap
//        clonedMap.get(1).setName("Charles");
//
////Verify content of both maps
//        System.out.println(employeeMap);
//        System.out.println(clonedMap);
//    }

}
