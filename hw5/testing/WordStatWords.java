import java.lang.*;
import java.io.*;
import java.util.*;

public class WordStatWords {

    public static void main(String args[]) {
        try (myScanner reader = new myScanner(new File(args[0]), "utf-8");
                Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), "utf-8"))) {
            Map<String, Integer> result = new LinkedHashMap<>();
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line == null) {
                    break;
                }
                StringBuilder b = new StringBuilder("");
                for (int k = 0; k < line.length(); k++) {
                    if (Character.isLetter(line.charAt(k)) || line.charAt(k) == '\''
                            || Character.getType(line.charAt(k)) == Character.DASH_PUNCTUATION) {
                        b.append(line.charAt(k));
                        if (k == line.length() - 1 && !(Character.isWhitespace(line.charAt(k)))) {
                            String str = b.toString().toLowerCase();
                            if (result.containsKey(str)) {
                                int num = result.get(str);
                                num++;
                                result.replace(str, num);
                            }
                            result.putIfAbsent(str, 1);
                            b.setLength(0);
                        }
                    } else if (b.length() != 0) {
                        String str = b.toString().toLowerCase();
                        if (result.containsKey(str)) {
                            int num = result.get(str);
                            num++;
                            result.replace(str, num);
                        }
                        result.putIfAbsent(str, 1);
                        b.setLength(0);
                    }
                }
            }

            Map<String, Object> treeMap = new TreeMap<String, Object>(result);
            for (Map.Entry entrysort : treeMap.entrySet()) {
                System.err.print(entrysort.getKey() + " " + entrysort.getValue() + "\n");
                out.write(entrysort.getKey() + " " + entrysort.getValue() + "\n");
            }
            out.close();
            // for (Map.Entry entry : result.entrySet()) {
            // out.write(entry.getKey() + " " + entry.getValue() + "\n");
            // System.err.print(entry.getKey() + " " + entry.getValue() + "\n");
            // }
        } catch (FileNotFoundException e) {
            System.out.println("File with such name is not found" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error caused by input or output  : " + e.getMessage());
        }
    }
}
