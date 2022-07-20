package people;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;


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
    Hashtable<LocalDate, ArrayList<InOutTime>> getInOutHistory();

}

