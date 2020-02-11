package Thread.ThreadLocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalImplement extends MyThread{
    private static MyThreadLocal myThreadLocal;
//    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String dateStr = "2018-06-22 10:00:00";

    public ThreadLocalImplement(String name) {
        super(name);
//        myThreadLocal = new MyThreadLocal(this, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public void run() {
        case1();
    }

    private void case1() {

        try {
//            System.out.println("Thread Name: " + Thread.currentThread().getName() + " enter run");
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) myThreadLocal.get();
            if (null != simpleDateFormat) {
                Date date = simpleDateFormat.parse(dateStr);
                System.out.println("Thread Name: " + Thread.currentThread().getName() + " In ThreadLocalImplement case1, time: " + date);
            } else {
                System.out.println("Thread Name: " + Thread.currentThread().getName() + " In ThreadLocalImplement case1, run else, class type is " + myThreadLocal.get().getClass());
            }

        } catch (ParseException e) {
            System.out.println("ParseError " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ExceptionError " + e.getMessage());
//            e.printStackTrace();
        }
    }
}
