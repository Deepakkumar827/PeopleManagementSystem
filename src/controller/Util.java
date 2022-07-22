package controller;

import allData.AllEmployeeData;
import people.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public final class Util {
    public static String[] getPeopleDetails() {
        Scanner scanner = new Scanner(System.in);
        String[] details = new String[4];

        System.out.println("enter name ");
        details[0] = scanner.nextLine();
        System.out.println("enter gender Male or Female ");
        details[1] = scanner.nextLine();
        System.out.println("enter data of birth ");
        details[2] = scanner.nextLine();
        System.out.println("enter address");
        details[3] = scanner.nextLine();
        return details;
    }

    public static void printAllManager(Set<Integer> managerSet) {
        for (Integer iD : managerSet) {
            System.out.println("Manager ID: " + iD + " Manager Name: " + AllEmployeeData.allEmployee.get(iD).getName() + "Superior: " + AllEmployeeData.allEmployee.get(iD).getSuperiorName());
        }
    }

    public static void printAllEmployee(Set<Integer> allManagerID) {
        for (int managerID : allManagerID) {
            System.out.println("Manager ID: " + managerID + " Manager Name: " + AllEmployeeData.allEmployee.get(managerID).getName() + "Superior: " + AllEmployeeData.allEmployee.get(managerID).getSuperiorName());
            Util.printAllFTEmployee(((Manager) AllEmployeeData.allEmployee.get(managerID)));
            Util.printAllIntern(((Manager) AllEmployeeData.allEmployee.get(managerID)));
        }
    }

    public static void printAllFTEmployee(Set<Integer> managerSet) {
        for (int iD : managerSet) {
//            System.out.println("FTEmployee ID: "+ iD+ " Name: " + Employee.allEmployee.get(iD).getName()+ "Superior: "+ Employee.allEmployee.get(iD).getSuperiorName());
            Util.printAllFTEmployee((Manager) AllEmployeeData.allEmployee.get(iD));
        }
    }

    public static void printAllIntern(Set<Integer> internSet) {
        for (int iD : internSet) {
            Util.printAllIntern((Manager) AllEmployeeData.allEmployee.get(iD));
        }
        System.out.println();
    }


    public static void printAllFTEmployee(Manager manager) {
        System.out.println("Manager ID: " + manager.getId() + " Manager Name: " + manager.getName() + "Superior: " + manager.getSuperiorName());
        System.out.println("fTEmployees under manager are: ");
        for (int iD : manager.fTEmployeeUnderThisManager) {
            System.out.println("fTEmployee ID: " + iD + " FTEmployee Name: " + AllEmployeeData.allEmployee.get(iD).getName() + " Superior: " + AllEmployeeData.allEmployee.get(iD).getSuperiorName());
            System.out.println();
        }
    }

    public static void printAllIntern(Manager manager) {
        System.out.println("Manager ID: " + manager.getId() + " Manager Name: " + manager.getName() + "Superior: " + manager.getSuperiorName());
        System.out.println("Intern in given list are: ");
        for (int iD : manager.internUnderThisManager) {
            System.out.println("Intern ID: " + iD + " Intern Name: " + AllEmployeeData.allEmployee.get(iD).getName() + "Superior: " + AllEmployeeData.allEmployee.get(iD).getSuperiorName());
        }
        System.out.println();
    }

    public static void printEmployeeDetailUsingID(int iD) {
        Employee people = AllEmployeeData.allEmployee.get(iD);
        System.out.println("ID: " + people.getId() + " name: " + people.getName() + " Superior : " + people.getSuperiorName());

    }

    public static void printEmployeeAllAttendance(Hashtable<LocalDate, ArrayList<InOutTime>> inOutHistory) {
        for (Map.Entry<LocalDate, ArrayList<InOutTime>> inOutEntry : inOutHistory.entrySet()) {
            System.out.println("Date: " + inOutEntry.getKey().toString());
            for (InOutTime inOutTime : inOutEntry.getValue()) {
                ///TODO: may give null pointer exception on null value of outTime;
                if (inOutTime.outTime == null) {
                    System.out.print("\tInTime: " + inOutTime.inTime + " outTime: " + " null " + " timeSpend: " + " null\n");

                } else {
                    System.out.print("\tInTime: " + inOutTime.inTime + " outTime: " + inOutTime.outTime + " timeSpend: " + ChronoUnit.MINUTES.between(inOutTime.inTime, inOutTime.outTime) + "\n");

                }
            }
            System.out.println();
            Object obj;
        }
    }


}
