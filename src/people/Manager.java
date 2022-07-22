package people;

import allData.AllEmployeeData;

import java.util.Set;
import java.util.TreeSet;

public class Manager extends Employee {
//    public  Hashtable<Integer, FTEmployee> fTEmployeeUnderThisManager= new Hashtable<>(); //full time employee under this manager
    public Set<Integer> fTEmployeeUnderThisManager=new TreeSet<>();

    public  Set<Integer> internUnderThisManager=new TreeSet<>(); //// intern under this manager

    protected Manager(String name, String gender, String DOB, String address) {
        super(name, gender, DOB, address);
    }



    public boolean addFTEmployee(String name, String gender, String DOB, String address){
        return addFTEmployee(new FTEmployee(name, gender, DOB, address));
    }
    public boolean addIntern(String name, String gender, String DOB, String address){
        return addIntern(new Intern(name, gender, DOB, address));
    }

    public boolean addFTEmployee(FTEmployee ftEmployee){
        ftEmployee.superiorID =this.getId();
        ftEmployee.dRP= this.getId();  ///for now superior id and drp is same
        AllEmployeeData.allEmployee.put(ftEmployee.getId(), ftEmployee);
        fTEmployeeUnderThisManager.add(ftEmployee.getId());
        return true;
    }

    public boolean addIntern(Intern intern){
        intern.superiorID =this.getId();
        intern.dRP= this.getId();  ///for now superior id and drp is same
        AllEmployeeData.allEmployee.put(intern.getId(), intern);
        internUnderThisManager.add(intern.getId());
        return true;
    }


   /*
    private boolean addEmployee(People people){
        if(people.getClass().toString().equals(FTEmployee.class.toString())){
            People.allPeople.put(people.getId(), people);
            fTEmployeeUnderThisManager.put(people.getId(), people);
            return true;
        }
        else if(people.getClass().toString().equals(Intern.class.toString())){
            People.allPeople.put(people.getId(), people);
            internUnderThisManager.put(people.getId(), people);
            return true;
        }
        else {
            System.out.println("don't have features to add this types of employee");
            return false;
        }

    }*/

    public    boolean deleteFTEmployee(int id){
        if(fTEmployeeUnderThisManager.contains(id)){
            return fTEmployeeUnderThisManager.remove(id) && AllEmployeeData.allEmployee.remove(id)!=null;
        }

        else return false;
    }
    public  boolean deleteIntern(int id){
        ///TODO: to decide the return type of this function
        if(internUnderThisManager.contains(id)){
            return internUnderThisManager.remove(id) && AllEmployeeData.allEmployee.remove(id)!=null;
        }

        else return false;
    }
    public boolean deleteEmployeeUnderThisManager(int id){
        if(fTEmployeeUnderThisManager.contains(id)){
            return fTEmployeeUnderThisManager.remove(id) && AllEmployeeData.allEmployee.remove(id)!=null;
        }
        else if(internUnderThisManager.contains(id)){
            return internUnderThisManager.remove(id) && AllEmployeeData.allEmployee.remove(id)!=null;
        }
        return false;
    }

}
