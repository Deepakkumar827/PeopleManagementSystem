package practice;

import java.time.LocalDateTime;
import java.util.Calendar;

public class Test {
    ////testing purpose

    public static void main(String[] args) throws InterruptedException {
        System.out.println(LocalDateTime.now().toLocalDate().toString());
        System.out.println(Calendar.getInstance().equals(Calendar.getInstance()));

        System.out.println("---------------");
        Calendar calendar=Calendar.getInstance();
        System.out.println(calendar.getTime());

        calendar.add(Calendar.DATE, 2);
        System.out.println(calendar.getTime());
        calendar.add(Calendar.DAY_OF_MONTH, 6);
        System.out.println(calendar);

    }
}
