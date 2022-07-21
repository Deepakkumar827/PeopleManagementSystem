package people;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;


//NavigableMap<String,Integer> map = new TreeMap<String, Integer>();
//// add some entries
//        Entry<String, Integer> lastEntry = map.lastEntry();


public class Employee extends People implements CheckInOutTracker {
        public static Hashtable<Integer, Employee> allEmployee=new Hashtable<>();

    private Hashtable<LocalDate, ArrayList<InOutTime>> inOutHistory = new Hashtable<>();

    Hashtable<LocalDate, Integer> totalTimeSpend = new Hashtable<>(); ///in minutes

    public Employee(String name, String gender, String DOB, String address) {
        super(name, gender, DOB, address);
    }


    @Override
    public boolean checkIn(LocalDateTime inTime) {

        if (inOutHistory.get(inTime.toLocalDate()) == null) {
            inOutHistory.put(inTime.toLocalDate(), new ArrayList<InOutTime>());
            inOutHistory.get(inTime.toLocalDate()).add(new InOutTime(inTime));
            return true;
        }

        ///TODO: what if user forgot to checkout in a particular day??
        InOutTime lastInOutTime = inOutHistory.get(inTime.toLocalDate()).get(inOutHistory.get(inTime.toLocalDate()).size() - 1);
        if (lastInOutTime.outTime != null) {
            inOutHistory.get(inTime.toLocalDate()).add(new InOutTime(inTime));
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean checkOut(LocalDateTime outTime) {
        if (inOutHistory.get(outTime.toLocalDate()) == null) {
            return false;
        }
        InOutTime lastInOutTime = inOutHistory.get(outTime.toLocalDate()).get(inOutHistory.get(outTime.toLocalDate()).size() - 1);

        if (lastInOutTime.outTime != null || lastInOutTime.inTime.isAfter(outTime)) {
            return false;
        } else {
            lastInOutTime.outTime = outTime;
            /*if(ChronoUnit.MINUTES.between(lastInOutTime.inTime, lastInOutTime.outTime)<=0){
                return false;
            }*/
            int last = 0;
            if (totalTimeSpend.get(outTime.toLocalDate()) != null) {
                last = totalTimeSpend.get(outTime.toLocalDate());
            }

            last += ChronoUnit.MINUTES.between(lastInOutTime.inTime, lastInOutTime.outTime);
            totalTimeSpend.put(outTime.toLocalDate(), last);
            return true;
        }
    }

    @Override
    public int getTimeSpendOnADay(LocalDateTime date) {
        return 0;
    }

    @Override
    public int getTotalTimeSpend(LocalDateTime start, LocalDateTime end) {
        return 0;
    }

    @Override
    public int getTotalTimeSpend() {
        return 0;
    }

    @Override
    public Hashtable<LocalDate, ArrayList<InOutTime>> getInOutHistory() {
        return inOutHistory;
    }
}


