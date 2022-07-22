package controller;

import allData.AllEmployeeData;
import leave.AllLeaveTask;
import people.*;

import java.time.LocalDateTime;
import java.util.Scanner;


public class Controller {
    Scanner scanner = new Scanner(System.in);

    public void mainMenu() {
        while (true) {
            System.out.println("------------------------");
            System.out.println("Main Menu");
            System.out.println("enter\n 0. exit 1. Attendance Menu " +
                    " 2. leave tracking menu" +
                    " 4. ceo menu " +
                    " 5. manager menu " +
                    " 6. full time employee menu " +
                    " 7. intern menu ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("              <<<<ATTENDANCE MENU>>>>");
                    attendanceMenu();
                    break;
                case 2:
                    leaveTrackerMenu();
                    break;
                case 3:
                    ////for future
                    break;
                case 4:
                    cEOMenu();
                    break;

                case 5:
                    if (CEO.getCEO() == null) {
                        System.out.println("CEO doesn't assigned, so manager can't exist");
                        break;
                    }
                    System.out.println("put manager ID");
                    int key = scanner.nextInt();
                    if (CEO.getCEO().getAllManager().contains(key)) {
                        managerMenu((Manager) AllEmployeeData.allEmployee.get(key));
                    } else {
                        System.out.println("manager doesn't exist ");
                    }
                    break;
                case 6:
                    fTEmployeeMenu();
                    break;
                case 7:
                    internMenu();
                default:
                    break;
            }
            if (option == 0) break;


        }
    }

