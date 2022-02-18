import java.io.IOException;

public class Md2Html {
    public  static  void main(String[] args) {
        try (Parser SexualArousment = new Parser("in.txt", "out.txt", "UTF-8")) {
            SexualArousment.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

