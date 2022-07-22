package allData;

import people.CEO;
import people.Employee;

import java.util.Hashtable;

public final class AllEmployeeData {


    public static CEO currentCEO;
    public static Hashtable<Integer, Employee> allEmployee=new Hashtable<>();

    private AllEmployeeData(){}
}
