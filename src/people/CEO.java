package people;

import allData.AllEmployeeData;

import java.util.Set;
import java.util.TreeSet;

////Note:
//since any company can have only one CEO, so so many field and function is static;

public class CEO extends Employee{
    ///since there will be only one CEO, so we can use static field
//    private Hashtable<Integer, Manager> allManager=new Hashtable<>();
    private final Set<Integer> allManager=new TreeSet<>();

    private CEO(String name, String gender, String  DOB,String address) {
        super(name, gender, DOB, address);

    }

    public static boolean createCEO(String name, String gender, String DOB, String address){
        if(AllEmployeeData.currentCEO==null){
            AllEmployeeData.currentCEO=new CEO(name, gender, DOB, address);
            AllEmployeeData.currentCEO.superiorID = AllEmployeeData.currentCEO.getId();  ////superior is itself
            AllEmployeeData.currentCEO.dRP= getCEO().getId();  ///for now superior id and drp is same
            AllEmployeeData.allEmployee.put(CEO.getCEO().getId(), CEO.getCEO());
            return true;
        }
        else return false;
    }
    public static CEO getCEO(){
        return AllEmployeeData.currentCEO;
    }
    public static boolean isCEOAssigned(){
        return AllEmployeeData.currentCEO!=null;
    }
    public Set<Integer> getAllManager(){
        return getCEO().allManager;
    }
    public Manager getManager(int iD){
        if(CEO.getCEO().allManager.contains(iD)){
            return (Manager) AllEmployeeData.allEmployee.get(iD);
        }
        return null;
    }
    public static Manager createManager(String name, String gender, String DOB, String address){
        return createManager(new Manager(name, gender, DOB, address));
    }
    public static Manager createManager(Manager manager){
        manager.superiorID = getCEO().getId();
        manager.dRP= getCEO().getId();  ///for now superior id and drp is same
        AllEmployeeData.allEmployee.put(manager.getId(), manager);
        getCEO().allManager.add(manager.getId());
        return manager;
    }
    public static boolean removeManager(int id){
        ///TODO: to decide the return type of this function
        /////return false if id is not present, else it will be deleted and returned true;
        return getCEO().allManager.remove(id) && AllEmployeeData.allEmployee.remove(id)!=null;
    }

}
