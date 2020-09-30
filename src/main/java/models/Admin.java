package models;

import dao.AdminDao;

import java.util.Objects;

public class Admin {
    public String name;
    public int id;
    public String email;

    public Admin(String name, int id, String email){
        this.name = name;
        this.id= id;
        this.email = email;



    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
