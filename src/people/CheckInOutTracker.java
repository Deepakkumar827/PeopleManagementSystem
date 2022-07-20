package people;

import java.sql.Time;
import java.util.Date;
import java.util.Hashtable;
import java.util.LinkedList;


class InOutTime{
    Date inTime;
    Date outTime;
    InOutTime(Date inTime){
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
    public boolean checkIn(Date inTime);
    public boolean checkOut(Date outTime);
    public boolean getTimeSpendOnADay(Date date);
    public boolean getTotalTimeSpend(Date start, Date end);
    public boolean getTotalTimeSpend();


}

