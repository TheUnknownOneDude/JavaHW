import java.util.Scanner;

public class input {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            String ways = in.next();
            // System.out.print(ways);
            for (int j = 0; j < n; j++) {
                a[i][j] = (int) ways.charAt(j);
                System.out.println(a[i][j]);
                System.out.println((int) '0');
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j]);
            }
            System.err.println();
        }
    }
}