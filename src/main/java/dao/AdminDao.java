package dao;

import models.user;

import java.util.List;

public interface AdminDao {
    void add(user user);

    List<user> getAll();

    void deleteById(int id);


}
