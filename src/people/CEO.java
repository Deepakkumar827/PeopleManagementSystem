package people;

import java.util.Hashtable;
import java.util.Set;
import java.util.TreeSet;

////Note:
//since any company can have only one CEO, so so many field and function is static;

public class CEO extends Employee{
    public static CEO currentCEO;
    ///since there will be only one CEO, so we can use static field
//    private Hashtable<Integer, Manager> allManager=new Hashtable<>();
    private final Set<Integer> allManager=new TreeSet<>();

    private CEO(String name, String gender, String  DOB,String address) {
        super(name, gender, DOB, address);

    }

    public static boolean createCEO(String name, String gender, String DOB, String address){
        if(CEO.currentCEO==null){
            CEO.currentCEO=new CEO(name, gender, DOB, address);
            CEO.currentCEO.superiorID =CEO.currentCEO.getId();  ////superior is itself
            CEO.currentCEO.dRP= getCEO().getId();  ///for now superior id and drp is same
            Employee.allEmployee.put(CEO.getCEO().getId(), CEO.getCEO());
            return true;
        }
        else return false;
    }
    public static CEO getCEO(){
        return currentCEO;
    }
    public static boolean isCEOAssigned(){
        return CEO.currentCEO!=null;
    }
    public Set<Integer> getAllManager(){
        return getCEO().allManager;
    }
    public Manager getManager(int iD){
        if(CEO.getCEO().allManager.contains(iD)){
            return (Manager) Employee.allEmployee.get(iD);
        }
        return null;
    }
    public static Manager createManager(String name, String gender, String DOB, String address){
        return createManager(new Manager(name, gender, DOB, address));
    }
    public static Manager createManager(Manager manager){
        manager.superiorID = getCEO().getId();
        manager.dRP= getCEO().getId();  ///for now superior id and drp is same
        Employee.allEmployee.put(manager.getId(), manager);
        getCEO().allManager.add(manager.getId());
        return manager;
    }
    public static boolean removeManager(int id){
        ///TODO: to decide the return type of this function
        /////return false if id is not present, else it will be deleted and returned true;
        return getCEO().allManager.remove(id) && Employee.allEmployee.remove(id)!=null;
    }

}
