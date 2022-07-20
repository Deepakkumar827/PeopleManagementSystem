package controller;

import people.*;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Controller{
    Scanner scanner=new Scanner(System.in);

    public void mainMenu(){
        while (true){
            System.out.println("------------------------");
            System.out.println("Main Menu");
            System.out.println("enter\n 0. exit\n 1. ceo menu" +
                    "2. manager menu" +
                    "3. full time employee menu" +
                    "4. intern menu");
            int option=scanner.nextInt();
            switch (option){
                case 1:
                    cEOMenu();
                    break;
//                case 2:
//                    cEOMenu();
//                    break;
                case 2:
                    managerMenu();
                    break;
                case 3:
                    fTEmployeeMenu();
                    break;
                case 4:
                    internMenu();
                default:
                    break;
            }
            if(option==0) break;



        }
    }
    public void cEOMenu(){
        while (true){
            System.out.println("enter\n 0. back" +
                    "1. show ceo details" +
                    "2. show all manager details" +
                    "3. show all fTEmployee details" +
                    "4. show all intern details" +
                    "5. show all people details" +
                    "6. assign ceo" +
                    "7. add new manager" +
                    "8. remove manager");

            int option=scanner.nextInt();
            if(option==0) return;
            switch (option){
                case  1:
                    if(!CEO.isCEOAssigned()){
                        System.out.println("CEO doesn't exist");
                    }
                    else {
                        System.out.println("ceo id: "+ CEO.currentCEO.getId()+ " name : "+ CEO.currentCEO.getName());
                    }
                    break;
                case 2:
                    System.out.println("ceo id: "+ CEO.currentCEO.getId()+ " name : "+ CEO.currentCEO.getName());
                    for(Map.Entry<Integer, Manager> managerEntry: CEO.allManager.entrySet()){
                        System.out.println("Manager ID: "+ managerEntry.getValue().getId()+ " Manager Name: " + managerEntry.getValue().getName());
                    }
                    break;
                case 3:
                    System.out.println("ceo id: "+ CEO.currentCEO.getId()+ " name : "+ CEO.currentCEO.getName());
                    for(Map.Entry<Integer, Manager> managerEntry: CEO.allManager.entrySet()){
                        Manager currentManager=managerEntry.getValue();
                        System.out.println("Manager ID: "+ currentManager.getId()+ " Manager Name: " + currentManager.getName());
                        for(Map.Entry<Integer, FTEmployee> ftEmployeeEntry: currentManager.fTEmployeeUnderThisManager.entrySet()){
                            System.out.println("FTEmployee ID: "+ ftEmployeeEntry.getValue().getId()+ " FTEmployee Name: " + ftEmployeeEntry.getValue().getName());
                        }
                    }
                    break;
                case 4:
                    System.out.println("ceo id: "+ CEO.currentCEO.getId()+ " name : "+ CEO.currentCEO.getName());
                    for(Map.Entry<Integer, Manager> managerEntry: CEO.allManager.entrySet()){
                        Manager currentManager=managerEntry.getValue();
                        System.out.println("Manager ID: "+ currentManager.getId()+ " Manager Name: " + currentManager.getName());

                        for(Map.Entry<Integer, Intern> internEntry: currentManager.internUnderThisManager.entrySet()){
                            System.out.println("Intern ID: "+ internEntry.getValue().getId()+ " Intern Name: " + internEntry.getValue().getName());
                        }
                    }
                    break;
                case 5:
                    System.out.println("ceo id: "+ CEO.currentCEO.getId()+ " name : "+ CEO.currentCEO.getName());
                    for(Map.Entry<Integer, Manager> managerEntry: CEO.allManager.entrySet()){
                        Manager currentManager=managerEntry.getValue();
                        System.out.println("Manager ID: "+ currentManager.getId()+ " Manager Name: " + currentManager.getName());
                        for(Map.Entry<Integer, FTEmployee> ftEmployeeEntry: currentManager.fTEmployeeUnderThisManager.entrySet()){
                            System.out.println("FTEmployee ID: "+ ftEmployeeEntry.getValue().getId()+ " FTEmployee Name: " + ftEmployeeEntry.getValue().getName());
                        }
                        System.out.println();
                        for(Map.Entry<Integer, Intern> internEntry: currentManager.internUnderThisManager.entrySet()){
                            System.out.println("Intern ID: "+ internEntry.getValue().getId()+ " Intern Name: " + internEntry.getValue().getName());
                        }
                    }
                    break;


                case 6:
                    if(CEO.isCEOAssigned()){
                        System.out.println("CEO is already assigned");
                        break;
                    }
                    System.out.println("assigning CEO");
                    String [] ceoDetails=new String[4];
                    getPeopleDetails(ceoDetails);
                    CEO.createCEO(ceoDetails[0], ceoDetails[1], ceoDetails[2], ceoDetails[3]);
                    System.out.println("CEO is assigned");
                    break;
                case 7:
                    String [] managerDetails=new String[4];
                    getPeopleDetails(managerDetails);
                    Manager manager=CEO.createManager(managerDetails[0], managerDetails[1], managerDetails[2], managerDetails[3]);
                    System.out.println("manager created with id= " + manager.getId());
                    break;

                default:
                    break;




            }
            System.out.println();
            System.out.println("================================");


        }

    }
 
    public void managerMenu(){
        while (true){
            System.out.println("Enter \n 0. exit\n 1. ");
        }
    }
    public void fTEmployeeMenu(){

    }
    public void internMenu(){

    }
    public void getPeopleDetails(String [] details){
        System.out.println("enter name ");
        details[0]=scanner.nextLine();
        System.out.println("enter gender Male or Female ");
        details[1]=scanner.nextLine();
        System.out.println("enter data of birth ");
        details[2]=scanner.nextLine();
        System.out.println("enter address");
        details[3]=scanner.nextLine();
        return;
    }


}
