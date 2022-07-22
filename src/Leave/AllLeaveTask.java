package leave;

import allData.AllEmployeeData;
import allData.LeaveTrackingData;
import people.Employee;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public final class AllLeaveTask {
    private static int requestIDCounter=0;

    /*
    * request status can be checked by two-way, either check status which is inside object or check in reject/accepted hashtable
    * one more way is to make some-changes in person object who is requesting*/

    static Scanner scanner=new Scanner(System.in);

    public static int requestForLeave(Employee employee, String fromDate, String toDate, String reason){

        /// return 0 for error and  any number for request id
        try {
            if(employee==null || fromDate==null || toDate==null) return 0;
            LeaveData currentData=new LeaveData(employee.getId(), employee.getDRP(), LocalDate.parse(fromDate),LocalDate.now() ,  reason);
            currentData.requestID=++requestIDCounter;
            if(LeaveTrackingData.pendingRequest.get(employee.getDRP())==null) LeaveTrackingData.pendingRequest.put(employee.getDRP(), new LinkedList<>());
            LeaveTrackingData.pendingRequest.get(employee.getDRP()).add(currentData);
            return requestIDCounter;


        }
        catch (Exception e){
            System.out.println(e.getMessage().toString());
            return 0;
        }
    }
    public static boolean manageRequest(Employee employee){
        ///////return means all request has been managed

        Queue<LeaveData> requestQueue= LeaveTrackingData.pendingRequest.get(employee.getId());
        if(requestQueue==null) {
            System.out.println("no request");
            return false;
        }
         while (requestQueue.size()!=0){
             System.out.println(requestQueue.size() + " request left");
             leave.LeaveData request=requestQueue.peek();
             if(request.toID!= employee.getId()){
                 System.out.println("some serious bug, need to be resolved");
                 return false;
             }
            System.out.println("ID: "+request.fromID + " Name: "+ AllEmployeeData.allEmployee.get(request.fromID).getName()+" from date: " + request.fromDate+ " to date: " +request.toDate+"time of sending: " + request.timeOfSending);
            System.out.println("REASON: "+ request.reason);
            System.out.println("enter 1 for approve -1 for reject and 0 for exit");
            int response=scanner.nextInt();
            if(response==-1){
                request.isApproved='F';
                LeaveTrackingData.resolvedRequest.put(request.requestID, request);
                requestQueue.remove();
            }
            else if(response==0){
                System.out.println("exit");
                return false;
            }
            else if(response==1){
                request.isApproved='T';
                LeaveTrackingData.resolvedRequest.put(request.requestID, request);
                requestQueue.remove();
            }
            else{
                System.out.println("wrong input try again later");
                return false;
            }

        }
         return true;

    }

    public static char checkStatus(int requestID){
        if(LeaveTrackingData.resolvedRequest.get(requestID)!=null){
            return LeaveTrackingData.resolvedRequest.get(requestID).isApproved;
        }
//        else if(pendingRequest.get(requestID)!=null) {
//            return '0';  /////
//        }
        else return 'x';

    }

}

