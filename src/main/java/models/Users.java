package models;

public class Users {

    private String name;
    private int age;
    private int id;
    private String email;
    private String gender;


    public Users(String name, int age, int id, String email, String gender){
        this.name = name;
        this.age = age;
        this.id = id;
        this.email = email;
        this.gender = gender;

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
    public String getGender(){
        return gender;
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
    public void setGender(){
        this.gender = gender;
    }

}