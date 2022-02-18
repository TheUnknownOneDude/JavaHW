import java.lang.*;
import java.io.*;
import java.util.*;

public class WsppPosition {

    public static void main(String args[]) {
        try (MyScanner reader = new MyScanner(new File(args[0]), "utf-8");
                Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), "utf-8"))) {
            Map<String, Integer> result = new LinkedHashMap<>();
            Map<String, StringBuilder> occurrences = new LinkedHashMap<>();
            StringBuilder defauBuilder = new StringBuilder("");
            int countL = 0;
            while (reader.hasNextLine()) {
                MyScanner line = new MyScanner(reader.nextLine());
                int index = 0;
                countL++;
                while (line.hasNextWord()) {
                    String str = line.nextWord().toLowerCase();
                    int occur = result.getOrDefault(str, 0);
                    index++;
                    result.put(str, occur + 1);
                    StringBuilder pos = new StringBuilder(occurrences.getOrDefault(str, defauBuilder));
                    pos.append(" " + countL + ":" + index);
                    occurrences.put(str, pos);
                }
            }
            for (Map.Entry entry : result.entrySet()) {
                out.write(entry.getKey() + " " + entry.getValue() + occurrences.get(entry.getKey()));
                out.write("\n");
                // System.err.print(entry.getKey() + " " + entry.getValue() +
                // occurrences.get(entry.getKey()));
                // System.err.print("\n");
            }
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("File with such name is not found" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error caused by input or output  : " + e.getMessage());
        }
    }
}
