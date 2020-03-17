package Thread.Examples;

/*
    这个例子展示了为什么对set函数使用了synchronized 被操作的变量仍然要用volatile
    来修饰 因为get函数没有必要用synchronized来修饰 用volatile修饰后 值会正常显示
    但是这个例子并没有达到预期的效果 因为即使synchronized来修饰一个函数 也不能保证
    函数整体一次性执行完 在多线程的时候 synchronized修饰的函数执行到一半 也会切换到
    另一个线程
*/
public class Example2 {
    public static void main(String[] args) throws InterruptedException {
        final Data data = new Data();

        Write w = new Write(data);
        Read r = new Read(data);

        w.start();
        r.start();

        w.join();
        r.setDone();
    }

    private static class Data {
        private int count1;
        private volatile int count2;

        public Data() {
            count1 = 0;
            count2 = 0;
        }

        public synchronized void increaseCount1() {
            this.count1++;
            System.out.println("increaseCount1, value: " + this.count1);
        }

        public synchronized void increaseCount2() {
            this.count2++;
            System.out.println("increaseCount2, value: " + this.count2);
        }

        public int getCount1() {
            return count1;
        }

        public int getCount2() {
            return count2;
        }
    }


    private static class Write extends Thread {
        private Data data;

        public Write(Data data) {
            this.data = data;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                data.increaseCount1();
                data.increaseCount2();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException exception) {

                }
            }
        }
    }

    private static class Read extends Thread {
        private Data data;
        private boolean done;

        public Read(Data data) {
            this.data = data;
            this.done = false;
        }

        @Override
        public void run() {
            while (!done) {
                System.out.println("####################################");
                System.out.println("read, count1 value: " + data.getCount1());
                System.out.println("read, count2 value: " + data.getCount2());

                try {
                    Thread.sleep(200);
                } catch (InterruptedException exception) {

                }
            }
        }

        public void setDone() {
            this.done = true;
        }
    }
}
