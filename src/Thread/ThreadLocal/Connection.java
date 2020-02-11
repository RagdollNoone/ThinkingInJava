package Thread.ThreadLocal;

public class Connection {
    private static StringBuffer url;

    private Connection() {
        url = new StringBuffer("-1");
    }

    public static void setUrl(String s) {
        if (url.length() > 0) {
            url.delete(0, url.length() - 1);
        }

        url.append(s);
    }

    public static String getUrl() {
        return url.toString();
    }
}
