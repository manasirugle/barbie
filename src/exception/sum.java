package exception;

public class sum {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        try {
            int ans = a / b;
            System.out.println("Solution : "+ ans);

        } catch (ArithmeticException e) {
            System.out.println("WRONG division by 0 is not allowed");
            throw e;

        }
    }
}
