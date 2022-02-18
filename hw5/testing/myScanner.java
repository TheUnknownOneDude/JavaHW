import java.io.*;
import java.util.*;

public class myScanner implements AutoCloseable {
    private Reader input;
    private int token = 0;
    private String output = "", buffer = "";

    public myScanner(String stream) throws IOException {
        this.input = new StringReader(stream);
    }

    public myScanner(String stream, String charset) throws IOException {
        this.input = new StringReader(stream);
    }

    public myScanner(InputStream stream) throws IOException {
        this.input = new InputStreamReader(stream);
    }

    public myScanner(InputStream stream, String charset) throws IOException {
        this.input = new InputStreamReader(stream, charset);
    }

    public myScanner(File f) throws IOException {
        this.input = new InputStreamReader(new FileInputStream(f));
    }

    public myScanner(File in, String charset) throws IOException {
        this.input = new InputStreamReader(new FileInputStream(in), charset);
    }

    public void close() throws IOException {
        input.close();
    }

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
        if (!(hasNext())) {
            return false;
        }
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
        if (!(hasNext())) {
            return false;
        }
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
                result.append(symbol);
                existance = true;
            }
            if (token == 1 && !(Character.isWhitespace(symbol))) {
                result.append(symbol);
            } else if (token == 1) {
                break;
            }

            if (token == 2 && !(Character.isWhitespace(symbol)) && (Character.isLetter(symbol) || symbol == '\''
                    || Character.getType(symbol) == Character.DASH_PUNCTUATION)) {
                result.append(symbol);
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