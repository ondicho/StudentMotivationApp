package dao;
import models.user;
import models.Motivation;

public interface StaffDao {
    void  deleteById(int userId);
    void add(Category category);
}
