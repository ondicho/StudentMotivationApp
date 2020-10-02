package dao;

import models.Motivation;
import models.user;

import java.util.List;

public interface userDao {


    void add(user user);
    void add(Motivation motivation);

    List<user> getAll();
    user findById(int id);

    void deleteById(int id);

    void clearAll();
}
