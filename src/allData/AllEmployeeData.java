package allData;

import people.CEO;
import people.Employee;

import java.util.Hashtable;

public final class AllEmployeeData {


    public static Hashtable<Integer, Employee> allEmployee=new Hashtable<>();
    public static CEO currentCEO;

    private AllEmployeeData(){}
}
