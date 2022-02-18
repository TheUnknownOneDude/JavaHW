import java.util.Scanner;
import java.util.Arrays;

public class Reverse {

    public static void main(String args[]) {
        Scanner x = new Scanner(System.in);
        int[] numbers = new int[1];
        int[] numsinrow = new int[1];
        int r = 0;
        int index = 0;
        while (x.hasNextLine()) {
            String temporary = x.nextLine();
            Scanner b = new Scanner(temporary);
            int c = 0;

            while (b.hasNextInt()) {
                numbers[index] = b.nextInt();
                numbers = Arrays.copyOf(numbers, numbers.length + 1);
                c++;
                index++;
            }

            numsinrow[r] = c;
            numsinrow = Arrays.copyOf(numsinrow, numsinrow.length + 1);
            r++;
        }
        index--;
        for (int i = r - 1; i >= 0; i--) {
            for (int j = numsinrow[i] - 1; j >= 0; j--) {
                System.out.print(numbers[index] + " ");
                index--;
            }
            System.out.print("\n");

        }
    }
}
