package Test;

public class HashFunction {

    private static int M = 31;

    public static void main(String[] args) {
        String s = "Hello";
        int hashValue = hash(s);
    }

    private static int hash(String s) {
        int ret = 0;

        for (int i = 0; i < s.length(); i++) {
            ret = (31 * ret + s.charAt(i)) % M;
        }

        return ret;
    }

}
