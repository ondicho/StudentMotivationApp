package models;

public class user {

    private String name;
    private int age;
    private int id;
    private String email;
    private String department;
    private int phoneNumber;

    public user(int id,String name, int age, String email, String department, int phoneNumber){
        this.name = name;
        this.age = age;
        this.id = id;
        this.email = email;
        this.department = department;
        this.phoneNumber = phoneNumber;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
    public int getId(){
        return id;
    }
    public String getEmail(){
        return email;
    }
    public String getDepartment(){
        return department;
    }
    public int getPhoneNumber(){
        return phoneNumber;
    }
    public void setName(){
        this.name = name;
    }
    public void setAge(){
        this.age = age;
    }
    public void setId(int id){
        this.id = this.id;
    }
    public void setEmail(){
        this.email = email;
    }
    public void setDepartment(){
        this.department = department;
    }
    public void setPhoneNumber(){
        this.phoneNumber = phoneNumber;
    }
}
