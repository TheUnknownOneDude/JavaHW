public class Sum {

    public static void main(String args[]) {
        int sum = 0;
        for (int i = 0; i < args.length; i++) {
            String result = args[i];
            char[] num = result.toCharArray();
            String a = "";
            for (int n = 0; n < num.length; n++) {
                if (Character.isDigit(num[n]) == true || num[n] == '-') {
                    String b = Character.toString(num[n]);
                    a += b;
                }
                if (Character.isDigit(num[n]) == false && num[n] != '-') {
                    if (a != "") {
                        int c = Integer.parseInt(a);
                        sum = sum + c;
                        a = "";
                    } else {
                        continue;
                    }
                    if (Character.isWhitespace(num[n])) {
                        continue;
                    }
                }
                if ((n + 1) == num.length) {
                    int c = Integer.parseInt(a);
                    sum = sum + c;
                }
            }
        }
        System.out.println(sum);
    }
}
