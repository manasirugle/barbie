package list;

import inheritance.Teacher;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List<String> birds = new ArrayList<>();

        birds.add("peacock");
        birds.add("dove");
        birds.add("flamingo");
        birds.add("dove");

        System.out.println("List : " + birds);
        System.out.println("first element :" + birds.get(0));

        List<Teacher> teachers = new ArrayList<>();

        Teacher manasi = new Teacher();
        Teacher aditya = new Teacher();
        Teacher mita = new Teacher();

        teachers.add(manasi);
        teachers.add(aditya);
        teachers.add(mita);

        for (Teacher teacher : teachers) {
            System.out.println(teacher.toString());
        }

    }
}