    private void attendanceMenu() {
        while (true) {
            System.out.println("[enter 0. exit 1. checkIn 2. checkout 3. checkAllTimeSpend]  and ID");
            System.out.print("Option: ");
            int option = scanner.nextInt();

            if (option == 0) return;


            System.out.print("\nID: ");
            int iD = scanner.nextInt();
            int a = 0;

            if (!AllEmployeeData.allEmployee.containsKey(iD)) {
                System.out.println("\nuser doesn't exist");
                continue;
            }
            Employee currentEmployee = AllEmployeeData.allEmployee.get(iD);

            switch (option) {
                case 1:
                    System.out.println("enter date time in yyyy-mm-ddThh:mm:ss format");
                    String inDateTimeString = scanner.next();
                    LocalDateTime inDateTime;
                    try {
                        inDateTime = LocalDateTime.parse(inDateTimeString);
                    } catch (Exception e) {
                        System.out.println(e);
                        break;
                    }
                    if (currentEmployee.checkIn(inDateTime)) {
                        System.out.println("success");
                    } else {
                        System.out.println("failed");
                    }
                    break;
                case 2:
                    System.out.println("enter date time in yyyy-mm-ddThh:mm:ss format");
                    String outDateTimeString = scanner.next();
                    LocalDateTime outDateTime;
                    try {
                        outDateTime = LocalDateTime.parse(outDateTimeString);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                    if (currentEmployee.checkOut(outDateTime)) {
                        System.out.println("success");
                    } else {
                        System.out.println("failed");
                    }
                    break;
                case 3:
                    if (currentEmployee.getInOutHistory().size() == 0) {
                        System.out.println("no data available");
                        break;
                    }
                    System.out.println("checkin out summery of employee ID: " + currentEmployee.getId() + " employee name: " + currentEmployee.getName() + " are: ");
                    Util.printEmployeeAllAttendance(currentEmployee.getInOutHistory());
                    System.out.println();

                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    break;

            }


            System.out.println();
        }
    }

    private void leaveTrackerMenu() {
        System.out.println("\n|||||||||||||||||||||||||| <> LEAVE TRACKER MENU <> |||||||||||||||||\n");
        while (true) {
            System.out.println("enter 0. exit" +
                    "1. apply for leave" +
                    "2. manage leave request by reporting person" +
                    "3. check leave request status");
            int choice = scanner.nextInt();
            if (choice == 0) {
                System.out.println("exit");
                return;
            }
            switch (choice) {
                case 1 -> {
                    System.out.println("enter employee id: ");
                    int iD = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("your name is " + AllEmployeeData.allEmployee.get(iD).getName());
                    System.out.println("direct reporting person is : " + AllEmployeeData.allEmployee.get(AllEmployeeData.allEmployee.get(iD).getDRP()).getName() + "ID is " + AllEmployeeData.allEmployee.get(iD).getDRP());
                    System.out.println("enter starting date in yyyy-mm-dd format");
                    String fromDate = scanner.nextLine();
                    System.out.println("enter ending date in yyyy-mm-dd format");
                    String toDate = scanner.nextLine();
                    System.out.println("enter reason");
                    String reason = scanner.nextLine();
                    int responseID = AllLeaveTask.requestForLeave(AllEmployeeData.allEmployee.get(iD), fromDate, toDate, reason);
                    if (responseID == 0) {
                        System.out.println("something went wrong");
                    } else {
                        System.out.println("your response id is " + responseID);
                    }
                }
                case 2 -> {
                    System.out.println("manage leave request menu enter id");
                    int currentID = scanner.nextInt();
                    AllLeaveTask.manageRequest(AllEmployeeData.allEmployee.get(currentID));
                }
                case 3 -> {
                    System.out.println("manage check request |enter request id");
                    int reqID = scanner.nextInt();
                    char response = AllLeaveTask.checkStatus(reqID);
                    if (response == 'x') System.out.println("either id is wrong or your request is not approved");
                    else if (response == '0') System.out.println("still pending"); //
                    else if (response == 'F') System.out.println("Rejected");
                    else if (response == 'T') System.out.println("Accepted");
                    else System.out.println("error" + response);
                }
                default -> {
                    System.out.println("incorrect response");
                    ;
                }
            }

        }
    }

    private void cEOMenu() {
        while (true) {
            System.out.println("enter\n 0. back" +
                    "1. show ceo details" +
                    "2. show all manager details" +
                    "3. show all fTEmployee details" +
                    "4. show all intern details" +
                    "5. show all people details " +
                    "6 check people by ID " +
                    "7. assign ceo" +
                    "8. add new manager" +
                    "9. remove manager");

            int option = scanner.nextInt();
            if (option == 0) return;
            switch (option) {
                case 1:
                    if (!CEO.isCEOAssigned()) {
                        System.out.println("CEO doesn't exist");
                    } else {
                        System.out.println("ceo id: " + AllEmployeeData.currentCEO.getId() + " name : " + AllEmployeeData.currentCEO.getName());
                    }
                    break;
                case 2:
                    if (CEO.getCEO() == null) {
                        System.out.println("without CEO doesn't manager doesn't exist");
                        break;
                    }
                    if (CEO.getCEO().getAllManager().size() == 0) {

                        System.out.println("no manager is assigned ");
                        break;
                    }
                    System.out.println("ceo id: " + AllEmployeeData.currentCEO.getId() + " name : " + AllEmployeeData.currentCEO.getName());
                    Util.printAllManager(CEO.getCEO().getAllManager());
                    break;
                case 3:
                    if (CEO.getCEO().getAllManager().size() == 0) {
                        System.out.println("no manager FTEmployee is assigned ");
                        break;
                    }
                    System.out.println("ceo id: " + AllEmployeeData.currentCEO.getId() + " name : " + AllEmployeeData.currentCEO.getName());
                    Util.printAllFTEmployee(CEO.getCEO().getAllManager());
                    break;
                case 4:
                    if (CEO.getCEO().getAllManager().size() == 0) {
                        System.out.println("no manager and Intern is assigned ");
                        break;
                    }
                    System.out.println("ceo id: " + AllEmployeeData.currentCEO.getId() + " name : " + AllEmployeeData.currentCEO.getName());
                    Util.printAllIntern(CEO.getCEO().getAllManager());
                    break;
                case 5:
                    if (CEO.getCEO().getAllManager().size() == 0) {
                        System.out.println("no manager and other employees are assigned ");
                        break;
                    }
                    System.out.println("ceo id: " + AllEmployeeData.currentCEO.getId() + " name : " + AllEmployeeData.currentCEO.getName());
                    Util.printAllEmployee(CEO.getCEO().getAllManager());
                    break;

                case 6:
                    System.out.print("Enter ID: ");
                    int currentID = scanner.nextInt();
                    if (AllEmployeeData.allEmployee.containsKey(currentID)) {
                        System.out.println();
                        Util.printEmployeeDetailUsingID(currentID);

                    } else {
                        System.out.println("\ndoesn't exist");
                    }
                    break;
                case 7:
                    if (CEO.isCEOAssigned()) {
                        System.out.println("CEO is already assigned");
                        break;
                    }
                    System.out.println("assigning CEO");
                    String[] ceoDetails = Util.getPeopleDetails();
                    CEO.createCEO(ceoDetails[0], ceoDetails[1], ceoDetails[2], ceoDetails[3]);
                    System.out.println("CEO is assigned");
                    break;
                case 8:
                    String[] managerDetails = Util.getPeopleDetails();
                    Manager manager = CEO.createManager(managerDetails[0], managerDetails[1], managerDetails[2], managerDetails[3]);
                    System.out.println("manager created with id= " + manager.getId());
                    break;

                case 9:
                    break;

                default:
                    break;


            }
            System.out.println();


        }

    }

    private void managerMenu(Manager manager) {
        Util.printEmployeeDetailUsingID(manager.getSuperiorID());
        while (true) {
            System.out.println("Enter \n 0. exit " +
                    " 1. view employee under this manager" +
                    " 2. view employee using id" +
                    " 3. add full time employee " +
                    " 4. add intern " +
                    " 5. edit employee(not available)" +
                    " 6. delete employee" +
                    " 7. see attendance using id" +
                    " 8. my information");

            int option = scanner.nextInt();
            if (option == 0) return;
            switch (option) {
                case 1:
                    Util.printAllFTEmployee(manager);
                    Util.printAllIntern(manager);
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    int currentID = scanner.nextInt();
                    if (manager.internUnderThisManager.contains(currentID)) {
                        System.out.println();
                        Util.printEmployeeDetailUsingID(currentID);
                    } else if (manager.fTEmployeeUnderThisManager.contains(currentID)) {
                        Util.printEmployeeDetailUsingID(currentID);
                    } else {
                        System.out.println("either user doesn't exist or not comes under you");
                    }
                    break;


                case 3:
                    String[] details = Util.getPeopleDetails();
                    if (manager.addFTEmployee(details[0], details[1], details[2], details[3])) {
                        System.out.println("succeed");
                    } else {
                        System.out.println("failed");
                    }
                    break;

                case 4:
                    String[] details2 = Util.getPeopleDetails();

                    if (manager.addIntern(details2[0], details2[1], details2[2], details2[3])) {
                        System.out.println("succeed");
                    } else {
                        System.out.println("failed");
                    }
                    break;

                case 6:
                    System.out.println("enter id of employee to delete");
                    int id6 = scanner.nextInt();
                    if (manager.deleteEmployeeUnderThisManager(id6)) {
                        System.out.println("success");
                    } else {
                        System.out.println("failed");
                    }
                default:
                    System.out.println("invalid input");
                    break;

            }
        }
    }

    private void fTEmployeeMenu() {

    }

    private void internMenu() {

    }


}
