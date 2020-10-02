package dao;
import models.user;
import models.Motivation;
import models.Category;

public interface StaffDao {
    void  deleteMotivationByUserId(user user,Motivation motivation);
    void add(Category category);
}
