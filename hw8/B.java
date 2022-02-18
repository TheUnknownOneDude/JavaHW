import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = -710 * 25000;
        double previous = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (previous < Math.sin(k + i * 710)) {
                System.out.println(k + i * 710);
                System.out.println(previous);
                System.out.println(i);
                previous = Math.sin(k + i * 710);
            } else {
                System.out.println("ne hvatilo monotonnosti");
                break;
            }
        }
    }
}