import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        double b = in.nextDouble();
        double n = in.nextDouble();
        double res = 2 * (Math.ceil((n - b) / (b - a))) + 1;
        System.out.println((int) res);
        in.close();
    }
}