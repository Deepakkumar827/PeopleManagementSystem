package controller;

import people.*;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public final class Util {
    public static String[] getPeopleDetails(){
        Scanner scanner=new Scanner(System.in);
        String [] details=new String[4];

        System.out.println("enter name ");
        details[0]=scanner.nextLine();
        System.out.println("enter gender Male or Female ");
        details[1]=scanner.nextLine();
        System.out.println("enter data of birth ");
        details[2]=scanner.nextLine();
        System.out.println("enter address");
        details[3]=scanner.nextLine();
        return details;
    }
    public static void printAllManager(Hashtable<Integer, Manager> managerHashtable){
        for(Map.Entry<Integer, Manager> managerEntry: managerHashtable.entrySet()){
            System.out.println("Manager ID: "+ managerEntry.getValue().getId()+ " Manager Name: " + managerEntry.getValue().getName());
        }
    }
    public static void printAllEmployee(Hashtable<Integer, Manager> managerHashtable){
        for(Map.Entry<Integer, Manager> managerEntry: managerHashtable.entrySet()){
            System.out.println("Manager ID: "+ managerEntry.getValue().getId()+ " Manager Name: " + managerEntry.getValue().getName());
            Util.printAllFTEmployee(managerEntry.getValue());
            Util.printAllIntern(managerEntry.getValue());
        }
    }
    public static void printAllFTEmployee(Hashtable<Integer, Manager> managerHashtable){
        for(Map.Entry<Integer, Manager> managerEntry: managerHashtable.entrySet()){
            System.out.println("Manager ID: "+ managerEntry.getValue().getId()+ " Manager Name: " + managerEntry.getValue().getName());
            Util.printAllFTEmployee(managerEntry.getValue());
        }
    }
    public static void printAllIntern(Hashtable<Integer, Manager> managerHashtable){
        for(Map.Entry<Integer, Manager> managerEntry: managerHashtable.entrySet()){
            System.out.println("Manager ID: "+ managerEntry.getValue().getId()+ " Manager Name: " + managerEntry.getValue().getName());
            Util.printAllIntern(managerEntry.getValue());
        }
    }


    public static void printAllFTEmployee(Manager manager){
        System.out.println("fTEmployees in given list are: ");
        for(Map.Entry<Integer, FTEmployee> ftEmployeeEntry : manager.fTEmployeeUnderThisManager.entrySet()){
            System.out.println("fTEmployee ID: "+ ftEmployeeEntry.getValue().getId()+ " FTEmployee Name: " + ftEmployeeEntry.getValue().getName());
            System.out.println();
        }
    }
    public static void printAllIntern(Manager manager){
        System.out.println("Intern in given list are: ");
        for(Map.Entry<Integer, Intern> internEntry: manager.internUnderThisManager.entrySet()){
            System.out.println("Intern ID: "+ internEntry.getValue().getId()+ " Intern Name: " + internEntry.getValue().getName());
        }
        System.out.println();
    }
    public static void printEmployeeDetailUsingID(People people){
        System.out.println("ID: " + people.getId()+ " name: " + people.getName());

    }

    public static void printEmployeeAllAttendance(Hashtable<LocalDate, ArrayList<InOutTime>> inOutHistory){
        for(Map.Entry<LocalDate, ArrayList<InOutTime>> inOutEntry: inOutHistory.entrySet()){
            System.out.println("Date: "+ inOutEntry.getKey().toString());
            for(InOutTime inOutTime: inOutEntry.getValue()){
                ///TODO: may give null pointer exception on null value of outTime;
                if(inOutTime.outTime==null){
                    System.out.print("\tInTime: " + inOutTime.inTime+ " outTime: "+ " null "+" timeSpend: "+ " null\n");

                }
                else {
                    System.out.print("\tInTime: " + inOutTime.inTime+ " outTime: "+ inOutTime.outTime+" timeSpend: "+ ChronoUnit.MINUTES.between(inOutTime.inTime, inOutTime.outTime)+"\n");

                }
            }
            System.out.println();
            Object obj;
        }
    }


}
