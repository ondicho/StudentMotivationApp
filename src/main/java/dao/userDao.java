package dao;

import models.user;

import java.util.List;

public interface userDao {


    void add(user user);

    List<user> getAll();
    user findById(int id);

    void deleteById(int id);

    void clearAll();
}
