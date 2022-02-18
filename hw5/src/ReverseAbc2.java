import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;

public class ReverseAbc2 {

    public static void main(String[] args) {
        try (MyScanner x = new MyScanner(System.in)) {
            int[] numbers = new int[1];
            int[] numsinrow = new int[1];
            int r = 0;
            int index = 0;
            while (x.hasNextLine()) {
                String temporary = x.nextLine();
                MyScanner b = new MyScanner(temporary);
                int c = 0;

                while (b.hasNextInt()) {
                    numbers[index++] = b.nextInt();
                    if (index == numbers.length) {
                        numbers = Arrays.copyOf(numbers, numbers.length * 2);
                    }
                    c++;
                }

                numsinrow[r++] = c;
                if (r == numsinrow.length) {
                    numsinrow = Arrays.copyOf(numsinrow, numsinrow.length * 2);
                }
                b.close();
            }
            index--;
            for (int i = r - 1; i >= 0; i--) {
                for (int j = numsinrow[i] - 1; j >= 0; j--) {
                    System.out.print(numbers[index--] + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Input or output error: ");
            System.out.println(e.getMessage());
        }
    }
}
