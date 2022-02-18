import java.io.*;
import java.util.*;

public class MyScanner implements AutoCloseable {
    private Reader input;
    private int token = 0;
    private int abctoken = 0;
    private String output = "", buffer = "";

    public MyScanner(String stream) throws IOException {
        this.input = new StringReader(stream);
    }

    public MyScanner(String stream, String charset) throws IOException {
        this.input = new StringReader(stream);
    }

    public MyScanner(InputStream stream) throws IOException {
        this.input = new InputStreamReader(stream);
    }

    public MyScanner(InputStream stream, String charset) throws IOException {
        this.input = new InputStreamReader(stream, charset);
    }

    public MyScanner(File f) throws IOException {
        this.input = new InputStreamReader(new FileInputStream(f));
    }

    public MyScanner(File in, String charset) throws IOException {
        this.input = new InputStreamReader(new FileInputStream(in), charset);
    }

    public void close() throws IOException {
        input.close();
    }

    private char[] convertion = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j' };

    public boolean hasNext() throws IOException {
        token = 0;
        IdentifyToken();
        return buffer.length() != 0;
    }

    public boolean hasNextLine() throws IOException {
        token = 3;
        IdentifyToken();
        return buffer.length() != 0;
    }

    public String nextLine() throws IOException {
        if (hasNextLine()) {
            output = buffer;
            buffer = "";
            return output;
        } else {
            throw new IOException("No Line");
        }
    }

    public boolean hasNextInt() throws IOException {
        abctoken = 1;
        if (!(hasNext())) {
            return false;
        }
        abctoken = 0;
        token = 1;
        IdentifyToken();
        try {
            int check = Integer.parseInt(buffer);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Integer nextInt() throws IOException {
        if (hasNextInt()) {
            output = buffer;
            buffer = "";
            return Integer.parseInt(output);
        } else {
            throw new IOException("No int");
        }
    }

    public boolean hasNextWord() throws IOException {
        token = 2;
        IdentifyToken();
        return buffer.length() != 0;
    }

    public String nextWord() throws IOException {
        if (hasNextWord()) {
            output = buffer;
            buffer = "";
            return output;
        } else {
            throw new IOException("No word");
        }
    }

    public void IdentifyToken() throws IOException {
        if (buffer.length() != 0) {
            return;
        }
        int c = -1;
        StringBuilder result = new StringBuilder();
        char symbol = 0;
        boolean existance = false;
        while (true) {
            c = input.read();
            if (c == -1) {
                break;
            }
            symbol = (char) c;
            if (token == 0) {
                if (Character.isWhitespace(symbol) && existance) {
                    break;
                } else {
                    if (Character.isWhitespace(symbol)) {
                        continue;
                    }
                }
                if (Character.isLetter(symbol) && abctoken == 1) {
                    for (int i = 0; i < 10; i++) {
                        if (symbol == convertion[i]) {
                            symbol = (char) (i + '0');
                        }
                    }
                }
                result.append(symbol);
                existance = true;
            }
            if (token == 1 && !(Character.isWhitespace(symbol))) {
                if (Character.isLetter(symbol)) {
                    for (int j = 0; j < 10; j++) {
                        if (symbol == convertion[j]) {
                            symbol = (char) (j + '0');
                        }
                    }
                }
                result.append(symbol);
            } else if (token == 1) {
                break;
            }

            if (token == 2 && !(Character.isWhitespace(symbol)) && (Character.isLetter(symbol) || symbol == '\''
                    || Character.getType(symbol) == Character.DASH_PUNCTUATION)) {
                result.append(symbol);
            } else if (token == 2 && result.length() == 0) {
                continue;
            } else if (token == 2) {
                break;
            }

            if (token == 3 && symbol != '\n') {
                result.append(symbol);
            } else if (token == 3) {
                break;
            }

        }
        if (result.length() == 0 && c != -1 && token == 3) {
            result.append(symbol);
        }
        buffer = result.toString();
    }

}