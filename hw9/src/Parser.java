import java.io.*;
import java.util.*;
import java.util.List;


public class Parser implements AutoCloseable {
    private final BufferedReader reader;
    private final BufferedWriter writer;
    private List<Integer> Pair = new ArrayList<Integer>();
    private  String CurrentLine;
    private ArrayList<Integer> parsingInfo;
    int[] add = new int[]{1, 2, 2, 1, 1};
    boolean[] findElement = new boolean[5];
    int[] left = new int[]{-1, -1, -1, -1, -1};
    private final Map<Integer, String> type = Map.of(
            0, "emphasis", 1, "strikeout", 2, "strong", 3, "code" , 4 , "variable"
    );
    private final Map<Integer, String> htmlPref = Map.of(
            0, "em", 1, "s", 2, "strong", 3, "code", 4, "var"
    );
    Set<Character> emphasisChars = Set.of('*', '_');
    Set<Character> strikeoutChars = Set.of('-');
    Set<Character> specialChars = Set.of('<', '>', '&');
    Set<Character> codeChars = Set.of('`');
    List<Set<Character>> convertion = new ArrayList<Set<Character>>();

    public Parser(String in, String out, String charsetName) throws IOException {
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(in), charsetName));
        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(out), charsetName));
        parsingInfo = new ArrayList<Integer>();
        convertion.add(emphasisChars);
        convertion.add(strikeoutChars);
        convertion.add(specialChars);
        convertion.add(codeChars);
    }


    public void parse() throws IOException {
        int Lines = 0;
        while (Check()) {
            parsingInfo.add(-1);
            String converted = ParsePairs(Lines);
            writer.write(converted);
            if (converted.equals("")) writer.newLine();
            Lines++;
        }
    }


    private boolean Check() throws IOException {
        return reader.ready();
    }

    /**
     * private  boolean HeaderCheck(StringBuilder stroke) throws IOException {
     * if (stroke.length() == 0) {
     * return false;
     * }
     * if (stroke.charAt(0) == '#') {
     * return true;
     * } else {
     * return  false;
     * }
     * }
     * <p>
     * <p>
     * public int HeaderLevel(StringBuilder stroke) throws IOException{
     * <p>
     * int count = 0;
     * while (stroke.charAt(count) == '#' && count < stroke.length()) {
     * count++;
     * }
     * return count;
     * }
     * <p>
     * public String HeaderConvert(int count, StringBuilder stroke) throws IOException {
     * <p>
     * if (count > 0 && count < stroke.length() && Character.isWhitespace(stroke.charAt(count))) {
     * stroke.delete(0, count + 1);
     * }
     * return stroke.toString();
     * }
     **/

    private boolean Header(int Lines) {
        return parsingInfo.get(Lines).equals(-1);
    }

    private  boolean Markable(int index) {
        return getType(index) != -1;
    }

    private  boolean TypeCheck(int index, int type) {
        return (convertion.get(type).contains(CurrentLine.charAt(index)) && ((type == 0)  &&
                ((index + 1 < CurrentLine.length() && !convertion.get(type).contains(CurrentLine.charAt(index + 1))) || (index + 1 >= CurrentLine.length()))
                || (0 < type && type < 3) && (index + 1 < CurrentLine.length() && convertion.get(type).contains(CurrentLine.charAt(index + 1)))
                || (type > 2) && (convertion.get(type)).contains(CurrentLine.charAt(index))));
    }


    private int getType(int index) {
        for (int i = 0; i < convertion.size(); i++) {
            if (TypeCheck(index,i)) {
                return  index;
            }
        }
        return  -1;
    }

    private boolean typeElementCompare(int index, int pos) {
        return CurrentLine.charAt(left[pos]) == CurrentLine.charAt(index);
    }



    public String ReadAll(int Lines) throws IOException {
        StringBuilder output = new StringBuilder();
        int LineAmount = 0;

        while (Check()) {
            StringBuilder line = new StringBuilder(reader.readLine());

            if (line.length() == 0) break;

            int count = 0;

            if (LineAmount == 0 && line.charAt(0) == '#') {
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) != '#') break;
                    count++;
                }
            }
            if (count > 0 && count < line.length() && Character.isWhitespace(line.charAt(count))) {
                line.delete(0, count + 1);
                parsingInfo.set(Lines, count);
            }
            output.append(line);
            output.append("\n");
            LineAmount++;
        }
        if (output.length() > 0 && output.charAt(output.length() - 1) == '\n')
            output.delete(output.length()-1, output.length());
        return  output.toString();
     }


    public String ParsePairs(int Lines) throws IOException{
            String stroke = ReadAll(Lines);
            if (stroke.equals("")) return "";
            StringBuilder output = new StringBuilder();
            if (Header(Lines)) {
                output.append("<h");
                output.append(parsingInfo.get(Lines).toString());
                output.append(">");
            } else {
                output.append("<p>");
            }
            CurrentLine = output.toString();
            output.append(ParseText(0));
            if (Header(Lines)) {
                output.append("</h");
                output.append(parsingInfo.get(Lines).toString());
                output.append(">");
            } else {
                output.append("</p>");
            }
            return output.toString();
    }

    public String ParseText(int a) throws IOException {
    StringBuilder output = new StringBuilder();
    for (int i = 0; i < output.length(); i++) {
        int last = i;
        if (CurrentLine.charAt(i) == '\\' && i < CurrentLine.length() && Markable(i + 1)) { // shielding
            output.append(CurrentLine.charAt(i + 1));
            i++;
            continue;
        }
        int type = getType(i);
        if (Markable(i)) {
            if (left[i] != -1 && typeElementCompare(i, type)) {
                StringBuilder pref = new StringBuilder("<");
                pref.append(htmlPref.get(type));
                pref.append(">");
                output.insert(0, pref);
                pref.insert(1, '/');
                output.append(pref);
                findElement[type] = true;
                return  output.toString();
            } else {
                left[type] = i;
                StringBuilder pref = new StringBuilder(ParseText(i + add[type]));
                if (findElement[type]) {
                    findElement[type] = false;
                    left[type] = -1;
                } else  {
                    output.append(CurrentLine.charAt(i));
                }
                output.append(pref);
                i = last + 1;
                if (type == 3 || type == 0) i--;

            }
        }   else {
            output.append(CurrentLine.charAt(i));
            }
        }
        return  output.toString();
    }

    @Override
    public void close() throws IOException {
        reader.close();
        writer.close();
    }
}


