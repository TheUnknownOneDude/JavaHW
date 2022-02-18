import java.lang.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Wspp {

    public static void main(String[] args) {
            try (MyScanner reader = new MyScanner(new File(args[0]), "utf-8");
                 Writer out = new BufferedWriter(new OutputStreamWriter
                         (new FileOutputStream(args[1]), StandardCharsets.UTF_8))) {
                Map<String, Integer> result = new LinkedHashMap<>();
                int WordCount = 0;
                Map<String, StringBuilder> occurrences = new LinkedHashMap<>();
                StringBuilder b = new StringBuilder("");
                while (reader.hasNextWord()) {
                    String str = reader.nextWord().toLowerCase();
                    WordCount++;

                    if (result.containsKey(str)) {
                        int num = result.get(str);
                        num++;
                        result.replace(str, num);
                        occurrences.get(str).append(" " + WordCount);
                    }

                    result.putIfAbsent(str, 1);
                    occurrences.putIfAbsent(str, new StringBuilder(" " + WordCount));
                    }

            for (Map.Entry entry : result.entrySet()) {
                out.write(entry.getKey() + " " + entry.getValue() + "" + occurrences.get(entry.getKey()));
                out.write("\n");
                //System.err.println(entry.getKey() + " " + entry.getValue() + "" + occurrences.get(entry.getKey()));
                //System.err.print("\n");
            }
            // for (Map.Entry entry : result.entrySet()) {
            // out.write(entry.getKey() + " " + entry.getValue() + "\n");
            // System.err.print(entry.getKey() + " " + entry.getValue() + "\n");
            // }

        } catch (FileNotFoundException e) {
            System.out.println("File with such name is not found " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error caused by input or output  : " + e.getMessage());
        }
    }
}
