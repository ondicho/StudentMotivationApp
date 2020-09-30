package dao;

import models.Users;

import java.util.List;

public interface UsersDao {
    //save user information
    void save(Users users);
    //list all users
    List<Users> getAll();
    //find user by id
    Users findById(int id);
    //delete a user
    void deleteById(int id);
    //delete all users
    void clearAll();
}