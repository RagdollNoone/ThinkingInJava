package Thread.ThreadLocal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalSimple implements Runnable {
    private static final ThreadLocal<SimpleDateFormat> sdf = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    private String dateStr = "2018-06-22 10:00:00";

    @Override
    public void run() {
        try {
            SimpleDateFormat simpleDateFormat = sdf.get();
            System.out.println("Thread Name: " + Thread.currentThread().getName() + " simpleDateFormat address: " + simpleDateFormat.hashCode());
            Date date = simpleDateFormat.parse(dateStr);
            System.out.println("Thread Name: " + Thread.currentThread().getName() + " time: " + date);
        } catch (ParseException e) {
            System.out.println("ParseError " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
