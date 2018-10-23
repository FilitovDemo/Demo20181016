package tw.edu.tut.mis.demo1016;

public class Sample {

    private String Name, TEL, Address;

    //---------------------------------------------------------------
    //建構式

    // Sample x = new Sample();
    Sample(){
        Name = "無名氏";
        TEL = "";
        Address = "";
    }

    // Sample x = new Sample("張三","062532106","台南市");
    Sample( String name, String tel, String address ){
        Name = name;
        TEL = tel;
        Address = address;
    }

    //---------------------------------------------------------------
    //取用方式 get/set

    public String getName() {
        return Name;
    }

    public String getTEL() {
        return TEL;
    }

    public String getAddress() {
        return Address;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setTEL(String TEL) {
        this.TEL = TEL;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
