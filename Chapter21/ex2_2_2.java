package Chapter21;
import thirdparty.net.mindview.util.*;

class Fibonacci implements Generator<Integer>, Runnable {
    private static int count = 2;
    private final int id = count;
    private int index = 0;

    public Fibonacci(){
        System.out.println("id " + id + " Start!");
        count++;
    }

    public Integer next() { return fib(index++); }

    private int fib(int n) {
        if(n < 2) return 1;
        return fib(n-2) + fib(n-1);
    }

    @Override
    public void run() {
        for(int i = 0; i < id; i++)
            System.out.print(this.next() + " ");

        System.out.println();
    }
}

public class ex2_2_2 {
    public static void  main(String[] args){

        for(int i = 0; i < 5; i++) {
            new Thread(new Fibonacci()).start();
        }

        System.out.println("End!");
    }
}
