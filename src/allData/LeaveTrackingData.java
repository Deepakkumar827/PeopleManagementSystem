package allData;



import leave.LeaveData;

import java.util.Hashtable;
import java.util.Queue;

public class LeaveTrackingData {
    public static Hashtable<Integer, Queue<LeaveData>> pendingRequest=new Hashtable<>();  ////key is receiver's id
    //    static Hashtable<Integer, Hashtable<Integer, LeaveData>> rejectedRequest=new Hashtable<>(); //// first key is receiver's id, and second key is sender id
//    static Hashtable<Integer, Hashtable<Integer, LeaveData>> acceptedRequest=new Hashtable<>();
    public static Hashtable<Integer, LeaveData> resolvedRequest=new Hashtable<>();
}
