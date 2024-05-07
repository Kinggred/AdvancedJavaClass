package Secnd;

public class Secnd {
    public static void main(String[] args) {
        MathOps append = (a,b) -> a + b;
        MathOps subtract = (c,d) -> c - d;

        int calc = append.operation(42,22);
        int decalc = subtract.operation(32,22);
        System.out.println(calc);
        System.out.println(decalc);
    }

}
