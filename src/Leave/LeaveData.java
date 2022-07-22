package leave;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LeaveData {
    int requestID;
    int fromID;
    int toID;
    LocalDate fromDate;
    LocalDate toDate;
    LocalDateTime timeOfSending;
    String reason;
    char isApproved='0'; ///T for yes and F for not

    public LeaveData(int fromID, int toID, LocalDate fromDate, LocalDate toDate, String reason) {
        this.fromID = fromID;
        this.toID = toID;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.timeOfSending = LocalDateTime.now();
        this.reason = reason;
    }
}
