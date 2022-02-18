import java.lang.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class WordStatWords {

    public static void main(String[] args) {
        try (MyScanner reader = new MyScanner(new File(args[0]), "utf-8");
             Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), StandardCharsets.UTF_8))) {
            Map<String, Integer> result = new LinkedHashMap<>();
            while (reader.hasNextWord()) {
                String str = reader.nextWord().toLowerCase();
                if (result.containsKey(str)) {
                    int num = result.get(str);
                    num++;
                    result.replace(str, num);
                }
                result.putIfAbsent(str, 1);
            }

                Map<String, Object> treeMap = new TreeMap<String, Object>(result);
                for (Map.Entry entrysort : treeMap.entrySet()) {
                    // System.err.print(entrysort.getKey() + " " + entrysort.getValue() + "\n");
                    out.write(entrysort.getKey() + " " + entrysort.getValue() + "\n");
                }
                // for (Map.Entry entry : result.entrySet()) {
                // out.write(entry.getKey() + " " + entry.getValue() + "\n");
                // System.err.print(entry.getKey() + " " + entry.getValue() + "\n");
                // }
            } catch(FileNotFoundException e){
                System.out.println("File with such name is not found" + e.getMessage());
            } catch(IOException e){
                System.out.println("Error caused by input or output  : " + e.getMessage());
            }
        }
    }
