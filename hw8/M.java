import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class M {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int p = 0; p < t; p++) {
            int temp = 0;
            int n = in.nextInt();
            int[] a = new int[n];
            for (int l = 0; l < n; l++) {
                a[l] = in.nextInt();
            }
            HashMap<Integer, Integer> ans = new HashMap<>();
            ans.put(a[n - 1], 1);
            for (int j = n - 2; j >= 1; j--) {
                for (int i = 0; i <= j - 1; i++) {
                    if (ans.containsKey(2 * a[j] - a[i])) {
                        temp += (Integer) ans.get(2 * a[j] - a[i]);
                    }
                }
                if (ans.containsKey(a[j])) {
                    ans.put(a[j], (Integer) ans.get(a[j]) + 1);
                } else {
                    ans.put(a[j], 1);
                }
            }
            System.out.println(temp);
        }
        in.close();
    }
}
