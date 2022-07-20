package people;

public class FTEmployee extends Employee{
    int managerId;
    protected FTEmployee(String name, String gender, String DOB, String address, int managerId) {
        super(name, gender, DOB, address);
        this.managerId=managerId;
    }

//    public Employee(String name, String gender, String DOB, String address, String managerName) {
//        super(name, gender, DOB, address);
//        this.managerName=managerName;
//    }

}
