import java.io.*;
import java.util.*;

public class testhuini {
    public static void main(String[] args) {
        String stry = "1 2 3 4 5";
        try (myScanner in = new myScanner(stry)) {
            for (int i = 0; i < stry.length(); i++) {
                int str = in.nextInt();
                System.out.println(str);
            }
        } catch (IOException e) {
            System.out.println("I/O error: ");
            System.out.println(e.getMessage());
        }
    }
}