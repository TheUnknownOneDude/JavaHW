import java.util.Scanner;

public class I {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][3];
        int xl = Integer.MAX_VALUE;
        int xr = Integer.MIN_VALUE;
        int yl = Integer.MAX_VALUE;
        int yr = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = in.nextInt();
            }
            if (xl > (a[i][0] - a[i][2])) {
                xl = a[i][0] - a[i][2];
            }
            if (xr < (a[i][0] + a[i][2])) {
                xr = a[i][0] + a[i][2];
            }
            if (yl > (a[i][1] - a[i][2])) {
                yl = a[i][1] - a[i][2];
            }
            if (yr < (a[i][1] + a[i][2])) {
                yr = a[i][1] + a[i][2];
            }
        }
        int h = (Math.max(xr - xl, yr - yl) + 1) / 2;
        int x = (xr + xl) / 2;
        int y = (yr + yl) / 2;
        System.out.print(x + " " + y + " " + h);
    }
}