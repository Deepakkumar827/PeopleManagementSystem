package people;

import java.util.Date;
import java.util.Hashtable;
import java.util.LinkedList;

public class Employee extends People implements CheckInOutTracker {
    Hashtable<Date, LinkedList<InOutTime>> checkInOutHistory=new Hashtable<>();
    int totalTimeSpend=0;

    public Employee(String name, String gender, String DOB, String address) {
        super(name, gender, DOB, address);
    }




    @Override
    public boolean checkIn(Date inTime) {
        return false;
    }

    @Override
    public boolean checkOut(Date outTime) {
        return false;
    }

    @Override
    public boolean getTimeSpendOnADay(Date date) {
        return false;
    }

    @Override
    public boolean getTotalTimeSpend(Date start, Date end) {
        return false;
    }

    @Override
    public boolean getTotalTimeSpend() {
        return false;
    }
}
