public class SumLong {

    public static void main(String args[]) {
        long sum = 0;
        for (int i = 0; i < args.length; i++) {
            String result = args[i];
            char[] num = result.toCharArray();
            String a = "";
            for (int n = 0; n < num.length; n++) {
                if (Character.isDigit(num[n]) || num[n] == '-') {
                    String b = Character.toString(num[n]);
                    a += b;
                }
                if (!(Character.isDigit(num[n])) && num[n] != '-' && num[n] != '+') {
                    if (a != "") {
                        long c = Long.parseLong(a);
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
                    long c = Long.parseLong(a);
                    sum = sum + c;
                }
            }
        }
        System.out.println(sum);
    }
}
