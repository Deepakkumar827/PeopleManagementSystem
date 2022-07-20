package people;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Locale;


class InOutTime{
    LocalDateTime inTime;
    LocalDateTime outTime;
    InOutTime(LocalDateTime inTime){
        this.inTime=inTime;
    }
}


public interface CheckInOutTracker {
//    Hashtable<Date, LinkedList<InOutTime>> checkInOutHistory=new Hashtable<>();
//    int totalTimeSpend=0;
//    public class InOutTime{
//        Date inTime;
//        Date outTime;
//        InOutTime(Date inTime){
//            this.inTime=inTime;
//        }
//    }
    public boolean checkIn(LocalDateTime inTime);
    public boolean checkOut(LocalDateTime outTime);
    public int getTimeSpendOnADay(LocalDateTime date);
    public int getTotalTimeSpend(LocalDateTime start, LocalDateTime end);
    public int getTotalTimeSpend();
    public Hashtable<LocalDate, Integer> getTotalTimeSpendInHashTable();


}

