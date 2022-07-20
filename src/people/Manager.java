package people;

import java.util.Hashtable;

public class Manager extends Employee {
    public  Hashtable<Integer, FTEmployee> fTEmployeeUnderThisManager= new Hashtable<>(); //full time employee under this manager
    public  Hashtable<Integer, Intern> internUnderThisManager=new Hashtable<>(); //// intern under this manager

    protected Manager(String name, String gender, String DOB, String address) {
        super(name, gender, DOB, address);
    }



    public boolean addFTEmployee(String name, String gender, String DOB, String address){
        return addFTEmployee(new FTEmployee(name, gender, DOB, address,this.getId()));
    }
    public boolean addIntern(String name, String gender, String DOB, String address){
        return addIntern(new Intern(name, gender, DOB, address,this.getId()));
    }

    public boolean addFTEmployee(FTEmployee ftEmployee){
        Employee.allEmployee.put(ftEmployee.getId(), ftEmployee);
        fTEmployeeUnderThisManager.put(ftEmployee.getId(), ftEmployee);
        return true;
    }

    public boolean addIntern(Intern intern){
        Employee.allEmployee.put(intern.getId(), intern);
        internUnderThisManager.put(intern.getId(), intern);
        return true;
    }


   /* private boolean addEmployee(People people){
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
            System.out.println("dont have features to add this types of employee");
            return false;
        }

    }*/

    public    boolean deleteFTEmployee(int id){
        if(fTEmployeeUnderThisManager.get(id)!=null){
            return fTEmployeeUnderThisManager.remove(id)!=null && Employee.allEmployee.remove(id)!=null;
        }

        else return false;
    }
    public  boolean deleteIntern(int id){
        ///TODO: to decide the return type of this function
        if(internUnderThisManager.get(id)!=null){
            return internUnderThisManager.remove(id)!=null && Employee.allEmployee.remove(id)!=null;
        }

        else return false;
    }

}
