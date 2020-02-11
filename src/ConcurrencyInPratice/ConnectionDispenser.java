package ConcurrencyInPratice;

import java.util.Random;

public class ConnectionDispenser {
    private ThreadLocal<Connection> connectionHolder = ThreadLocal.withInitial(() -> {
        return new Connection();
    });

    public Connection getConnection() {
        return connectionHolder.get();
    }

    public static void main(String[] args) {
        ConnectionDispenser instance = new ConnectionDispenser();
        Random random = new Random();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                Thread thd = Thread.currentThread();

                Connection connection = instance.getConnection();
                System.out.println("Thread name : " + thd.getName() + " Url hashCode : " + connection.getUrl().hashCode());
                System.out.println("Thread name : " + thd.getName() + " connection hashCode : " + connection.hashCode() + " before value : " + Connection.getUrl());
                Connection.setUrl(String.valueOf(random.nextInt(100)));
                System.out.println("Thread name : " + thd.getName() + " connection hashCode : " + connection.hashCode() + " after value : " + Connection.getUrl());
            }
        };

        for (int i = 0; i < 15; i++) {
            Thread t = new Thread(r);
            t.start();
        }
    }

    private static class Connection {
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
}
