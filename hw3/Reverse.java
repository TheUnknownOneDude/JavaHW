import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Reverse {

    public static void main(String args[]) {
        Scanner x = new Scanner(System.in);
        int[] numbers = new int[1];
        int[] numsinrow = new int[1];
        int c = 0;
        int r = 0;
        while (x.hasNextLine()) {
            Scanner b = new Scanner(x.nextLine());
            while (b.hasNextInt()) {
                numbers[c] = b.nextInt();
                numbers = Arrays.copyOf(numbers, numbers.length + 1);
                c++;
            }
            if (x.hasNextLine()) {
                numsinrow[r] = c;
                numsinrow = Arrays.copyOf(numsinrow, numsinrow.length + 1);
                r++;
                c = 0;
            }
            b.close();
        }
        x.close();
        for (int j = numsinrow.length - 1; j > 0; j--) {
            for (int i = numsinrow[j] - 1; i > 0; i--) {
                System.out.print(numbers[i] + " ");
                if (i == numsinrow[j] - 1 && numsinrow.length != 1) {
                    System.out.print("\n");
                }
            }
        }
    }

}
// добавить массив интов
// завест
