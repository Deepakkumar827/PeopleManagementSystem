package people;



import java.util.HashMap;

public class People {


    public static HashMap<Integer, People> allPeople=new HashMap<>();
    static int count=0;  /// it is total people who have registered not total current people
    private int id;
    private String name;
    private String gender;
    private String DOB;
    private String address;

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
        return People.allPeople.remove(id)!=null;
    }
    public int totalCurrentPeople(){
        return People.allPeople.size();
    }
    public void removePeople(int id){
        People people=People.allPeople.get(id);
        if(people==null) return;
        if(people.getClass().toString().equals(Manager.class.toString())){
            CEO.getCEO().getAllManager().remove(id);
        }
        else if(people.getClass().toString().equals(Intern.class.toString())){

        }


        People.allPeople.remove(id);
    }


}
