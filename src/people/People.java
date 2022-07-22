package people;



import allData.AllEmployeeData;

public class People {


    static int count=0;  /// it is total people who have registered not total current people
    private final int id;
    private final String name;
    private final String gender;
    private final String DOB;
    private final String address;

    public People(String name, String gender, String DOB, String address) {
//        int curr=count+1;
//        if(!allPeople.containsKey(curr)){
//            this.id = curr;
//        }
//        else {
//            while (curr<Integer.MAX_VALUE){
//                if(!allPeople.containsKey(curr)){
//                    this.id=curr;
//                    break;
//                }
//                else curr++;
//            }
//        }
        this.id=++count;
        this.name = name;
        this.gender = gender;
        this.DOB = DOB;
        this.address = address;
    }






    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDOB() {
        return DOB;
    }

    public String getAddress() {
        return address;
    }

    public boolean deletePeople(int id){
        return AllEmployeeData.allEmployee.remove(id)!=null;
    }
    public int totalCurrentPeople(){
        return AllEmployeeData.allEmployee.size();
    }
    /*public void removePeople(int id) {
        People people = AllEmployeeData.allEmployee.get(id);
        if (people == null) return;
        if (people.getClass().toString().equals(Manager.class.toString())) {
            CEO.getCEO().getAllManager().remove(id);
        } else if (people.getClass().toString().equals(Intern.class.toString())) {

        }


        AllEmployeeData.allEmployee.remove(id);
    }*/


}
