package Chapter21;

class basic implements Runnable{
    private static int count = 0;
    private final int basicId = count;

    public basic() {
        System.out.println("basicId " + basicId + " Start!");
        count++;
    }

    @Override
    public void run() {
        for(int i = 0; i < 3; i++) {
            System.out.println("basicId value is " + basicId);
            Thread.yield();
        }
    }
}

public class ex2_2_1 {
    public static void  main(String[] args){

        for(int i = 0; i < 5; i++) {
            new Thread(new basic()).start();
        }

        System.out.println("End!");
    }
}
