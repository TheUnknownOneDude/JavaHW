import java.util.Scanner;

public class J {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] ways = new int[n][n];
        for (int i = 0; i < n; i++) {
            String hill = in.next();
            for (int j = 0; j < n; j++) {
                // System.out.print((int) '0');
                ways[i][j] = (int) hill.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ways[i][j] != 0) {
                    for (int k = 0; k < n; k++) {
                        ways[i][k] = (ways[i][k] - ways[j][k] + 10) % 10;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ways[i][j]);
            }
            System.out.println();
        }
    }
}
