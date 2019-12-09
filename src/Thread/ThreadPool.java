package Thread;

import java.util.concurrent.*;

public class ThreadPool {
    private static class ThreadPoolHolder {
        private static ThreadPool instance = new ThreadPool();
    }

    // member
    private ThreadPoolExecutor threadPool;
    private ScheduledThreadPoolExecutor scheduledThreadPool;

    private int poolSize = 10; // 线程池中线程的最小值
    private int maxPoolSize = 20; // 线程池中线程的最大值
    private long keepAliveTime = 3; // 空闲线程等待新任务的最长等待时间
    private int schedulePoolSize = 10;


    private ThreadPool() {
        this.threadPool = new ThreadPoolExecutor(poolSize, maxPoolSize, keepAliveTime,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        this.scheduledThreadPool = new ScheduledThreadPoolExecutor(schedulePoolSize);
    }

    public static ThreadPool getInstance() {
        return ThreadPoolHolder.instance;
    }

    public ThreadPoolExecutor getThreadPool() {
        return threadPool;
    }

    public ScheduledThreadPoolExecutor getScheduledThreadPool() {
        return scheduledThreadPool;
    }


    public static void main(String[] args) {
        ThreadPoolExecutor pool1 = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        pool1.execute(() -> {
            System.out.println("Cache thread pool");
        });

        ThreadPoolExecutor pool2 = ThreadPool.getInstance().getThreadPool();
        pool2.execute(() -> {
            System.out.println("Common thread pool");

            try {
                Thread.sleep(7 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        ScheduledThreadPoolExecutor pool3 = ThreadPool.getInstance().getScheduledThreadPool();
        pool3.scheduleAtFixedRate(() -> {
            System.out.println("Schedule thread pool");
        }, 0, 5000, TimeUnit.MILLISECONDS);
    }
}
