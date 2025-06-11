package map;

import inheritance.Teacher;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
//        Map<Integer , String>employee = new HashMap<>();
//
//        employee.put(01,"Anand");
//        employee.put(02, "Amar");
//        employee.put(03, "Manasi");
//        employee.put(03, "Aditya");
//
//        System.out.println("Map: " + employee);
//        System.out.println("Employee with ID 03:  " + employee.get(03));

                Map<Integer, Teacher> teacherMap = new HashMap<>();

        Teacher manasi = new Teacher();
        Teacher aditya = new Teacher();
        Teacher mita = new Teacher();

           teacherMap.put(1, manasi);
           teacherMap.put(2, aditya);
              teacherMap.put(3, mita);

                for (Map.Entry<Integer, Teacher> entry : teacherMap.entrySet()) {
                    System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue());
                }
    }
}
