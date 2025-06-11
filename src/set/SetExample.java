package set;

import java.util.Set;
import java.util.HashSet;

public class SetExample {
    public static void main(String[] args) {
        Set<String> animals = new HashSet<>();

        animals.add("lion");
        animals.add("tiger");
        animals.add("elephant");
        animals.add("lion");

        System.out.println("Set: " + animals );
    }
}
