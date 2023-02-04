
package finalproject;


public class data {
    private String name ;
    private String id;
    private String PAS ;
    private String nat;
    private String phone ;
    private String gender;
    private String address ;
    private String dob;
    private String pos ;
    private String sal;
    private String bon ;
    
    public data(String name,String id,String PAS,String nat,String phone ,String gender,String address,String dob,String pos,String sal,String bon){
       this.name=name; 
       this.id=id;
       this.PAS=PAS; 
       this.nat=nat;
       this.phone=phone; 
       this.gender=gender;
       this.address=address; 
       this.dob=dob;
       this.pos=pos;
       this.sal=sal;
       this.bon=bon; 
        
    }

    public String getName() {return name;}

    public String getId() { return id; }

    public String getPAS() {
        return PAS;
    }

    public String getNat() {
        return nat;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getDob() {
        return dob;
    }

    public String getPos() {
        return pos;
    }

    public String getSal() {
        return sal;
    }

    public String getBon() {
        return bon;
    }


}
