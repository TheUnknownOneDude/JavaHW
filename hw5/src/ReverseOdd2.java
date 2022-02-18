import java.util.*;
import java.io.*;

public class ReverseOdd2 {

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
                    if (index == numbers.length) {
                        numbers = Arrays.copyOf(numbers, numbers.length * 2);
                    }
                    numbers[index] = b.nextInt();
                    c++;
                    index++;
                }

                    if (r == numsinrow.length) {
                        numsinrow = Arrays.copyOf(numsinrow, numsinrow.length * 2);
                    }
                    numsinrow[r] = c;
                    r++;
            }
            index--;
            for (int i = r - 1; i >= 0; i--) {
                for (int j = numsinrow[i] - 1; j >= 0; j--) {
                    if ((i + j) % 2 == 1) {
                        System.out.print(numbers[index] + " ");
                    }
                    index--;
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File with such name is not found" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error caused by input or output  : " + e.getMessage());
        }
    }
}
